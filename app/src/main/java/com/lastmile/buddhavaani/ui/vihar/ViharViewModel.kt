package com.lastmile.buddhavaani.ui.vihar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lastmile.buddhavaani.model.Result

class ViharViewModel : ViewModel() {
    private var movieLiveData: MutableLiveData<List<Result>>? = null


    fun observeMovieLiveData() : LiveData<List<Result>>? {
        movieLiveData = ViharRepository.getPopularMovies()
        return movieLiveData
    }


}