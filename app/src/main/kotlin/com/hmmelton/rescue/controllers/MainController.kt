package com.hmmelton.rescue.controllers

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.hmmelton.rescue.App
import com.hmmelton.rescue.R
import com.hmmelton.rescue.changehandlers.LeftToRightChangeHandler
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

        // Set OnClickListeners for Toolbar buttons
        view.barItemFilters.setOnClickListener(filtersOnClickListener)

        return view
    }

    private val filtersOnClickListener = View.OnClickListener {
        router.pushController(RouterTransaction
                .with(FiltersController())
                .pushChangeHandler(LeftToRightChangeHandler())
                .popChangeHandler(LeftToRightChangeHandler()))
    }
}