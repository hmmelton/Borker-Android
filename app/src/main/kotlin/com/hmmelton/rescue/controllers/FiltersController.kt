package com.hmmelton.rescue.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.hmmelton.rescue.R
import kotlinx.android.synthetic.main.controller_filters.view.*

/**
 * Created by harrisonmelton on 2/13/18.
 * Controller for changing filters for adoptable dog search
 */
class FiltersController : Controller() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_filters, container, false)

        view.backToSearch.setOnClickListener(backButtonOnClickListener)

        return view
    }

    private val backButtonOnClickListener = View.OnClickListener { router.handleBack() }
}