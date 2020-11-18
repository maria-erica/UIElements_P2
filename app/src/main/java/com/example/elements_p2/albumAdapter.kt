package com.example.elements_p2

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView

class albumAdapter(val c : Context) : BaseAdapter(){
    private val mContext: Context
    init {
        mContext = c
}
    var thumImages = arrayOf<Int>(
            R.drawable.maroon,
            R.drawable.katy_perry ,
            R.drawable.yonce,
            R.drawable.justin_bieber,
            R.drawable.bon_jovi
    )

    override fun getCount(): Int {
        return thumImages.size

    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView = ImageView(mContext)
        imageView.setLayoutParams(GridView@ AbsListView.LayoutParams(300, 300))
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        imageView.setPadding(20, 20, 20, 20)
        imageView.setImageResource(thumImages[position])
        return imageView
    }
}