package com.example.premierleague

import androidx.fragment.app.Fragment

abstract class BaseMainActivityFragment(layoutId: Int): Fragment(layoutId) {

    val mainActivity: MainActivity by lazy { activity as MainActivity}

    fun setToolbarTitle(title: String) {
        mainActivity.supportActionBar?.title = title
    }

}