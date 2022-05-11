package no.fagskolen.uitests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivityTest_testFullFlow() {
        // Sjekk initiell tilstand
        onView(withId(R.id.nextButton)).check(matches(isDisplayed()))
        onView(withId(R.id.nextButton)).check(matches(isNotEnabled()))
        onView(withId(R.id.radioA)).check(matches(isNotChecked()))
        onView(withId(R.id.radioB)).check(matches(isNotChecked()))
        onView(withId(R.id.nextButton)).check(matches(withText("Gå Videre")))

        // Klikk A
        onView(withId(R.id.buttonA)).perform(click())
        onView(withId(R.id.radioA)).check(matches(isChecked()))

        // Klikk B
        onView(withId(R.id.buttonB)).perform(click())
        onView(withId(R.id.radioB)).check(matches(isChecked()))
        onView(withId(R.id.radioB)).check(matches(isChecked()))
        onView(withId(R.id.nextButton)).check(matches(isDisplayed()))
    }

    @Test
    fun mainActivityTest_testThatButtonTurnsOffAfter3Secs() {
        // Klikk A
        onView(withId(R.id.buttonA)).perform(click())
        onView(withId(R.id.radioA)).check(matches(isChecked()))

        // Vent 3 sek
        Thread.sleep(3100)
        onView(withId(R.id.radioA)).check(matches(isNotChecked()))
    }
}