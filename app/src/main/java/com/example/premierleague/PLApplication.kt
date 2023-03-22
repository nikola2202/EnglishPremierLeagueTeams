package com.example.premierleague

import android.app.Application

class PLApplication:Application() {

    companion object {
        lateinit var application: PLApplication
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }

}