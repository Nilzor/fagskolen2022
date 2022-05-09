package no.fagskolen.salesapp

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val prisVoksen = 15
    val prisBarn = 10
    var antallVoksen: Int = 0

    var antallBarn: Int = 0
    var sumPris: Int = 0

    var onViewUpdated: ViewUpdate? = null

    fun oppdaterAntalBarn(nyttAntall: Int) {
        if (nyttAntall >= 0) {
            antallBarn = nyttAntall
            oppdaterPris()
            onViewUpdated?.onViewUpdated()
        }
    }

    fun oppdaterAntalVoksen(nyttAntall: Int) {
        if (nyttAntall >= 0) {
            antallVoksen = nyttAntall
            oppdaterPris()
            onViewUpdated?.onViewUpdated()
        }
    }

    private fun oppdaterPris() {
        sumPris = (antallBarn * prisBarn) + (antallVoksen * prisVoksen)
    }
}