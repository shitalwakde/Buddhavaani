package com.lastmile.buddhavaani.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lastmile.buddhavaani.model.Result

class ProfileViewModel : ViewModel() {
    private var movieLiveData: MutableLiveData<List<Result>>? = null


    fun observeMovieLiveData() : LiveData<List<Result>>? {
        movieLiveData = ProfileRepository.getPopularMovies()
        return movieLiveData
    }

}