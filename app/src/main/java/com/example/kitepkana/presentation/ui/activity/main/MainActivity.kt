package com.example.kitepkana.presentation.ui.activity.main


import android.os.Bundle
import android.view.MenuItem
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitepkana.R
import com.example.kitepkana.data.local.AppPrefs
import com.example.kitepkana.databinding.NavDrawerBinding
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(NavDrawerBinding::bind)

    private lateinit var navController: NavController

    @Inject
    lateinit var appPrefs: AppPrefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nav_drawer)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        navController = findNavController(R.id.nav_host)

        initListeners()

        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.activityMain.layoutInclude.isVisible =
                !(destination.id == R.id.registerFragment ||
                        destination.id == R.id.authorizationTwoFragment2 ||
                        destination.id == R.id.mainAuthorizationFragment ||
                        destination.id == R.id.authFragment)
        }
    }

    private fun initListeners() {
        binding.activityMain.include.ivProfile.setOnClickListener {
            navController.navigate(R.id.profileFragment)
        }
        binding.activityMain.include.tvLanguages.setOnClickListener { view ->
            val popupMenu = PopupMenu(this, view)
            val inflater = popupMenu.menuInflater
            inflater.inflate(R.menu.menu_laguages, popupMenu.menu)

            popupMenu.setOnMenuItemClickListener { item: MenuItem? ->
                when (item?.itemId) {
                    R.id.russian -> {
                        binding.activityMain.include.tvLanguages.text = item.toString()
                        true
                    }
                    R.id.kyrgyz_tili -> {
                        binding.activityMain.include.tvLanguages.text = item.toString()
                        true
                    }
                    R.id.english -> {
                        binding.activityMain.include.tvLanguages.text = item.toString()
                        true
                    }
                    else -> false
                }
            }
            popupMenu.show()
        }
        binding.activityMain.include.tvCurrency.setOnClickListener { view ->
            val popupMenu = PopupMenu(this, view)
            val inflater = popupMenu.menuInflater
            inflater.inflate(R.menu.menu_currency, popupMenu.menu)

            popupMenu.setOnMenuItemClickListener { item: MenuItem? ->
                when (item?.itemId) {
                    R.id.som -> {
                        binding.activityMain.include.tvCurrency.text = item.toString()
                        true
                    }
                    R.id.dollar -> {
                        binding.activityMain.include.tvCurrency.text = item.toString()
                        true
                    }
                    else -> false
                }
            }
            popupMenu.show()
        }

        binding.activityMain.include.ivBurgerMenu.setOnClickListener {
            if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_item_1 -> {
                    // Обработка выбора элемента меню 1
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_item_2 -> {
                    // Обработка выбора элемента меню 2
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_item_3 -> {
                    // Обработка выбора элемента меню 3
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                else -> false
            }
        }
    }
}
