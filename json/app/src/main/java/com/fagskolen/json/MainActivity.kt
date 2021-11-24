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

        produceStoreAndRetrieveJson()
    }

    private fun produceStoreAndRetrieveJson() {
        val klaxon = Klaxon()
        val person = Person("Harald Rex", 84)
        val personAsJson = klaxon.toJsonString(person)
        Log.d("zzz", "This person as JSON:\n$personAsJson")
        val prefs = applicationContext.getSharedPreferences("my", MODE_PRIVATE)
        prefs.edit().putString("person", personAsJson).commit()
        val readPersonAsJson = prefs.getString("person", null)!!
        val readPerson = klaxon.parse<Person>(readPersonAsJson)
        Log.d("zzz", "Person after writing and reading back to Shared Preferences: ${person.name}")
    }

    fun loadAsset(name: String): InputStream {
        return applicationContext.resources.assets.open("countries.json")
    }

    fun klaxonParse(json: InputStream): List<Country> {
        val klaxon = Klaxon()
        return klaxon.parseArray<Country>(json)!!
    }

    fun present(countries: List<Country>) {
        for (country in countries) {
            Log.d("ZZZ", "$country")
        }
    }
}