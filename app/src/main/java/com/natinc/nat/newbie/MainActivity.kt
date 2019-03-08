package com.natinc.nat.newbie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigationController = findNavController(R.id.main_nav_host_fragment)
        findViewById<BottomNavigationView>(R.id.main_bottom_navigation_view)
                .setupWithNavController(navigationController)
    }

}
