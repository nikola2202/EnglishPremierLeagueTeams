package com.example.premierleague

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

            footballTile = intent.getSerializableExtra("footballTile") as? FootballTile?: FootballTile(
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
                Log.i("URL",footballTile.teamUrl)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_football_tile_detail,menu)
        return true
    }

}