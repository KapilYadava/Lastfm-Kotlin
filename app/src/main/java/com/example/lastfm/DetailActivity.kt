package com.example.lastfm

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

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

        var intent = intent
        var item = intent.getSerializableExtra("ITEM") as CommonResult
        textName.setText(item.getName())
        textArtist.setText(item.getArtist())
        textURL.setText(item.getUrl())
        textListener.setText(item.getListeners())
        textStream.setText(item.getStreamable())

        var imgURL = item.getImage()[3].getText()

        if (imgURL.length > 0) {
            Picasso.with(this)
                .load(imgURL).placeholder(R.color.cardview_dark_background)
                .error(R.color.cardview_dark_background)
                .into(imageView)
        }

    }
}
