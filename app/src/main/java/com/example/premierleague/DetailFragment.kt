package com.example.premierleague

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

class DetailFragment: BaseMainActivityFragment(R.layout.fragment_detail) {

    private val footballTile: FootballTile by lazy {
        mainActivity.footballTileList.find {
            it.id == requireArguments().getString("footballTileId")
        }!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        mainActivity.supportActionBar?.apply {
            setToolbarTitle("Club overview")
            setDisplayHomeAsUpEnabled(true)
        }

        val headerImage: ImageView = view.findViewById(R.id.teamHeaderImageView)
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val descriptionTextView: TextView = view.findViewById(R.id.descriptionTextView)
        val descriptionLong: TextView = view.findViewById(R.id.descriptionLongTextView)

        headerImage.setImageResource(footballTile.headerImageID)
        titleTextView.text = footballTile.title
        descriptionTextView.text = footballTile.description
        descriptionLong.text = footballTile.descriptionLong
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_football_tile_detail,menu)
        if(footballTile.isFavourite) {
            menu.findItem(R.id.menuItemFavourite)?.setIcon(R.drawable.ic_favourite_24dp)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                mainActivity.supportFragmentManager.popBackStack()
                true
            }

            R.id.menuItemLink -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(footballTile.teamUrl))
                startActivity(intent)
                true
            }

            R.id.menuItemFavourite -> {
                val isCurrentFavourite = footballTile.isFavourite
                if(isCurrentFavourite) {
                    item.setIcon(R.drawable.ic_favorite_outline_24dp)
                }else {
                    item.setIcon(R.drawable.ic_favourite_24dp)
                }

                footballTile.isFavourite = !isCurrentFavourite
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}