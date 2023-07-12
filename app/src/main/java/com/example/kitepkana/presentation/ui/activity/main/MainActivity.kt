package com.example.kitepkana.presentation.ui.activity.main


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitepkana.R
import com.example.kitepkana.data.local.AppPrefs
import com.example.kitepkana.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::bind)

    private lateinit var navController: NavController

    @Inject
    lateinit var appPrefs: AppPrefs
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        val navView: BottomNavigationView = binding.navView
        navController = findNavController(R.id.nav_host_fragment_activity_main)
        if (!appPrefs.onBoard) {
            navController.navigate(R.id.onBoardingFragment)
        }

        val navFragment = listOf(
            R.id.library, R.id.search,
            R.id.read, R.id.profile,
            R.id.settingsFragment
        )

        navController.addOnDestinationChangedListener { _, destination, _ ->
            navView.isVisible = destination.id in navFragment
        }

        navView.setupWithNavController(navController)

    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (navController.currentDestination?.id != R.id.onBoardingFragment) {
            super.onBackPressed()
        }
    }
}
