package com.lastmile.buddhavaani.ui.fundraisers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lastmile.buddhavaani.model.Result
import com.lastmile.buddhavaani.databinding.FundraisersLayoutBinding

class FundsraisersAdapter : RecyclerView.Adapter<FundsraisersAdapter.ViewHolder>() {
    private var movieList = ArrayList<Result>()

    fun setMovieList(movieList: List<Result>) {
        this.movieList = movieList as ArrayList<Result>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: FundraisersLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FundraisersLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
//            .load("https://image.tmdb.org/t/p/w500" + movieList[position].imgUrl)
            .load(movieList[position].imgUrl)
            .into(holder.binding.movieImage)
        holder.binding.movieName.text = movieList[position].projectTitle
//        holder.binding.txtDesc.text = movieList[position].title

    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}