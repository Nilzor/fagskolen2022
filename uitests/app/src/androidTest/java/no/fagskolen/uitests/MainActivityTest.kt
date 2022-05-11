package no.fagskolen.uitests

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivityTest_testFullFlow() {
        Log.d("zzz", "Kake")
        activityRule.scenario.onActivity { activity ->
            Log.d("zzz", "Polse")
            onView(withId(R.id.nextButton)).check(matches(isDisplayed()))
            ///////////// ^^^^ feiler?
            onView(withId(R.id.radioA)).check(matches(isNotChecked()))
            onView(withId(R.id.radioB)).check(matches(isNotChecked()))

            onView(withId(R.id.buttonA)).perform(click())

            onView(withId(R.id.radioA)).check(matches(isChecked()))

            onView(withId(R.id.buttonB)).perform(click())

            onView(withId(R.id.radioB)).check(matches(isChecked()))
            onView(withId(R.id.radioB)).check(matches(isChecked()))
            onView(withId(R.id.nextButton)).check(matches(isDisplayed()))
        }
        activityRule.scenario.moveToState(Lifecycle.State.RESUMED)
    }
}