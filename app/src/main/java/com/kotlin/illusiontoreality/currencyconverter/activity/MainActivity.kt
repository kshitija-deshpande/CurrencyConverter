package com.kotlin.illusiontoreality.currencyconverter.activity

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.illusiontoreality.currencyconverter.R
import com.kotlin.illusiontoreality.currencyconverter.adapter.CurrencyOptionAdapter
import com.kotlin.illusiontoreality.currencyconverter.adapter.LiveCurrenciesAdapter
import com.kotlin.illusiontoreality.currencyconverter.api.ConvertApi
import com.kotlin.illusiontoreality.currencyconverter.controller.CurrencyConverterController
import com.kotlin.illusiontoreality.currencyconverter.pojo.ConvertResponse
import com.kotlin.illusiontoreality.currencyconverter.pojo.Currency
import com.kotlin.illusiontoreality.currencyconverter.utils.AllCurencies
import com.kotlin.illusiontoreality.currencyconverter.utils.ExtendedCurrency
import com.kotlin.illusiontoreality.currencyconverter.viewmodel.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.math.RoundingMode
import java.text.DateFormat
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    // UI Elements need to be changed/accessed in this file
    private lateinit var updateButton : Button
    private lateinit var progressBar : ProgressBar
    private lateinit var updatedText : TextView

    private lateinit var sourceEditText: EditText
    private lateinit var destinationEditText: EditText

    // Data Part
    private var sourceCurrencySelected: ExtendedCurrency? = null
    private var destinationCurrencySelected: ExtendedCurrency? = null

    private lateinit var currencyList: ArrayList<Currency>

    // Adapter instnces required for notify data set changed
    private lateinit var liveCurrenciesAdapter : LiveCurrenciesAdapter

    // View Model for this screen
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Hide titlebar
        if (supportActionBar != null)
            supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        // Setup the view model
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)


        //Setup UI Elements
        // 1 UpdatedText - Top text to show when the currency fetch was happend last
        updatedText = findViewById(R.id.updated_text)
        updatedText.setText("Click on Update to refresh currency rates")

        // 2 Progress bar to show/hide when network request is going on
        progressBar = findViewById(R.id.progress_bar)

        // 3 Fetch currencies when update button is clicked, disable it when previous request is not finsihed
        updateButton = findViewById(R.id.update_button)
        updateButton.setOnClickListener {
            //Make network call based on which view is shown to user
            fetchCurrencies()
        }

        // 4 Initialize source and destination edit text to get input and show converted output
        sourceEditText = findViewById(R.id.source_currency_edit_text)
        destinationEditText = findViewById(R.id.destination_currency_edit_text)

        // 5 Init some currency initially
        sourceCurrencySelected = AllCurencies().getCurrencyByCode("USD")
        destinationCurrencySelected = AllCurencies().getCurrencyByCode("INR")
        updateSourceCurrency()
        updateDestinationCurrency()

        // 6 Until user request for network call, use default values
        CurrencyConverterController.addDefaultCurrencies()

        // 7 Exchange arrow click to flip the currencies
        findViewById<ImageButton>(R.id.exchange_button).setOnClickListener {
            val tempCurrencySelected = sourceCurrencySelected
            sourceCurrencySelected = destinationCurrencySelected
            destinationCurrencySelected = tempCurrencySelected

            updateSourceCurrency()
            updateDestinationCurrency()

            sourceEditText.setText("0")
            destinationEditText.setText("0")

            sourceEditText.clearFocus()
            hideKeyboard()
        }

        // 8 Update live list, recycle view
        currencyList = ArrayList<Currency>()
        getLiveRecords()
        liveCurrenciesAdapter = LiveCurrenciesAdapter(currencyList)
        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.adapter = liveCurrenciesAdapter

        val chartView = findViewById(R.id.chart_view) as TextView

        // 9 Click listeners for char button, live button
        findViewById<Button>(R.id.chart_button).setOnClickListener {
            recyclerView.visibility = View.GONE
            chartView.visibility = View.VISIBLE
        }

        findViewById<Button>(R.id.live_button).setOnClickListener {
            recyclerView.visibility = View.VISIBLE
            chartView.visibility = View.GONE
        }

        // 10 Click listener for Currency UI, user can click on anywhere
        findViewById<LinearLayout>(R.id.source_currency).setOnClickListener {
            showSourceDialog(true)
        }

        findViewById<LinearLayout>(R.id.destination_currency).setOnClickListener {
            showSourceDialog(false)
        }

        // 11 Text watcher to watch text change in source edit text
        val sourceEditTextTextWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                // Change the value of destination edit text based on value
                var value: Double
                if (s!!.length > 0) {
                    value = s.toString().toDouble()
                } else {
                    value = 0.0
                }

                // 12 Convert value, logic is in CurrencyConverterController
                val convert = CurrencyConverterController.convertFromTo(
                    sourceCurrencySelected?.code,
                    destinationCurrencySelected?.code,
                    value
                )
                // 13 Dont show so many decimal
                val df = DecimalFormat("#.##")
                df.roundingMode = RoundingMode.CEILING
                var output = (df.format(convert)).toDouble()

                // 14 Show formatted notation of long number 1.0 e^5
                if (output / 10000.0 > 1) {
                    destinationEditText.setText(formatInScientificNotation(output))
                } else {
                    destinationEditText.setText(output.toString())
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        }

        sourceEditText.addTextChangedListener(sourceEditTextTextWatcher)

        // 15 Focus change, set empty text for next number
        sourceEditText.setOnFocusChangeListener { view, b ->
            if (b == true) {
              sourceEditText.setText("")
            }
        }

    }

    // 16 Network call fetch currencies
    fun fetchCurrencies() {
        updateButton.isEnabled = false
        progressBar.visibility = View.VISIBLE
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(ConvertApi::class.java)
        val call = service.getLiveCurrency()

        // Enqueu call network
        call.enqueue(object : Callback<ConvertResponse> {
            override fun onResponse(call: Call<ConvertResponse>, response: Response<ConvertResponse>) {
                updateButton.isEnabled = true
                progressBar.visibility = View.GONE
                if (response.code() == 200) {
                    val date = Date()
                    updatedText.setText("Last Updated: " + DateFormat.getDateTimeInstance().format(date))
                    val convertResponse = response.body()
                    CurrencyConverterController.addAllTenCurrencies(convertResponse)
                    getLiveRecords()
                    liveCurrenciesAdapter.notifyDataSetChanged()
                }
            }
            override fun onFailure(call: Call<ConvertResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Could not process this request, please check your internet connection", Toast.LENGTH_SHORT).show()
                updateButton.isEnabled = true
                progressBar.visibility = View.GONE
            }
        })
    }

    // 16 Update source currency if user changed it, flipped it
    fun updateSourceCurrency() {
        findViewById<TextView>(R.id.src_code).setText(sourceCurrencySelected?.code + " (" + sourceCurrencySelected?.symbol+ ") ")
        findViewById<ImageView>(R.id.src_flag).setImageResource(sourceCurrencySelected?.flag!!)
    }

    // 17 Update destination currency if user changed it, flipped it
    fun updateDestinationCurrency() {
        findViewById<TextView>(R.id.dest_code).setText(destinationCurrencySelected?.code + " (" + destinationCurrencySelected?.symbol+ ") ")
        findViewById<ImageView>(R.id.dest_flag).setImageResource(destinationCurrencySelected?.flag!!)
    }

    // 18 Get live records in list of objects to show in recycler view
    private fun getLiveRecords(): ArrayList<Currency> {
        if (currencyList == null) {
            currencyList = ArrayList<Currency>()
        } else {
            currencyList.clear()
        }

       val allCurrency = AllCurencies().allCurrencies.iterator()
        while (allCurrency.hasNext()) {
            val currency = allCurrency.next()
            val value = CurrencyConverterController.get(currency.code)
            currencyList.add(Currency(currency.code, currency.name, currency.symbol, value.toString() , currency.flag))
        }

        return currencyList
    }

    //19 Show source/destination dialog to choose currency to convert
    private fun showSourceDialog(isSource: Boolean) {
        val alertDialog = AlertDialog.Builder(this)
        val rowList: View = layoutInflater.inflate(R.layout.option_list, null)
        val listView = rowList.findViewById(R.id.lv) as ListView
        val closeBtn = rowList.findViewById(R.id.close_btn) as Button
        val adapter = CurrencyOptionAdapter(this, AllCurencies().allCurrencies, isSource)
        listView.adapter = adapter
        adapter.notifyDataSetChanged()
        alertDialog.setView(rowList)
        val ad = alertDialog.show()

        // 20 Change the currency for source/destination
        listView.setOnItemClickListener { adapterView, view, i, l ->
            if (isSource) {
                sourceCurrencySelected = AllCurencies().allCurrencies[i]
                updateSourceCurrency()

            } else {
                destinationCurrencySelected = AllCurencies().allCurrencies[i]
                updateDestinationCurrency()
            }
            sourceEditText.setText("0")
            sourceEditText.clearFocus()
            hideKeyboard()
            ad.dismiss()
        }
        closeBtn.setOnClickListener {
            ad.dismiss()
        }
    }

    // 21 Hide keyboard if visible
    fun hideKeyboard() {
        val imm: InputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(sourceEditText.getWindowToken(), 0)
    }

    // 22 Format long number to 1.0 e^5 like that
    fun formatInScientificNotation(value: Double): String? {
        val baseFormat: NumberFormat = NumberFormat.getInstance(Locale.ENGLISH)
        baseFormat.setMinimumFractionDigits(1)
        if (java.lang.Double.isInfinite(value) || java.lang.Double.isNaN(value)) {
            return baseFormat.format(value)
        }
        var exp = Math.log10(Math.abs(value))
        exp = Math.floor(exp)
        val base = value / Math.pow(10.0, exp)
        val power: String = (exp.toLong()).toString()
        val s = StringBuilder()
        s.append(baseFormat.format(base))
        s.append("\u00d710")
        val len = power.length
        for (i in 0 until len) {
            val c = power[i]
            when (c) {
                '-' -> s.append('\u207b')
                '1' -> s.append('\u00b9')
                '2' -> s.append('\u00b2')
                '3' -> s.append('\u00b3')
                else -> s.append((0x2070 + (c - '0')).toChar())
            }
        }
        return s.toString()
    }

    // 23 Base URL defination
    companion object {
        var BaseUrl = "http://api.currencylayer.com/"
    }

}

