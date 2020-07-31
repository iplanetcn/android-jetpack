package android.jetpack.hilt

import android.jetpack.hilt.ui.MainActivity
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.hamcrest.CoreMatchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class AppTest {

    @get:Rule
    var hitRule = HiltAndroidRule(this)

    @Test
    fun testUI() {
        ActivityScenario.launch(MainActivity::class.java)

        // check buttons fragment screen is displayed
        onView(withId(R.id.textView)).check(matches(isDisplayed()))

        // clear all logs
        onView(withId(R.id.delete_logs)).perform(click())

        // tap on button 1
        onView(withId(R.id.button1)).perform(click())

        // navigate to logs screen
        onView(withId(R.id.all_logs)).perform(click())

        // check logs fragment screen is displayed
        onView(withText(containsString("Interaction with 'Button 1'")))
            .check(matches(isDisplayed()))
    }
}