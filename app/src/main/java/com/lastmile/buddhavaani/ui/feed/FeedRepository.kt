package com.lastmile.buddhavaani.ui.feed

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.lastmile.buddhavaani.data.RetrofitClient
import com.lastmile.buddhavaani.model.Movies
import com.lastmile.buddhavaani.model.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object FeedRepository {
    private val movieResult = MutableLiveData<List<Result>>()

    fun getPopularMovies(): MutableLiveData<List<Result>> {
        RetrofitClient.apiInterface.getPopularMovies("69d66957eebff9666ea46bd464773cf0").enqueue(object  :
            Callback<Movies> {
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                if (response.body()!=null){
                    movieResult.value = response.body()!!.results
                }
                else{
                    return
                }
            }
            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }
        })

        return movieResult
    }
}