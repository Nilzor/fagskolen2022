import java.util.*

fun main() {
    var qrBillett = QrBillett()
    qrBillett.pris = 2000
    println("Pris for QR-billetten er: ${qrBillett.prisSomKroner()}")
}

open class Billett {
    var pris: Int = 0
    fun prisSomKroner(): String {
        return "${pris / 100} kr"
    }
}

class QrBillett : Billett() {
    var qrKode: ByteArray = ByteArray(1000)
}

