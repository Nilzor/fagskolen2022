package com.example.grunnleggende_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dynamic)

        populateCountryList()
    }

    fun populateCountryList() {
        val countries = Countries()
        countries.list
        val container = findViewById<LinearLayout>(R.id.mysupercontainer)
        for (country in countries.list) {
            addTextView(country, container)
        }
    }

    fun addTextView(text: String, container: LinearLayout) {
        val textView = TextView(this)
        textView.text = text
        textView.textSize = 70.0F
        textView.setOnClickListener {
            Toast.makeText(this,"Du klikket ${textView.text}", Toast.LENGTH_SHORT).show()
        }
        container.addView(textView)
    }
}