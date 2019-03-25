package com.example.lastfm

class Image {

    private lateinit var text: String
    private lateinit var size: String

    fun getText(): String {
        return text
    }

    fun setText(text: String) {
        this.text = text
    }

    fun getSize(): String {
        return size
    }

    fun setSize(size: String) {
        this.size = size
    }
}