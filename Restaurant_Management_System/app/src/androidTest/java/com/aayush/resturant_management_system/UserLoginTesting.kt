package com.aayush.resturant_management_system

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.aayush.resturant_management_system.RMS.`object`.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@LargeTest
@RunWith(JUnit4 :: class)
class UserLoginTesting {

    @get : Rule
    val testRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun checkLoginUI() {
        Espresso.onView(withId(R.id.login_email))
                .perform(ViewActions.typeText("test12@gmail.com"))

        Thread.sleep(2000)
        Espresso.closeSoftKeyboard()


        Espresso.onView(withId(R.id.login_password))
                .perform(ViewActions.typeText("admin12"))

        Thread.sleep(2000)
        Espresso.closeSoftKeyboard()

        Espresso.onView(withId(R.id.btn_login))
                .perform(ViewActions.click())

        Thread.sleep(2000)
        Espresso.onView(withId(R.id.fragmentContainer))
                .check(matches(isDisplayed()))

    }
}