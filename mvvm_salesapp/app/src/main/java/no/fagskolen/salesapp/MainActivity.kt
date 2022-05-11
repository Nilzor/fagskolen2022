package no.fagskolen.salesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.viewModels
import no.fagskolen.salesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ViewUpdate {
    lateinit var bindings: ActivityMainBinding
    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindings.root)

        viewModel.onViewUpdated = this

        bindings.plusAdult.setOnClickListener {
            viewModel.oppdaterAntalVoksen(viewModel.antallVoksen + 1)
        }
        bindings.plusChild.setOnClickListener {
            viewModel.oppdaterAntalBarn(viewModel.antallBarn + 1)
        }
        bindings.minusAdult.setOnClickListener {
            viewModel.oppdaterAntalVoksen(viewModel.antallVoksen - 1)
        }
        bindings.minusChild.setOnClickListener {
            viewModel.oppdaterAntalBarn(viewModel.antallBarn - 1)
        }
    }

    override fun onViewUpdated() {
        bindings.adultCount.text = viewModel.antallVoksen.toString()
        bindings.childCount.text = viewModel.antallBarn.toString()
        bindings.priceSum.text = "${viewModel.sumPris},-"
    }
}