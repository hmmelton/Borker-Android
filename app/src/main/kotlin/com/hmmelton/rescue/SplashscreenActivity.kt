package com.hmmelton.rescue

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SplashscreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: set splashscreen background

        // TODO: if user is logged in, go to main screen.  If not, go to login screen
        startActivity(Intent(this, AuthActivity::class.java))
    }
}
