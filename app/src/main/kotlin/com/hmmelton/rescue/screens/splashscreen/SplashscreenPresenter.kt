package com.hmmelton.rescue.screens.splashscreen

import android.content.Context
import android.content.Intent
import com.hmmelton.rescue.screens.authscreen.AuthActivity
import com.hmmelton.rescue.data.UserSession
import com.hmmelton.rescue.screens.mainscreen.MainActivity

/**
 * Created by harrisonmelton on 1/16/18.
 * Presenter for the splashscreen page
 */
class SplashscreenPresenter(
        private val ctx: Context,
        private val user: UserSession
) : ISplashscreenPresenter {

    override fun onCreate() {
        // If user is logged in, go to main screen.  If not, go to login screen
        if (user.isAuthenticated()) {
            ctx.startActivity(Intent(ctx, MainActivity::class.java))
        } else {
            ctx.startActivity(Intent(ctx, AuthActivity::class.java))
        }
    }
}