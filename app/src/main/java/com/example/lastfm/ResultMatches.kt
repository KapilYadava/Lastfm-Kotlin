package com.example.lastfm

class ResultMatches {

    private lateinit var albummatches: ResultList
    private lateinit var artistmatches: ResultList
    private lateinit var trackmatches: ResultList

    fun getAlbumMatches(): ResultList {
        return albummatches
    }

    fun setAlbumMatches(albumMatches: ResultList) {
        this.albummatches = albumMatches
    }

    fun getAlbummatches(): ResultList {
        return albummatches
    }

    fun setAlbummatches(albummatches: ResultList) {
        this.albummatches = albummatches
    }

    fun getArtistmatches(): ResultList {
        return artistmatches
    }

    fun setArtistmatches(artistmatches: ResultList) {
        this.artistmatches = artistmatches
    }

    fun getTrackmatches(): ResultList {
        return trackmatches
    }

    fun setTrackmatches(trackmatches: ResultList) {
        this.trackmatches = trackmatches
    }
}