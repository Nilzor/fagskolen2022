package no.fagskolen.salesapp

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val prisVoksen = 15
    val prisBarn = 10

    var antallVoksen: Int = 0
        set(value) {
            if (value >= 0) {
                field = value
                oppdaterPris()
                onViewUpdated?.onViewUpdated()
            }
        }

    var antallBarn: Int = 0
        set(value) {
            if (value >= 0) {
                field = value
                oppdaterPris()
                onViewUpdated?.onViewUpdated()
            }
        }

    var sumPris: Int = 0

    var onViewUpdated: ViewUpdate? = null

    private fun oppdaterPris() {
        sumPris = (antallBarn * prisBarn) + (antallVoksen * prisVoksen)
    }
}