package com.aayush.resturant_management_system

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers

import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.aayush.resturant_management_system.RMS.`object`.RegisterActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@LargeTest
@RunWith(JUnit4 :: class)
class UserRegistrationTesting {

    @get : Rule
    val testRule = ActivityScenarioRule(RegisterActivity::class.java)

    @Test
    fun checkRegisterUI() {
        Espresso.onView(withId(R.id.signup_fullname))
            .perform(ViewActions.typeText("Test Test"))

        Thread.sleep(2000)
        Espresso.closeSoftKeyboard()


        Espresso.onView(withId(R.id.signup_address))
            .perform(ViewActions.typeText("KTM"))

        Thread.sleep(2000)
        Espresso.closeSoftKeyboard()

        Espresso.onView(withId(R.id.signup_phone))
            .perform(ViewActions.typeText("21863678"))

        Thread.sleep(2000)
        Espresso.closeSoftKeyboard()
        Espresso.onView(withId(R.id.signup_email))
            .perform(ViewActions.typeText("test12@gmail.com"))

        Thread.sleep(2000)
        Espresso.closeSoftKeyboard()



        Espresso.onView(withId(R.id.signup_password))
            .perform(ViewActions.typeText("admin12"))

        Thread.sleep(2000)
        Espresso.closeSoftKeyboard()

        Espresso.onView(withId(R.id.signup_cfpassword))
            .perform(ViewActions.typeText("admin12"))

        Thread.sleep(2000)
        Espresso.closeSoftKeyboard()

        Espresso.onView(withId(R.id.signup_btn))
            .perform(ViewActions.click())

        Thread.sleep(2000)
        Espresso.onView(withId(R.id.registertest))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))






    }
}