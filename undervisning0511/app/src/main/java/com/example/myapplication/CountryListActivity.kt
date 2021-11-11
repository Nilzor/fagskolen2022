package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class CountryListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dynamic)

        startActivity(Intent(this, CountryListActivity::class.java))
        val container = findViewById<LinearLayout>(R.id.mysupercontainer)
        addTextView("Hei på deg", container)
    }

    fun populateCountryList() {
        val countries = Countries()
        countries.list

    }

    fun addTextView(text: String, container: LinearLayout) {
        val textView = TextView(this)
        textView.text = text
        container.addView(textView)
    }
}