package com.nilsenlabs.lifecycle

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.ActivityCompat


class MainActivity : AppCompatActivity() {
    val tag = "Skjerm1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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

    fun goToSecond(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    fun showOkDialog(view: View) {
        ActivityCompat.requestPermissions(
            this,
             arrayOf(Manifest.permission.CAMERA),
           0
        )
    }
}