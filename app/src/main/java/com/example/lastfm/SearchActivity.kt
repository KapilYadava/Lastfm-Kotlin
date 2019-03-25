package com.example.lastfm

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup

class SearchActivity : AppCompatActivity(), View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private var keyword: EditText? = null
    private var radioGroup: RadioGroup? = null
    private var type: Int = 0
    private var btnSearch: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        keyword = findViewById(R.id.keyword)
        radioGroup = findViewById(R.id.radio)
        btnSearch = findViewById(R.id.btnSearch)
        btnSearch?.setOnClickListener(this)
        radioGroup!!.setOnCheckedChangeListener(this)
    }

    override fun onClick(view: View) {
        if (keyword?.text.toString().isEmpty()) {
            return
        }
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("KEYWORD", keyword!!.text.toString())
        intent.putExtra("TYPE", type) // type 0 for search by Album/song, type 1 for search by artist.
        startActivity(intent)
    }

    override fun onCheckedChanged(radioGroup: RadioGroup, i: Int) {
        type = i
        keyword!!.setHint(R.string.enter_keyword)
    }
}
