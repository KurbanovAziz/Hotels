package com.example.kitepkana.presentation.ui.activity.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kitepkana.R
import com.example.kitepkana.databinding.ActivitySplashBinding
import com.example.kitepkana.presentation.ui.activity.main.MainActivity
import kotlinx.coroutines.*

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivitySplashBinding::bind)
    private val uiScope = CoroutineScope(Dispatchers.Main + Job())
    private val ioScope = CoroutineScope(Dispatchers.IO + Job())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_splash)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
        }
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade)
        binding.logoMuras.startAnimation(fadeIn)
        binding.logoMuras.visibility = View.VISIBLE

        toMainActivity()
    }

    override fun onDestroy() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(true)
        }
        super.onDestroy()
    }

    private fun toMainActivity() {
        ioScope.launch {
            delay(1500)
            uiScope.launch {
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }
        }
    }
}