package com.marcotejeda.androidx_recycleview_sample.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marcotejeda.androidx_recycleview_sample.R
import com.marcotejeda.androidx_recycleview_sample.domain.model.BandModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.band_row.view.*

class BandAdapter(
    private val bands: List<BandModel>,
    private val listener: (BandModel) -> RecyclerView) : RecyclerView.Adapter<BandAdapter.VH>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.band_row, parent, false)
        return VH(view)
    }

    override fun getItemCount() = bands.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(bands[position], listener)
    }

    class VH(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(band: BandModel, listener: (BandModel) -> RecyclerView) = with(view){
            Picasso.get().load(band.image).into(view.ivRowBand)
            setOnClickListener{
                listener(band)
            }
        }

    }

}
