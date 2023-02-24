package com.lastmile.buddhavaani.ui.membership

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lastmile.buddhavaani.model.Result

class MembershipViewModel : ViewModel() {
    private var movieLiveData: MutableLiveData<List<Result>>? = null


    fun observeMovieLiveData() : LiveData<List<Result>>? {
        movieLiveData = MembershipRepository.getPopularMovies()
        return movieLiveData
    }
}