package com.example.premierleague

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),FootballTileInterface {

    lateinit var footballTileList: ArrayList<FootballTile>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        footballTileList = getList()

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.fragment_container_view,ListFragment())
        }

    }
    override fun onLearnMoreButtonClicked(position: Int) {

        val footballTile = footballTileList[position]
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            addToBackStack(null)
            val bundle = Bundle().apply {
                putString("footballTileId",footballTile.id)
            }

            setCustomAnimations(
                R.anim.fragment_slide_right,
                R.anim.fragment_slide_out_left
            )

            replace(R.id.fragment_container_view,DetailFragment().apply {
                arguments = bundle
            })
        }
    }

    override fun onFavouriteClicked(position: Int) {
        val footballTile = footballTileList[position]
        footballTile.isFavourite = !footballTile.isFavourite
        (supportFragmentManager.fragments[0] as? ListFragment)?.onFavouriteClicked(position)

        SharedPreferencesUtil.setFootballTileFavourite(footballTile.id,footballTile.isFavourite)

    }

    fun getList(): ArrayList<FootballTile> {
                return ArrayList<FootballTile>().apply {
            add(
                FootballTile(
                    id = "manchester_united",
                    title = "Manchester United",
                    description = "SOME TEXT",
                    descriptionLong = "Some more text",
                    buttonText = "Learn more",
                    headerImageID = R.drawable.manu_header,
                    headerImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSMAIUwsvyM47GmKXA-vPrQZUGraAz4ffZSICgQkaiAUA&s",
                    teamUrl = "https://www.manutd.com/",
                    isFavourite = SharedPreferencesUtil.getFootballTileFavourite("manchester_united")
                ))
            add(
                FootballTile(
                    id = "manchester_city",
                    title = "Manchester City",
                    description = "SOME TEXT",
                    descriptionLong = "Some more text",
                    buttonText = "Learn more",
                    headerImageID = R.drawable.mancity_header,
                    headerImageUrl = "https://i.pinimg.com/originals/8f/11/48/8f11480ce075ee1ad4f006f8e4f2be8d.jpg",
                    teamUrl = "https://www.mancity.com/",
                    isFavourite = SharedPreferencesUtil.getFootballTileFavourite("manchester_city")
                ))
            add(
                FootballTile(
                    id = "chelsea",
                    title = "Chelsea",
                    description = "SOME TEXT",
                    descriptionLong = "Some more text",
                    buttonText = "Learn more",
                    headerImageID = R.drawable.chelsea_header,
                    headerImageUrl = "https://64.media.tumblr.com/4163bc45d59f167c164b84cc7cfd5f9c/tumblr_od5gi53Zgi1ude0uno1_500h.jpg",
                    teamUrl = "https://www.chelseafc.com/",
                    isFavourite = SharedPreferencesUtil.getFootballTileFavourite("chelsea")
                ))
            add(
                FootballTile(
                    id = "liverpool",
                    title = "Liverpool",
                    description = "SOME TEXT",
                    descriptionLong = "Some more text",
                    buttonText = "Learn more",
                    headerImageID = R.drawable.liverpul_header,
                    headerImageUrl = "https://pbs.twimg.com/media/CrVea3NVMAAEhKn?format=jpg&name=4096x4096",
                    teamUrl = "https://www.liverpool.com/",
                    isFavourite = SharedPreferencesUtil.getFootballTileFavourite("liverpool")
                ))
            add(
                FootballTile(
                    id = "tottenham",
                    title = "Tottenham",
                    description = "SOME TEXT",
                    descriptionLong = "Some more text",
                    buttonText = "Learn more",
                    headerImageID = R.drawable.tottenham_header,
                    headerImageUrl = "https://i.pinimg.com/736x/a5/91/3b/a5913b877183e02ab86b2d59708c565a.jpg",
                    teamUrl = "https://www.tottenhamhotspur.com/",
                    isFavourite = SharedPreferencesUtil.getFootballTileFavourite("tottenham")
                ))
            add(
                FootballTile(
                    id = "arsenal",
                    title = "Arsenal",
                    description = "SOME TEXT",
                    descriptionLong = "Some more text",
                    buttonText = "Learn more",
                    headerImageID = R.drawable.arsenal_header,
                    headerImageUrl = "https://i.pinimg.com/originals/00/b9/57/00b957e908fd86d72b3e014892d4b895.jpg",
                    teamUrl = "https://www.arsenal.com/",
                    isFavourite = SharedPreferencesUtil.getFootballTileFavourite("arsenal")
                ))
            add(
                FootballTile(
                    id = "leicester",
                    title = "Leicester",
                    description = "SOME TEXT",
                    descriptionLong = "Some more text",
                    buttonText = "Learn more",
                    headerImageID = R.drawable.leicester_header,
                    headerImageUrl = "https://pbs.twimg.com/media/Crqj7hGW8AAhXJW.jpg",
                    teamUrl = "https://www.lcfc.com/",
                    isFavourite = SharedPreferencesUtil.getFootballTileFavourite("leicester")
                ))

        }


    }
}