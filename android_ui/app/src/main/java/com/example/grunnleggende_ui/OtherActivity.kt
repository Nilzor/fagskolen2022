package com.example.grunnleggende_ui

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OtherActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_layout)

        populateLandList()
    }

    private fun populateLandList() {
        val container = findViewById<LinearLayout>(R.id.container)
        for (country in CountryList.countries) {
            addCountryView(country, container)
        }
    }

    private fun addCountryView(countryName: String, container: LinearLayout) {
        val view = TextView(this)
        view.text = countryName
        view.textSize = 48.0F
        container.addView(view)
    }
}