package com.fagskolen.unittesting.sideeffect

enum class LightState {
    Red,
    Yellow,
    Green
}

class TrafficLight {
    companion object {
        val cycle = arrayOf(
            LightState.Red,
            LightState.Yellow,
            LightState.Green,
            LightState.Yellow,
        )
    }

    private var stateIndex: Int = 0
    val state: LightState
        get() {
            return cycle[stateIndex]
        }

    /**
     * Changes the traffic light to the next in the cycle
     */
    fun changeLight() {
        stateIndex++
        if (stateIndex >= cycle.size) {
            stateIndex = 0
        }
        GlobalState.logger.log("Changed light to: $state")
    }
}