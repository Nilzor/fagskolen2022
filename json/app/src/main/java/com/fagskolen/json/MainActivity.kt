package com.fagskolen.json

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.beust.klaxon.Klaxon
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textStream = loadAsset("countries.json")
        val countries = klaxonParse(textStream)
        present(countries)
    }

    fun loadAsset(name: String): InputStream {
        return applicationContext.resources.assets.open("countries.json")
    }

    fun klaxonParse(json: InputStream): List<Country> {
        val klaxon = Klaxon()
        val z = klaxon.parseArray<Country>(json)!!
        return z
    }

    fun present(countries: List<Country>) {
        for (country in countries) {
            Log.d("ZZZ", "$country")
        }
    }
}