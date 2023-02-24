package com.lastmile.buddhavaani.ui.notification

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lastmile.buddhavaani.model.Result

class NotificationsViewModel : ViewModel() {
    private var movieLiveData: MutableLiveData<List<Result>>? = null


    fun observeMovieLiveData() : LiveData<List<Result>>? {
        movieLiveData = NotificationRepository.getPopularMovies()
        return movieLiveData
    }
}