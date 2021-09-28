package objects

class LightPanel(switchCount: Int) {

    val switches = mutableListOf<LightSwitch>()

    init {
        for (i in 1..switchCount) {
            val switch = LightSwitch()
            switches.add(switch)
        }
    }

    fun printState() {
        for (switch in switches) {
            val text = if (switch.isOn) "O" else "."
            print(text)
        }
        println()
    }
}