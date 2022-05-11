package no.fagskolen.uitests

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import no.fagskolen.uitests.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListeners()
    }

    private fun setupListeners() {
        setThreeSecondConnection(binding.buttonA, binding.radioA)
        setThreeSecondConnection(binding.buttonB, binding.radioB)
        binding.nextButton.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    private fun setThreeSecondConnection(button: Button, radio: RadioButton) {
        button.setOnClickListener {
            if (button == binding.buttonB && !binding.radioA.isChecked) {

            } else {
                radio.isChecked = true
                updateDependentState()
                lifecycleScope.launch {
                    delay(3000)
                    radio.isChecked = false
                    updateDependentState()
                }
            }
        }
    }

    private fun updateDependentState() {
        binding.nextButton.isEnabled = binding.radioA.isChecked && binding.radioB.isChecked
    }
}