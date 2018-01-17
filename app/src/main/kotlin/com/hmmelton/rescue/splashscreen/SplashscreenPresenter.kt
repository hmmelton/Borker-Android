package com.hmmelton.rescue.splashscreen

import android.content.Context
import android.content.Intent
import com.hmmelton.rescue.authscreen.AuthActivity
import com.hmmelton.rescue.data.TokenStore

/**
 * Created by harrisonmelton on 1/16/18.
 * Presenter for the splashscreen page
 */
class SplashscreenPresenter(private val ctx: Context, private val tokenStore: TokenStore) {

    fun onCreate() {
        // If user is logged in, go to main screen.  If not, go to login screen
        if (tokenStore.hasTokens()) {
            // TODO: go to main page
        } else {
            ctx.startActivity(Intent(ctx, AuthActivity::class.java))
        }
    }
}