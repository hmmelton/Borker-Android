package com.hmmelton.rescue

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import kotlinx.android.synthetic.main.activity_auth.*
import timber.log.Timber

class AuthActivity : AppCompatActivity() {

    private val callbackManager = CallbackManager.Factory.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        loginButton.setReadPermissions("email")
        loginButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(result: LoginResult) {
                Timber.d(AccessToken.getCurrentAccessToken().token)
                Timber.d(AccessToken.getCurrentAccessToken().userId)
            }

            override fun onError(error: FacebookException?) {
                Timber.e(error?.message)
            }

            override fun onCancel() {
                Timber.d("onCancel")
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }
}
