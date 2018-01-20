package com.hmmelton.rescue.http

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

/** This interface defines networking calls that can be made to the Rescue API */
interface RescueService {

    @POST("login/{facebookId}")
    fun login(@Path("facebookId") facebookId: String,
              @Body user: LoginRequest): Call<User>
}