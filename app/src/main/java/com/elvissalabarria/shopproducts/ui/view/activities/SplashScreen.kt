package com.elvissalabarria.shopproducts.ui.view.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.elvissalabarria.shopproducts.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splah_screen)
        splashScreen.setKeepOnScreenCondition { true }
        Intent(this, MainActivity::class.java).also {
            startActivity(it)
            finish()
        }
    }
}