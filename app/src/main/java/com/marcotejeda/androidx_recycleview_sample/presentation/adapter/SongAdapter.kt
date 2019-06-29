package com.marcotejeda.androidx_recycleview_sample.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marcotejeda.androidx_recycleview_sample.R
import com.marcotejeda.androidx_recycleview_sample.domain.model.BandModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.song_row.view.*

class SongAdapter(private val band: BandModel) : RecyclerView.Adapter<SongAdapter.VH>() {

    private val songs = band.songList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.song_row, parent, false)
        return VH(view)
    }

    override fun getItemCount() = songs.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(band, position)
    }

    class VH(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(band: BandModel, position: Int){
            Picasso.get().load(band.image).into(view.ivRowSongImage)
            view.tvRowSongPos.text = (position + 1).toString()
            view.tvRowBandName.text = band.name
            view.tvRowSongTitle.text = band.songList[position].title
        }

    }

}
