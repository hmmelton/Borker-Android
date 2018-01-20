package com.hmmelton.rescue.data

import android.content.Context
import android.preference.PreferenceManager
import com.hmmelton.rescue.http.AccessTokens

interface TokenStore {
    companion object {
        const val HEADER_ACCESS_TOKEN = "Access-Token"
        const val HEADER_REFRESH_TOKEN = "Refresh-Token"
    }

    fun hasTokens(): Boolean
    fun getTokens(): AccessTokens?
    fun setTokens(tokens: AccessTokens)
    fun clear()
}

class SharedPreferencesTokenStore(ctx: Context) : TokenStore {

    private val preferences = PreferenceManager.getDefaultSharedPreferences(ctx)

    companion object {
        private const val KEY_ACCESS_TOKEN = "com.hmmelton.rescue.data.accessToken"
        private const val KEY_REFRESH_TOKEN = "com.hmmelton.rescue.data.refreshToken"
    }

    override fun hasTokens() =
            preferences.contains(KEY_ACCESS_TOKEN) && preferences.contains(KEY_REFRESH_TOKEN)

    override fun getTokens(): AccessTokens? {
        if (!hasTokens()) return null

        val accessToken = preferences.getString(KEY_ACCESS_TOKEN, "")
        val refreshToken = preferences.getString(KEY_REFRESH_TOKEN, "")

        if (accessToken.isEmpty() || refreshToken.isEmpty()) return null

        return AccessTokens(accessToken, refreshToken)
    }

    override fun setTokens(tokens: AccessTokens) {
        val editor = preferences.edit()
        editor.putString(KEY_ACCESS_TOKEN, tokens.accessToken)
        editor.putString(KEY_REFRESH_TOKEN, tokens.refreshToken)
        editor.apply()
    }

    override fun clear() {
        preferences.edit().clear().apply()
    }
}