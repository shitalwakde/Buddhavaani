package com.lastmile.buddhavaani.ui.home.viewpager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.lastmile.buddhavaani.R

class ImagePagerAdapter: PagerAdapter {

    var imagesList: List<Int>? = null
//    var context: Context? = null
    var currentPosition = -1

    constructor(/*context: Context, */imagesList: List<Int>): super() {
        this.imagesList = imagesList
//        this.context = context
    }

    override fun getCount(): Int {
        return imagesList?.size!!
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context).inflate(R.layout.view_item, container, false)
        val imageView: ImageView = view.findViewById(R.id.iv_item)
        container.addView(view)
        Glide.with(container.context!!)
            .load(imagesList?.get(position))
            .into(imageView)
        return view
    }

    override fun setPrimaryItem(container: ViewGroup, position: Int, `object`: Any) {
        super.setPrimaryItem(container, position, `object`)
        if (container !is AdjustingViewPager)
            return
        if (position != currentPosition) {
            val viewPager: AdjustingViewPager = container
            currentPosition = position;
            viewPager.measureCurrentView(`object` as View)
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}