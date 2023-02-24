package com.lastmile.buddhavaani.ui.signup

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lastmile.buddhavaani.model.Movies
import com.lastmile.buddhavaani.model.User

class SignupViewModel: ViewModel() {
    private var userResult: MutableLiveData<Movies>? = null
    var liveDataUser: LiveData<User>? = null

    fun insertData(context: Context, username: String, password: String) {
        SignupRepository.inserData(context, username, password)
    }

    fun getUserDetails(context: Context, username: String) : LiveData<User>? {
        liveDataUser = SignupRepository.getUserDetails(context, username)
        return liveDataUser
    }

    fun observeUserLiveData() : LiveData<Movies>? {
        userResult = SignupRepository.getUserData()
        return userResult
    }


}