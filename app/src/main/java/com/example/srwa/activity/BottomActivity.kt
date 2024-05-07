package com.example.srwa.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.srwa.R
import com.example.srwirehouse.HomeFragment
import com.example.srwirehouse.InputFragment
import com.example.srwirehouse.OutputFragment
import com.example.srwirehouse.ProductionFragment
import com.example.srwirehouse.QRCodeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav.setOnNavigationItemSelectedListener(navListener)

        // Display the home fragment initially
        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, HomeFragment()).commit()
    }

    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        var selectedFragment: Fragment? = null

        when (menuItem.itemId) {
            R.id.home_page -> selectedFragment = HomeFragment()
            R.id.input_page -> selectedFragment = InputFragment()
            R.id.qrcode_page -> selectedFragment = QRCodeFragment()
            R.id.production_page -> selectedFragment = ProductionFragment()
            R.id.output_page -> selectedFragment = OutputFragment()
        }

        selectedFragment?.let {
            supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, it).commit()
            return@OnNavigationItemSelectedListener true
        } ?: false
    }
}