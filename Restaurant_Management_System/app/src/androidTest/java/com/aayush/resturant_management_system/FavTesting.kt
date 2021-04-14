package com.aayush.resturant_management_system

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.launchFragment
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.aayush.resturant_management_system.RMS.`object`.LoginActivity
import com.aayush.resturant_management_system.RMS.fragments.HomeFragment
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@LargeTest
@RunWith(JUnit4 :: class)
class FavTesting {

//    val testRule = launchFragment(HomeFragment::class.java)
// The "fragmentArgs" arguments are optional.
//val fragmentArgs = bundleOf("numElements" to 0)
//    val scenario = launchFragment<HomeFragment>(fragmentArgs)
    @Test
fun testEventFragment() {
        val scenario = launchFragmentInContainer<HomeFragment>()
        onView(withId(R.id.fragmentContainer)).perform(click())
        // Assert some expected behavior

    }
}