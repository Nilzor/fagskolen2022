package com.fagskolen.unittesting.sideeffect

import org.junit.Assert.*
import org.junit.Test

class TrafficLightTest {
    @Test
    fun `single change - should change to yellow`() {
        val trafficLight = TrafficLight()
        trafficLight.changeLight()
        assertEquals(LightState.Yellow, trafficLight.state)
    }

    @Test
    fun `single cycle - should log once`() {
        val trafficLight = TrafficLight()
        trafficLight.changeLight()
        assertEquals(1, GlobalState.logger.loggedText.size)
        assertTrue(GlobalState.logger.loggedText[0].contains("Yellow"))
    }
}