package com.example.lastfm

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity(), View.OnClickListener, RadioGroup.OnCheckedChangeListener {


    private var type: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        btnSearch?.setOnClickListener(this)
        radio?.setOnCheckedChangeListener(this)
    }

    override fun onClick(view: View) {
        if (keyword?.text.toString().isEmpty()) {
            return
        }
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(resources.getString(R.string.KEYWORD), keyword!!.text.toString())
        intent.putExtra(
            resources.getString(R.string.TYPE),
            type
        ) // type 0 for search by Album/song, type 1 for search by artist.
        startActivity(intent)
    }

    override fun onCheckedChanged(radioGroup: RadioGroup, i: Int) {
        type = i
        keyword!!.setHint(R.string.enter_keyword)
    }
}
