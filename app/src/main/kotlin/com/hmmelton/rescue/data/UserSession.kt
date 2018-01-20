package com.hmmelton.rescue.data

import android.content.Context
import android.preference.PreferenceManager
import com.hmmelton.rescue.http.AccessTokens
import com.hmmelton.rescue.http.User
import com.squareup.moshi.Moshi

class UserSession(private val ctx: Context, private val tokenStore: TokenStore) {

    companion object {
        private const val KEY_USER = "com.hmmelton.rescue.data.keyUser"
    }

    private val userAdapter = Moshi.Builder().build().adapter<User>(User::class.java)

    var user: User?
        get() {
            val userString =
                    PreferenceManager.getDefaultSharedPreferences(ctx).getString(KEY_USER, "")
            return userAdapter.fromJson(userString)
        }
        set(value) {
            if (value != null) {
                val userString = userAdapter.toJson(value)
                PreferenceManager.getDefaultSharedPreferences(ctx)
                        .edit()
                        .putString(KEY_USER, userString)
                        .apply()
            }
        }

    var tokens: AccessTokens?
        get() = tokenStore.getTokens()
        set(value) {
            if (value != null) {
                tokenStore.setTokens(value)
            }
        }

    fun isAuthenticated() = tokenStore.hasTokens()

    fun clear() {
        user = null
        tokenStore.clear()
    }
}