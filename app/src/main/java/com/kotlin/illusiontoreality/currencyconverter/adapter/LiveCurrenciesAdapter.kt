package com.kotlin.illusiontoreality.currencyconverter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.illusiontoreality.currencyconverter.R
import com.kotlin.illusiontoreality.currencyconverter.pojo.Currency

/*
Adapter to show all live currencies with default initially and after update button pressed, with notify data set changed, show latest currencies
 */
class LiveCurrenciesAdapter (val currencyList: ArrayList<Currency>) : RecyclerView.Adapter<LiveCurrenciesAdapter.ViewHolder>() {

        //this method is returning the view for each item in the list
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveCurrenciesAdapter.ViewHolder {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.currency_item, parent, false)
            return ViewHolder(v)
        }

        //this method is binding the data on the list
        override fun onBindViewHolder(holder: LiveCurrenciesAdapter.ViewHolder, position: Int) {
            holder.bindItems(currencyList[position])
        }

        //this method is giving the size of the list
        override fun getItemCount(): Int {
            return currencyList.size
        }

        //the class is hodling the list view
        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            fun bindItems(currency: Currency) {
                val flag = itemView.findViewById(R.id.flag) as ImageView
                val code = itemView.findViewById(R.id.code) as TextView
                val name = itemView.findViewById(R.id.name) as TextView
                val value = itemView.findViewById(R.id.value) as TextView

                flag.setImageResource(currency.resID)
                code.text = currency.code + " (" + currency.symbol + ")"
                name.text = currency.name
                value.text = currency.value
            }
        }
}