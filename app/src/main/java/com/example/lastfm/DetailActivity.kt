package com.example.lastfm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val item: CommonResult =
            Gson().fromJson(intent.getStringExtra(resources.getString(R.string.ITEM)), CommonResult::class.java)

        name.text = item.getName()
        artist.text = item.getArtist()
        url.text = item.getUrl()
        listeners.text = item.getListeners()
        streamable.text = item.getStreamable()

        val imgURL = item.getImage()[3].getText()

        if (imgURL.isNotEmpty()) {
            Picasso.with(this)
                .load(imgURL).placeholder(R.color.cardview_dark_background)
                .error(R.color.cardview_dark_background)
                .into(image)
        }

    }
}
