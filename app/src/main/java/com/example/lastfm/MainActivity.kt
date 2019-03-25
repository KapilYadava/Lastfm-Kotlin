package com.example.lastfm

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var adapter: CustomAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var progressDialog: ProgressDialog? = null
    private var keyword: String? = null
    private var type: Int = 0
    private lateinit var listView: RecyclerView

    //String URL = "http://ws.audioscrobbler.com/2.0/?method=album.search&album=criminal&api_key=c3b522819f98239ec82a72a11d397899&format=json";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listView)

        val intent = intent
        keyword = intent.getStringExtra("KEYWORD")
        type = intent.getIntExtra("TYPE", 0)

        progressDialog = ProgressDialog(this@MainActivity)
        progressDialog!!.setMessage("Loading....")
        progressDialog!!.show()

        var service = RetrofitClientInstance().getRetrofitInstance()!!.create(Endpoint::class.java)
        var call: Call<String>? = null
        if (type == R.id.byAlbum)
            call = service.getAlbums("album.search", keyword!!, resources.getString(R.string.last_fm_api_key), "json")
        else if (type == R.id.byArtist)
            call = service.getArtists("artist.search", keyword!!, resources.getString(R.string.last_fm_api_key), "json")
        else
            call = service.getTracks("track.search", keyword!!, resources.getString(R.string.last_fm_api_key), "json")

        call!!.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                progressDialog!!.dismiss()
                generateDataList(response.body()!!)
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                progressDialog!!.dismiss()
            }
        })
    }

    private fun generateDataList(response: String) {
        val cleanedResponse = response.replace("#text", "text")
        val result = Gson().fromJson(cleanedResponse, Result::class.java)
        recyclerView = findViewById(R.id.listView)
        recyclerView!!.setHasFixedSize(true)
        var common: List<CommonResult>? = null
        if (type == R.id.byAlbum)
            common = result.getResults().getAlbumMatches().getAlbum()
        else if (type == R.id.byArtist)
            common = result.getResults().getArtistmatches().getArtist()
        else
            common = result.getResults().getTrackmatches().getTrack()

        adapter = CustomAdapter(this, common, listView)
        val layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = adapter
    }

}
