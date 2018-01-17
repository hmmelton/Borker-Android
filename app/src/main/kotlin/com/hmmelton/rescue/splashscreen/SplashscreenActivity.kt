package com.hmmelton.rescue.splashscreen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hmmelton.rescue.RescueApplication

class SplashscreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create screen's presenter
        val tokenStore = (application as RescueApplication).tokenStore
        val presenter = SplashscreenPresenter(this, tokenStore)
        presenter.onCreate()

        finish()
    }
}
