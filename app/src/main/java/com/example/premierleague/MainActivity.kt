package com.example.premierleague

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),FootballTileInterface {

    private lateinit var footballTileList: ArrayList<FootballTile>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Premier league teams"
        footballTileList = getList()

        val footballTileAdapter = FootballTileAdapter(footballTileList,this)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = footballTileAdapter

        footballTileAdapter.notifyDataSetChanged()

        }

    override fun onLearnMoreButtonClicked(position: Int) {

        val footballTile = footballTileList[position]
        val intent = Intent(this,DetailActivity::class.java).apply {
            putExtra("footballTile",footballTile)
        }
        startActivity(intent)
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
                    headerImageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2Fmanchester-united-twitter-header--526499012685938517%2F&psig=AOvVaw2alYWUKsYcrwW5wTTcJLcO&ust=1678970864376000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCKCihYL83f0CFQAAAAAdAAAAABAE",
                    teamUrl = "https://www.manutd.com/"
                ))
            add(
                FootballTile(
                    id = "manchester_city",
                    title = "Manchester City",
                    description = "SOME TEXT",
                    descriptionLong = "Some more text",
                    buttonText = "Learn more",
                    headerImageID = R.drawable.mancity_header,
                    headerImageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2Fmanchester-city-twitter-header--707909635156348947%2F&psig=AOvVaw1cmYpy1KUXxIY6Yzv06_59&ust=1678971065055000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCMDW2OH83f0CFQAAAAAdAAAAABAD",
                    teamUrl = "https://www.mancity.com/"
                ))
            add(
                FootballTile(
                    id = "chelsea",
                    title = "Chelsea",
                    description = "SOME TEXT",
                    descriptionLong = "Some more text",
                    buttonText = "Learn more",
                    headerImageID = R.drawable.chelsea_header,
                    headerImageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Ff-edits.tumblr.com%2Fpost%2F150435158577%2Fchelsea-twitter-header&psig=AOvVaw1tSVL-iEgPg2RJg4hTVm7J&ust=1678971413026000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCNjMsYf-3f0CFQAAAAAdAAAAABAb",
                    teamUrl = "https://www.chelseafc.com/"
                ))
            add(
                FootballTile(
                    id = "liverpul",
                    title = "Liverpul",
                    description = "SOME TEXT",
                    descriptionLong = "Some more text",
                    buttonText = "Learn more",
                    headerImageID = R.drawable.liverpul_header,
                    headerImageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fsportsteamhistory.com%2Fthe-rich-and-glorious-liverpool-fc-history%2F&psig=AOvVaw0BP21VfaKcIK0i1H83iH__&ust=1678971367043000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCMiyuPH93f0CFQAAAAAdAAAAABAE",
                    teamUrl = "https://www.liverpool.com/"
                ))
            add(
                FootballTile(
                    id = "tottenham",
                    title = "Tottenham",
                    description = "SOME TEXT",
                    descriptionLong = "Some more text",
                    buttonText = "Learn more",
                    headerImageID = R.drawable.tottenham_header,
                    headerImageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Ff-edits.tumblr.com%2Fpost%2F151100205100%2Ftottenham-hotspur-twitter-header&psig=AOvVaw3uEzg6hNnvGVlNis3dyO54&ust=1678971236205000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCIDJorP93f0CFQAAAAAdAAAAABAE",
                    teamUrl = "https://www.tottenhamhotspur.com/"
                ))
            add(
                FootballTile(
                    id = "arsenal",
                    title = "Arsenal",
                    description = "SOME TEXT",
                    descriptionLong = "Some more text",
                    buttonText = "Learn more",
                    headerImageID = R.drawable.arsenal_header,
                    headerImageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.pinterest.com%2Fpin%2F707909635156348949%2F&psig=AOvVaw2YE-1pIp80Ar8NJsj-MeTT&ust=1678971297205000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCOinrND93f0CFQAAAAAdAAAAABAE",
                    teamUrl = "https://www.arsenal.com/"
                ))
            add(
                FootballTile(
                    id = "leicester",
                    title = "Leicester",
                    description = "SOME TEXT",
                    descriptionLong = "Some more text",
                    buttonText = "Learn more",
                    headerImageID = R.drawable.leicester_header,
                    headerImageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Ftwitter.com%2FF_Edits%2Fstatus%2F773110666102267904&psig=AOvVaw2-4MnDqeHcked6Jy0sICRl&ust=1678971151825000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCNimkYv93f0CFQAAAAAdAAAAABAF",
                    teamUrl = "https://www.lcfc.com/"
                ))

        }


    }
}