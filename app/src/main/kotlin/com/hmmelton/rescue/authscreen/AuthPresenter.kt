package com.hmmelton.rescue.authscreen

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.GraphRequest
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.hmmelton.rescue.RescueApplication
import com.hmmelton.rescue.http.AccessTokens
import com.hmmelton.rescue.http.UserLogin
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

/**
 * Created by harrisonmelton on 1/16/18.
 * Presenter for auth screen
 */
class AuthPresenter(private val activity: Activity) {

    private val callbackManager = CallbackManager.Factory.create()

    private val loginCallback = object : Callback<AccessTokens> {
        override fun onResponse(call: Call<AccessTokens>, response: Response<AccessTokens>) {
            response.body()?.let { tokens ->
                (activity.application as RescueApplication).tokenStore.setTokens(tokens)

                // TODO: save user
                // TODO: navigate to main page
            }
        }

        override fun onFailure(call: Call<AccessTokens>, t: Throwable) {
        }
    }

    fun onCreate() {
        LoginManager.getInstance().registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(result: LoginResult) {
                // Call was successful - fetch additional user info
                makeGraphRequest()
            }

            override fun onError(error: FacebookException?) {
                Timber.e(error?.message)
            }

            override fun onCancel() {
                Timber.d("onCancel")
            }
        })
    }

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }

    fun onLoginClick() {
        LoginManager.getInstance().logInWithReadPermissions(activity, listOf("email"))
    }

    /**
     * This function makes a call to Facebook's Graph API to fetch more user info.
     */
    private fun makeGraphRequest() {
        val request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken()
        ) { `object`, response ->

            // If there was no error, login
            if (response.error == null) {
                login(`object`)
            }
        }

        // Add requested fields
        val parameters = Bundle()
        parameters.putString("fields", "id,name")
        request.parameters = parameters
        request.executeAsync()
    }

    /**
     * This function logs the user in through the Rescue API.
     */
    private fun login(userJson: JSONObject) {
        val user = UserLogin(
                userJson.getString("id"),
                userJson.getString("first_name"),
                userJson.getString("last_name"),
                userJson.getString("email")
        )
        (activity.application as RescueApplication).service
                .login(userJson.getString("id"), user)
                .enqueue(loginCallback)
    }
}