package objects

class LightSwitch() {
    var isOn: Boolean = false
        private set

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

