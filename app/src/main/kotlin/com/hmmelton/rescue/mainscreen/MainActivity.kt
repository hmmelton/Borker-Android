package com.hmmelton.rescue.mainscreen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.hmmelton.rescue.App
import com.hmmelton.rescue.R
import com.hmmelton.rescue.authscreen.AuthActivity
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.d("In main activity")

        setSupportActionBar(toolbar)
        val ab = supportActionBar ?: throw IllegalStateException("Support action bar is null")
        ab.setDisplayShowTitleEnabled(false)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        MenuInflater(this).inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_sign_out -> {
                (application as App).userSession.clear()
                startActivity(Intent(this, AuthActivity::class.java))
                finish()
            }
        }
        return false
    }
}
