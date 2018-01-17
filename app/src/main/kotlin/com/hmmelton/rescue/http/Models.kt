package com.hmmelton.rescue.http

import com.squareup.moshi.Json
import org.threeten.bp.Instant

data class User(
        @Json(name = "_id") val id: String,
        val facebookId: String,
        val firstName: String,
        val lastName: String,
        val phoneNumber: String?,
        val email: String,
        val createdWhen: Instant
)

data class UserLogin(
        val facebookId: String,
        val firstName: String,
        val lastName: String,
        val email: String
)

data class AccessTokens(
        val accessToken: String,
        val refreshToken: String
)