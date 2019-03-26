package com.example.lastfm

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.custom_row.view.*


internal class CustomAdapter(
    private val context: Context,
    private val dataList: List<CommonResult>,
    private val recyclerView: RecyclerView
) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>(), View.OnClickListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.custom_row, parent, false)
        view.setOnClickListener(this)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.view.title.text = dataList[position].getName()
        holder.view.artist.text = dataList[position].getArtist()
        holder.view.url.text = dataList[position].getUrl()
        val imageUrl = dataList[position].getImage()[2].getText()
        if (imageUrl.length > 0) {
            Picasso.with(context)
                .load(imageUrl).placeholder(R.color.cardview_dark_background)
                .error(R.color.cardview_dark_background)
                .into(holder.view.image)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onClick(view: View) {
        val itemPosition = recyclerView.getChildLayoutPosition(view)
        val result = dataList[itemPosition]
        //Toast.makeText(context, item, Toast.LENGTH_LONG).show()
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(context.resources.getString(R.string.ITEM), Gson().toJson(result))
        context.startActivity(intent)
    }

    internal class CustomViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        var view: View = mView
    }
}