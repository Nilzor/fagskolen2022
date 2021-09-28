package objects

class Dimmer {
    var isOn: Boolean = false
    var lightValue: Double = 0.0 // Fra 0 til 1

    fun toggle() {
        isOn = !isOn
    }

    fun increaseLightness() {
        lightValue += 0.1
        if (lightValue > 1) {
            lightValue = 1.0
        }
    }

    fun decreaseLightness() {
        lightValue -= 0.1
        if (lightValue < 0) {
            lightValue = 0.0
        }
    }
}