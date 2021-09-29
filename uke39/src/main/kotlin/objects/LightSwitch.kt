package objects

class LightSwitch(on: Boolean) {
    var isOn: Boolean = false
        private set

    init {
        isOn = on
    }

    fun turnOn() {
        isOn = true
    }

    fun turnOff() {
        isOn = false
    }

    fun toggle() {
        isOn = !isOn
    }
}

