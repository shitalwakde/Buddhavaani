package com.lastmile.buddhavaani.ui.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lastmile.buddhavaani.model.Result

class FeedViewModel : ViewModel() {
    private var movieLiveData: MutableLiveData<List<Result>>? = null


    fun observeMovieLiveData() : LiveData<List<Result>>? {
        movieLiveData = FeedRepository.getPopularMovies()
        return movieLiveData
    }

}