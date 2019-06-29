package com.marcotejeda.androidx_recycleview_sample.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marcotejeda.androidx_recycleview_sample.R
import com.marcotejeda.androidx_recycleview_sample.domain.model.BandModel
import com.marcotejeda.androidx_recycleview_sample.domain.model.SongModel
import com.marcotejeda.androidx_recycleview_sample.presentation.adapter.BandAdapter
import com.marcotejeda.androidx_recycleview_sample.presentation.adapter.SongAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val bands = mutableListOf<BandModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        populate()
        ui()
    }

    private fun ui(){
        rvAlbums.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = BandAdapter(bands) {
                renderSongs(it)
            }
        }

        rvSongs.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = SongAdapter(bands[0])
        }
    }

    private fun renderSongs(band: BandModel): RecyclerView {

        return rvSongs.apply {
            adapter = SongAdapter(band)
        }

    }

    private fun populate(){

        val songsGroup1 = mutableListOf<SongModel>()
        val songsGroup2 = mutableListOf<SongModel>()
        val songsGroup3 = mutableListOf<SongModel>()
        val songsGroup4 = mutableListOf<SongModel>()
        val songsGroup5 = mutableListOf<SongModel>()

        songsGroup1 += listOf(
            SongModel("T.N.T"),
            SongModel("Highway to hell"),
            SongModel("Shoot to trhill"),
            SongModel("T.N.T"),
            SongModel("Highway to hell")
        )

        songsGroup2 += listOf(
            SongModel("De música ligera"),
            SongModel("Nada personal"),
            SongModel("Cuando pase el temblo"),
            SongModel("De música ligera"),
            SongModel("Nada personal"),
            SongModel("Cuando pase el temblo")
        )

        songsGroup3 += listOf(
            SongModel("Bohemian Rhapsody"),
            SongModel("We are the champions"),
            SongModel("We will rock you"),
            SongModel("Bohemian Rhapsody"),
            SongModel("We are the champions")
        )

        songsGroup4 += listOf(
            SongModel("Puto"),
            SongModel("Frijolero"),
            SongModel("Puto"),
            SongModel("Frijolero")
        )

        songsGroup5 += listOf(
            SongModel("Roxane"),
            SongModel("Message in a bottle"),
            SongModel("Roxane"),
            SongModel("Message in a bottle")
        )

        bands += listOf(
            BandModel("AC/DC", "https://cdn2.albumoftheyear.org/690x/album/highway-to-hell.jpg", songsGroup1),
            BandModel("Soda Stereo", "https://cdn2.albumoftheyear.org/690x/album/117316-me-vers-volver-hits-ms.jpg", songsGroup2),
            BandModel("Queen", "https://cdn2.albumoftheyear.org/690x/album/7812-queen-ii.jpg", songsGroup3),
            BandModel("Molotov", "https://cdn2.albumoftheyear.org/690x/album/53578-dance-and-dense-denso.jpg", songsGroup4),
            BandModel("The Police", "https://cdn2.albumoftheyear.org/690x/album/15262-the-police.jpg", songsGroup5)
        )
    }

}
