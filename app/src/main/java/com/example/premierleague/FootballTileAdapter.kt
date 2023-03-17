package com.example.premierleague

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class FootballTileAdapter(
    private val data: ArrayList<FootballTile>,
    private val footballtileInterface: FootballTileInterface
    ): RecyclerView.Adapter<FootballTileAdapter.FootballTileViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootballTileViewHolder {
        return FootballTileViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: FootballTileViewHolder, position: Int) {
        holder.onBind(data[position],footballtileInterface)
    }

    inner class FootballTileViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
            (
                LayoutInflater.from(parent.context).inflate(R.layout.view_holder,parent,false)
            )
                {
                    val headerImageView: ImageView = itemView.findViewById(R.id.teamHeaderImageView)
                    val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
                    val desriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
                    val button: MaterialButton = itemView.findViewById(R.id.button)

                    fun onBind(footballTIle:FootballTile,footballtileInterface: FootballTileInterface) {
                        headerImageView.setImageResource(footballTIle.headerImageID)
                        titleTextView.text = footballTIle.title
                        desriptionTextView.text = footballTIle.description

                        button.setOnClickListener{
                            footballtileInterface.onLearnMoreButtonClicked(adapterPosition)
                        }
                    }
                }

}