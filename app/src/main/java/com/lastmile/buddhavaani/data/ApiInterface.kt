package com.lastmile.buddhavaani.data

import com.lastmile.buddhavaani.model.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("popular?")
    fun getPopularMovies(@Query("api_key") api_key : String) : Call<Movies>

    @GET("https://mocki.io/v1/6e429ee0-66ee-40bc-8809-5c369b92fda7")
    fun getPopularMoviesFunds() : Call<Movies>

    @GET("https://mocki.io/v1/f1db67a4-8836-4770-b2f1-7f123d610941")
    fun getUsersList() : Call<Movies>

    @GET("https://mocki.io/v1/e7d89246-5a43-45e5-af46-77f56dbb7a23")
    fun getUser() : Call<Movies>

    @GET("https://mocki.io/v1/f8f15a35-be67-4799-98bd-ce4b96d8da89")
    fun getUserProfile() : Call<Movies>

    /*@GET("v2/top-headlines?country=in&apiKey="+ BuildConfig.API)
    suspend fun getNews(): Response<NewsResponse>*/
}