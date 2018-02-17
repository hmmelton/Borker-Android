package com.hmmelton.rescue.controllers

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.hmmelton.rescue.App
import com.hmmelton.rescue.R
import com.hmmelton.rescue.screens.authscreen.AuthActivity
import kotlinx.android.synthetic.main.controller_filters.view.*

/**
 * Created by harrisonmelton on 2/13/18.
 * Controller for changing filters for adoptable dog search
 */
class FiltersController : Controller() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_filters, container, false)

        view.backToSearch.setOnClickListener(backButtonOnClickListener)
        view.btnSignOut.setOnClickListener(signOutButtonOnClickListener)

        return view
    }

    private val backButtonOnClickListener = View.OnClickListener { router.handleBack() }
    private val signOutButtonOnClickListener = View.OnClickListener {
        val activity = router.activity ?: throw IllegalStateException("Host activity is null")

        // Sign out and return to auth screen
        (activity.application as App).userSession.clear()
        startActivity(Intent(activity, AuthActivity::class.java))
        activity.finish()
    }
}