package com.hmmelton.rescue.screens.authscreen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hmmelton.rescue.R
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : AppCompatActivity() {

    private lateinit var presenter: AuthPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        window.setBackgroundDrawable(null)

        presenter = AuthPresenter(this)
        presenter.onCreate()

        loginButton.setOnClickListener { presenter.onLoginClick() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        presenter.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }
}
