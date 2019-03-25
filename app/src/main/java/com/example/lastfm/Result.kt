package com.example.lastfm

class Result {

    private lateinit var results: ResultMatches

    fun getResults(): ResultMatches {
        return results
    }

    fun setResults(results: ResultMatches) {
        this.results = results
    }

}