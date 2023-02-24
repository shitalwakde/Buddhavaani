package com.lastmile.buddhavaani.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lastmile.buddhavaani.model.Result
import com.lastmile.buddhavaani.databinding.ItemNewsBinding

class NewsAdapter(): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    private var movieList = ArrayList<Result>()

    fun setnewsList(news: List<Result>) {
        this.movieList = news as ArrayList<Result>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        return ViewHolder(
            ItemNewsBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500" + movieList[position].poster_path)
            .into(holder.binding.movieImage)
        holder.binding.txtDesc.text = movieList[position].title
//        holder.binding.txtDesc.text = news[position].description
    }

    override fun getItemCount(): Int = movieList.count()

    fun addData(list: List<Result>){
        movieList.addAll(list)
    }
}