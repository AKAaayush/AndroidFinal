package com.aayush.resturant_management_system.RMS.`object`

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.aayush.resturant_management_system.R
import com.aayush.resturant_management_system.RMS.api.ServiceBuilder
import com.aayush.resturant_management_system.RMS.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var  toggle: ActionBarDrawerToggle
    lateinit var linear: LinearLayout
    private lateinit var drawer: DrawerLayout
    lateinit var toggleAction: ActionBarDrawerToggle
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var nav_view: NavigationView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Toke is ",ServiceBuilder.token)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val tableFragment = AddToCartFragment()
        val profileFragment = ProfileFragment()
        val menuFragment = MenuFragment()
        val mapsFragment = MapsFragment()

        drawer=findViewById(R.id.drawer_layout);
        nav_view=findViewById(R.id.nav_view);

        toggleAction = ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggleAction);
        toggleAction.syncState()

        linear =findViewById(R.id.linear)

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

        //fragments from slider menu
        nav_view.setNavigationItemSelectedListener(this)
        nav_view.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.maps ->{makeCurrentFragment(mapsFragment)}
            }


            true
        }

        toggle = ActionBarDrawerToggle(this,drawer, R.string.open, R.string.close )
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        nav_view.setNavigationItemSelectedListener {
//            when(it. itemId){
//                R.id.miItem1 -> Toast.makeText(applicationContext, "clicked Item 1", Toast.LENGTH_SHORT).show()
//            }
//
//        }



    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment)
            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            commit()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item)
    }
}