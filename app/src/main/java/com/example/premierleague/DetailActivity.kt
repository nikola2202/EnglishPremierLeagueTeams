package com.example.premierleague

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity: AppCompatActivity() {

    private lateinit var footballTile:FootballTile

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Club overview"
        }
            val selectedId = intent.getStringExtra("footballTileId")

            footballTile = MainActivity.footballTileList.find {
                it.id == selectedId
            }?: FootballTile(
                title = "whoops",
                description = "Something went wrong - please try again."
            )

        val headerImage: ImageView = findViewById(R.id.teamHeaderImageView)
        val titleTextView: TextView = findViewById(R.id.titleTextView)
        val descriptionTextView: TextView = findViewById(R.id.descriptionTextView)
        val descriptionLong: TextView = findViewById(R.id.descriptionLongTextView)

        headerImage.setImageResource(footballTile.headerImageID)
        titleTextView.text = footballTile.title
        descriptionTextView.text = footballTile.description
        descriptionLong.text = footballTile.descriptionLong

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_football_tile_detail,menu)

        if(footballTile.isFavourite) {
            menu?.findItem(R.id.menuItemFavourite)?.setIcon(R.drawable.ic_favourite_24dp)
        }

        return true
    }

}