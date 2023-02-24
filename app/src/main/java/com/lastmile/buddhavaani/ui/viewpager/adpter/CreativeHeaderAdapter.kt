package com.lastmile.buddhavaani.ui.viewpager.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Guideline
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.lastmile.buddhavaani.R
import com.lastmile.buddhavaani.ui.viewpager.creativeviewpager.CreativeViewPager.Companion.SCALE_MIN
import com.lastmile.buddhavaani.ui.viewpager.adpter.CreativeHeaderAdapter.PagerImageViewHolder

class CreativeHeaderAdapter(val parent: ViewGroup,
                            private val verticalGuideline: Guideline,
                            private val imagesSize: Float, private val imagesMargin: Float,
                            private val onImageClick: ((Int) -> Unit)) :
        Adapter<PagerImageViewHolder>() {

  var creativePagerAdapter: CreativePagerAdapter? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerImageViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val rootView = inflater.inflate(R.layout.item_creative_image,
            parent, false)

    return PagerImageViewHolder(rootView)
  }

  override fun getItemCount(): Int {
    return creativePagerAdapter?.getCount() ?: 0
  }

  override fun onBindViewHolder(holder: PagerImageViewHolder, position: Int) {
    val container = holder.itemView as ViewGroup
    val profileRootView = creativePagerAdapter?.instantiateContentItem(
            LayoutInflater.from(holder.itemView.context), container, position)
    container.removeAllViews()
    container.addView(profileRootView)

    val marginLayoutParams = holder.itemView.layoutParams as MarginLayoutParams
    val layoutParams = verticalGuideline.layoutParams as ConstraintLayout.LayoutParams
    val parentMargin = layoutParams.guidePercent * parent.width

    marginLayoutParams.marginStart = imagesMargin.toInt()
    marginLayoutParams.marginEnd = imagesMargin.toInt()

    if (position == 0) {
      marginLayoutParams.marginStart = (parentMargin - imagesSize / 2).toInt()
    } else if (position == itemCount - 1) {
      marginLayoutParams.marginEnd = (parent.width - (parentMargin + imagesSize / 2)).toInt()
    }

    if (position != 0) {
      marginLayoutParams.width = (imagesSize * SCALE_MIN).toInt()
      marginLayoutParams.height = (imagesSize * SCALE_MIN).toInt()
    }

    holder.itemView.requestLayout()

    holder.itemView.setOnClickListener { onImageClick(holder.adapterPosition) }
  }

  class PagerImageViewHolder(itemView: View) : ViewHolder(itemView)
}