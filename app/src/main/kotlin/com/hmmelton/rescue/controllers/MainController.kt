package com.hmmelton.rescue.controllers

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.hmmelton.rescue.App
import com.hmmelton.rescue.R
import com.hmmelton.rescue.screens.authscreen.AuthActivity
import kotlinx.android.synthetic.main.controller_main.view.*

/**
 * Created by harrisonmelton on 2/6/18.
 * Controller for displaying the app's main content (adoptable dogs).
 */
class MainController : Controller() {
    private lateinit var ctx: Context

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_main, container, false)

        ctx = view.context

        view.barItemFavorites.setOnClickListener(favoritesOnClickListener)

        return view
    }

    private val favoritesOnClickListener = View.OnClickListener {
        (ctx.applicationContext as App).userSession.clear()
        ctx.startActivity(Intent(ctx, AuthActivity::class.java))
        router.activity?.finish()
    }
}