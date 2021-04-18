package com.aayush.resturant_management_system

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.aayush.resturant_management_system.RMS.`object`.LoginActivity
import com.aayush.resturant_management_system.RMS.`object`.UserProfileActivity
import org.junit.Rule
import org.junit.Test

class UserProfileTesting {
    @get : Rule
    val testRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun checkUserUI() {



        Espresso.onView(ViewMatchers.withId(R.id.login_email))
            .perform(ViewActions.typeText("test12@gmail.com"))

        Thread.sleep(2000)
        Espresso.closeSoftKeyboard()


        Espresso.onView(ViewMatchers.withId(R.id.login_password))
            .perform(ViewActions.typeText("admin12"))

        Thread.sleep(2000)
        Espresso.closeSoftKeyboard()

        Espresso.onView(ViewMatchers.withId(R.id.btn_login))
            .perform(ViewActions.click())

        Thread.sleep(2000)

        Espresso.onView(ViewMatchers.withId(R.id.Profile))
            .perform(ViewActions.click())

        Thread.sleep(2000)
        Espresso.onView(ViewMatchers.withId(R.id.userprofile))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))









    }
}