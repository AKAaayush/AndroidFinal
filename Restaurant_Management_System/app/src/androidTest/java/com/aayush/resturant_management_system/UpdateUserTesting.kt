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

class UpdateUserTesting {
    @get : Rule
    val testRule = ActivityScenarioRule(UserProfileActivity::class.java)

    @Test
    fun checkUpdateUserUI() {



        Thread.sleep(2000)
        Espresso.onView(ViewMatchers.withId(R.id.edit_name))
            .perform(ViewActions.typeText("Test"))

        Thread.sleep(2000)
        Espresso.closeSoftKeyboard()

        Espresso.onView(ViewMatchers.withId(R.id.edit_email))
            .perform(ViewActions.typeText("Test@gmail.com"))

        Thread.sleep(2000)
        Espresso.closeSoftKeyboard()

        Espresso.onView(ViewMatchers.withId(R.id.edit_address))
            .perform(ViewActions.typeText("Kathmandu"))

        Thread.sleep(2000)
        Espresso.closeSoftKeyboard()

        Espresso.onView(ViewMatchers.withId(R.id.edit_phone))
            .perform(ViewActions.typeText("9863858330"))

        Thread.sleep(2000)
        Espresso.closeSoftKeyboard()

        Espresso.onView(ViewMatchers.withId(R.id.btn_saveprofile))
            .perform(ViewActions.click())

        Thread.sleep(2000)


        Espresso.onView(ViewMatchers.withId(R.id.fragmentContainer))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Thread.sleep(2000)
        Espresso.onView(ViewMatchers.withId(R.id.userprofile))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))














    }
}