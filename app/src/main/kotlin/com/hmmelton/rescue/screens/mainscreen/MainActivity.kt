package com.hmmelton.rescue.screens.mainscreen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.RouterTransaction
import com.hmmelton.rescue.R
import com.hmmelton.rescue.controllers.MainController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val container = controllerContainer as ViewGroup

        // Attach router, and set root, if there is none
        val router = Conductor.attachRouter(this, container, savedInstanceState)
        if (!router.hasRootController()) router.setRoot(RouterTransaction.with(MainController()))
    }
}
