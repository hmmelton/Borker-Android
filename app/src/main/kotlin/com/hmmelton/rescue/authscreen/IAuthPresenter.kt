package com.hmmelton.rescue.authscreen

import android.content.Intent

/**
 * Created by harrisonmelton on 1/23/18.
 * Interface for auth screen presenter.
 */
interface IAuthPresenter {
    fun onCreate()

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)

    fun onLoginClick()
}