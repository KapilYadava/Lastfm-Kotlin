package com.example.lastfm

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

abstract interface Endpoint {
    @GET("/2.0")
    abstract fun getAlbums(
        @Query("method") method: String,
        @Query("album") album: String,
        @Query("api_key") api_key: String,
        @Query("format") format: String
    ): Call<String>

    @GET("/2.0")
    abstract fun getArtists(
        @Query("method") method: String,
        @Query("artist") artist: String,
        @Query("api_key") api_key: String,
        @Query("format") format: String
    ): Call<String>

    @GET("/2.0")
    abstract fun getTracks(
        @Query("method") method: String,
        @Query("track") artist: String,
        @Query("api_key") api_key: String,
        @Query("format") format: String
    ): Call<String>
}