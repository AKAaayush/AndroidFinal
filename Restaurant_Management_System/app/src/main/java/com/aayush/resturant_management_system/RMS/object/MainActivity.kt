package com.aayush.resturant_management_system.RMS.`object`

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.aayush.resturant_management_system.R
import com.aayush.resturant_management_system.RMS.fragments.HomeFragment
import com.aayush.resturant_management_system.RMS.fragments.MenuFragment
import com.aayush.resturant_management_system.RMS.fragments.ProfileFragment
import com.aayush.resturant_management_system.RMS.fragments.TableFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var linear: LinearLayout
    private lateinit var toolbar: Toolbar
    private lateinit var drawer: DrawerLayout
    lateinit var toggleAction: ActionBarDrawerToggle
    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val tableFragment = TableFragment()
        val profileFragment = ProfileFragment()
        val menuFragment = MenuFragment()

        drawer=findViewById(R.id.drawer_layout);

        toggleAction = ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggleAction);
        toggleAction.syncState()

        linear =findViewById(R.id.linear)
        toolbar=findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        //fragment Activities
        makeCurrentFragment(homeFragment)

        bottomNav= findViewById(R.id.bottomNav)

        bottomNav.setOnNavigationItemSelectedListener{item ->
            when(item.itemId){
                R.id.Home -> {makeCurrentFragment(homeFragment)
                    true
                }R.id.Profile ->{makeCurrentFragment(profileFragment)
                true
            }
                R.id.Table ->{makeCurrentFragment(tableFragment)
                    true
                }
                R.id.Menu ->{makeCurrentFragment(menuFragment)
                    true
                }

                else -> false
            }
        }


    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment)
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            commit()
        }
    }
}