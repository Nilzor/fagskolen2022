package com.nilsenlabs.lifecycle

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    val tag = "Skjerm2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d(tag, "Created")
    }


    override fun onStart() {
        super.onStart()
        Log.d(tag, "Started")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "Stopped")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "Paused")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "Resumed")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "Restarted")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "Destroyed")
    }
}