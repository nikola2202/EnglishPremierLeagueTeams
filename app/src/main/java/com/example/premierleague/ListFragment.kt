package com.example.premierleague

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class ListFragment: BaseMainActivityFragment(R.layout.fragment_list) {

    private lateinit var footballTileAdapter: FootballTileAdapter
    private val footballTileList: ArrayList<FootballTile>
        get() = mainActivity.footballTileList

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainActivity.supportActionBar?.apply {
            setToolbarTitle("Premier League")
            setDisplayHomeAsUpEnabled(false)
        }

        footballTileAdapter = FootballTileAdapter(footballTileList,mainActivity)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = footballTileAdapter
    }

    override fun onResume() {
        super.onResume()
        footballTileAdapter.notifyDataSetChanged()
    }

    fun onFavouriteClicked(position: Int) {
        footballTileAdapter.notifyItemChanged(position)
    }

}