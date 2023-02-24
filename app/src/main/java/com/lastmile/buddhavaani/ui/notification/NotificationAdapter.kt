package com.lastmile.buddhavaani.ui.notification

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lastmile.buddhavaani.model.Result
import com.lastmile.buddhavaani.databinding.NotificationsLayoutBinding

class NotificationAdapter : RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {
    private var movieList = ArrayList<Result>()

    fun setMovieList(movieList: List<Result>) {
        this.movieList = movieList as ArrayList<Result>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: NotificationsLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                NotificationsLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        /*Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500" + movieList[position].poster_path)
            .into(holder.binding.movieImage)
        holder.binding.movieName.text = movieList[position].title
        holder.binding.txtDesc.text = movieList[position].title*/

    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}