package com.hmmelton.rescue.http

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

/** This interface defines networking calls that can be made to the Rescue API */
interface RescueService {

    @POST("auth/login/{facebookToken}")
    fun login(@Path("facebookToken") facebookToken: String,
              @Body user: LoginRequest): Call<User>
}