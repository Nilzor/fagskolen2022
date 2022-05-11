package no.fagskolen.uitests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import no.fagskolen.uitests.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.inputText.addTextChangedListener {
            binding.letterCount.text = binding.inputText.text.length.toString()
        }

        binding.reverseButton.setOnClickListener {
            binding.backwardsText.text = binding.inputText.text.reversed()
        }
    }
}