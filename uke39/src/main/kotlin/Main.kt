import objects.LightPanel
import java.util.*

fun main() {
    val panel = LightPanel(4)
    panel.printState()

    while (true) {
        val number = (readLine()?.toInt()  ?: -1) -1
        if (number >= 0 && number < panel.switches.size) {
            panel.switches[number].toggle()
        }
        panel.printState()
    }
}

