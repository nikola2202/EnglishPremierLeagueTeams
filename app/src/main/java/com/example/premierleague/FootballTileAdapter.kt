package com.example.premierleague

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class FootballTileAdapter(
    private val data: ArrayList<FootballTile>,
    private val footballTileInterface: FootballTileInterface
    ): RecyclerView.Adapter<FootballTileAdapter.FootballTileViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootballTileViewHolder {
        return FootballTileViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: FootballTileViewHolder, position: Int) {
        holder.onBind(data[position],footballTileInterface)
    }

    inner class FootballTileViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
            (
                LayoutInflater.from(parent.context).inflate(R.layout.view_holder,parent,false)
            )
                {
                    private val headerImageView: ImageView = itemView.findViewById(R.id.teamHeaderImageView)
                    private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
                    private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
                    private val button: MaterialButton = itemView.findViewById(R.id.button)
                    private val favouriteImageView: AppCompatImageView = itemView.findViewById(R.id.favouriteImageView)

                    fun onBind(footballTile:FootballTile,footballTileInterface: FootballTileInterface) {
                        headerImageView.setImageResource(footballTile.headerImageID)
                        titleTextView.text = footballTile.title
                        descriptionTextView.text = footballTile.description

                        button.setOnClickListener{
                            footballTileInterface.onLearnMoreButtonClicked(adapterPosition)
                        }
                        val icon = if(footballTile.isFavourite) R.drawable.ic_favourite_24dp else R.drawable.ic_favorite_outline_24dp
                        favouriteImageView.setImageResource(icon)
                        favouriteImageView.setOnClickListener {
                            footballTileInterface.onFavouriteClicked(adapterPosition)
                        }

                    }
                }

}