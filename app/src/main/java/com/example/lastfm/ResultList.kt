package com.example.lastfm

class ResultList {

    private lateinit var album: List<CommonResult>
    private lateinit var artist: List<CommonResult>
    private lateinit var track: List<CommonResult>

    fun getAlbum(): List<CommonResult> {
        return album;
    }

    fun setAlbum(album: List<CommonResult>) {
        this.album = album;
    }

    fun getArtist(): List<CommonResult> {
        return artist;
    }

    fun setArtist(artist: List<CommonResult>) {
        this.artist = artist;
    }

    fun getTrack(): List<CommonResult> {
        return track;
    }

    fun setTrack(track: List<CommonResult>) {
        this.track = track;
    }
}