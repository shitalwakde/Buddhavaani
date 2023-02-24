package com.lastmile.buddhavaani.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.lastmile.buddhavaani.R
import com.lastmile.buddhavaani.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , NavController.OnDestinationChangedListener{

    private lateinit var binding: ActivityMainBinding


    companion object{
        const val TAG ="MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupActionBarWithNavController(findNavController(R.id.nav_host_fragment))

        val navController = findNavController(R.id.nav_host_fragment)

        binding.navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        when (destination.id) {
            R.id.navigation_home -> {
                val colorDark = ContextCompat.getColorStateList(
                    this,
                    R.color.bottom_tab_selector_item_dark
                )

                val colorBlack = ContextCompat.getColorStateList(
                    this,
                    R.color.blue
                )
                binding.navView.backgroundTintList = colorBlack
                binding.navView.itemTextColor = colorDark
                binding.navView.itemIconTintList = colorDark
            }
            R.id.navigation_profile -> {
                val colorDark = ContextCompat.getColorStateList(
                    this,
                    R.color.bottom_tab_selector_item_dark
                )

                val colorBlack = ContextCompat.getColorStateList(
                    this,
                    R.color.blue
                )

                binding.navView.backgroundTintList = colorBlack
                binding.navView.itemTextColor = colorDark
                binding.navView.itemIconTintList = colorDark
            }
            R.id.navigation_notification -> {
                val colorDark = ContextCompat.getColorStateList(
                    this,
                    R.color.bottom_tab_selector_item_dark
                )

                val colorBlack = ContextCompat.getColorStateList(
                    this,
                    R.color.blue
                )

                binding.navView.backgroundTintList = colorBlack
                binding.navView.itemTextColor = colorDark
                binding.navView.itemIconTintList = colorDark
            }
            else -> {
                /*changeStatusBarColor(R.color.white)
                val colorDark = ContextCompat.getColorStateList(
                    this,
                    R.color.bottom_tab_selector_item_light
                )

                val colorWhite = ContextCompat.getColorStateList(
                    this,
                    R.color.white
                )

                binding.navView.backgroundTintList = colorWhite
                binding.navView.itemTextColor = colorDark
                binding.navView.itemIconTintList = colorDark*/
            }
        }
    }
}