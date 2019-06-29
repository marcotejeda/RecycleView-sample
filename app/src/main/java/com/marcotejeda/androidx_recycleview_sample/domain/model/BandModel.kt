package com.marcotejeda.androidx_recycleview_sample.domain.model

data class BandModel (
    val name: String,
    val image: String,
    val songList: List<SongModel>
)