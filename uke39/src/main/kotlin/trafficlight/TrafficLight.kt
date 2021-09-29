package trafficlight

class TrafficLight {
    var lightFromTop: Int = 1

    fun printMe() {
        when (lightFromTop) {
            1 -> {
                print("[¤]")
                print("[ ]")
                print("[ ]")
            }
            2 -> {
                print("[ ]")
                print("[¤]")
                print("[ ]")
            }
            3 -> {
                print("[ ]")
                print("[¤]")
                print("[ ]")
            }
        }
    }
}