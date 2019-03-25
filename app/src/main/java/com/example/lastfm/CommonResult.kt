package com.example.lastfm

import java.io.Serializable

class CommonResult : Serializable {

    private lateinit var name: String
    private var artist: String? = null
    private lateinit var url: String
    private lateinit var streamable: String
    private lateinit var listeners: String
    private lateinit var image: List<Image>

    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getArtist(): String? {
        return artist
    }

    fun setArtist(artist: String) {
        this.artist = artist
    }

    fun getUrl(): String {
        return url
    }

    fun setUrl(url: String) {
        this.url = url
    }

    fun getImage(): List<Image> {
        return image
    }

    fun setImage(image: List<Image>) {
        this.image = image
    }

    fun getStreamable(): String {
        return streamable
    }

    fun setStreamable(streamable: String) {
        this.streamable = streamable
    }

    fun getListeners(): String {
        return listeners
    }

    fun setListeners(listeners: String) {
        this.listeners = listeners
    }
}