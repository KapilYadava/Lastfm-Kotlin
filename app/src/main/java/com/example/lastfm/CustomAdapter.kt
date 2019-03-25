package com.example.lastfm

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.Gson
import com.squareup.picasso.Picasso


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
        holder.txtTitle.text = dataList[position].getName()
        holder.txtArtist.text = dataList[position].getArtist()
        holder.txtUrl.text = dataList[position].getUrl()
        val imageUrl = dataList[position].getImage()[2].getText()
        if (imageUrl.length > 0) {
            Picasso.with(context)
                .load(imageUrl).placeholder(R.color.cardview_dark_background)
                .error(R.color.cardview_dark_background)
                .into(holder.imageView)
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

    internal class CustomViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {

        var txtTitle: TextView
        var txtArtist: TextView
        var txtUrl: TextView
        var imageView: ImageView

        init {
            imageView = mView.findViewById(R.id.image)
            txtTitle = mView.findViewById(R.id.title)
            txtArtist = mView.findViewById(R.id.artist)
            txtUrl = mView.findViewById(R.id.url)
        }

    }
}