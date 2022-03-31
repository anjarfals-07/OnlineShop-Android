package com.androiddasar.onlineshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.androiddasar.onlineshop.activity.LoginActivity
import com.androiddasar.onlineshop.fragment.AkunFragment
import com.androiddasar.onlineshop.fragment.HomeFragment
import com.androiddasar.onlineshop.fragment.KeranjangFragment
import com.androiddasar.onlineshop.helper.SharedPref
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val fragmentHome: Fragment = HomeFragment()
    private val fragmentCart: Fragment = KeranjangFragment()
    private val fragmentAccount: Fragment = AkunFragment()
    private val fm: FragmentManager = supportFragmentManager
    private var active: Fragment = fragmentHome

    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem
    private lateinit var btnNavigationMenuView: BottomNavigationView

    private val statusLogin = false
    private lateinit var s: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        s = SharedPref(this)
        setUpBottomNav()
    }

    fun setUpBottomNav() {
        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.container, fragmentCart).hide(fragmentCart).commit()
        fm.beginTransaction().add(R.id.container, fragmentAccount).hide(fragmentAccount).commit()

        btnNavigationMenuView = findViewById(R.id.nav_view)
        menu = btnNavigationMenuView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        btnNavigationMenuView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    callFragment(0, fragmentHome)

                }
                R.id.navigation_keranjang -> {
                    callFragment(1, fragmentCart)

                }
                R.id.navigation_akun -> {
                    // status login true dia akan mengarah ke akun
                    if (s.getStatusLogin()) {
                        callFragment(2, fragmentAccount)
                    } else {
                        // jika false akan mengarah ke activity login
                        startActivity(Intent(this, LoginActivity::class.java))
                    }

                }
            }
            false
        }
    }

    fun callFragment(int: Int, fragment: Fragment) {
        menuItem = menu.getItem(int)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }
}