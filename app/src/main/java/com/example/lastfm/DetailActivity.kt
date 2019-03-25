package com.example.lastfm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.Gson
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var textName: TextView
    private lateinit var textArtist: TextView
    private lateinit var textURL: TextView
    private lateinit var textListener: TextView
    private lateinit var textStream: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        imageView = findViewById(R.id.image)
        textName = findViewById(R.id.name)
        textArtist = findViewById(R.id.artist)
        textURL = findViewById(R.id.url)
        textListener = findViewById(R.id.listeners)
        textStream = findViewById(R.id.streamable)

        val item: CommonResult =
            Gson().fromJson(intent.getStringExtra(resources.getString(R.string.ITEM)), CommonResult::class.java)

        textName.text = item.getName()
        textName.text = item.getName()
        textArtist.text = item.getArtist()
        textURL.text = item.getUrl()
        textListener.text = item.getListeners()
        textStream.text = item.getStreamable()

        val imgURL = item.getImage()[3].getText()

        if (imgURL.isNotEmpty()) {
            Picasso.with(this)
                .load(imgURL).placeholder(R.color.cardview_dark_background)
                .error(R.color.cardview_dark_background)
                .into(imageView)
        }

    }
}
