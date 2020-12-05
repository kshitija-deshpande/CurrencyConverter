package com.kotlin.illusiontoreality.currencyconverter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.kotlin.illusiontoreality.currencyconverter.R
import com.kotlin.illusiontoreality.currencyconverter.utils.ExtendedCurrency

/*
Adapter to show currency to user so user can choose from the list for source/destination
*/

class CurrencyOptionAdapter(context: Context, val currencyList: ArrayList<ExtendedCurrency>, val isSource: Boolean) : BaseAdapter() {
    private val mInflator: LayoutInflater

    init {
        this.mInflator = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return currencyList.size
    }

    override fun getItem(position: Int): Any {
        return currencyList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view: View?
        val currency = currencyList[position]
        if (convertView == null) {
            view = this.mInflator.inflate(R.layout.currency_option_item, parent, false)
        } else {
            view = convertView
        }
        view?.findViewById<ImageView>(R.id.flag)?.setImageResource(currency.flag)
        // Show USD ($) i.e. currency code and symbol together
        view?.findViewById<TextView>(R.id.code)?.setText(currency.code + "("+currency.symbol+")")
        view?.findViewById<TextView>(R.id.name)?.setText(currency.name)
        return view
    }
}