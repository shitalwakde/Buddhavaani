package com.lastmile.buddhavaani.data

import com.lastmile.buddhavaani.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

//    const val MainServer = "https://mocki.io/"
    const val MainServer = "https://api.themoviedb.org/3/movie/"

    //    const val MainServer = "https://mocki.io/v1/6e429ee0-66ee-40bc-8809-5c369b92fda7"
    //    const val MainServer = "http://api.drfriday.in/api/user/"
    //    const val MainServer = "https://mahachaha.com/"
    const val ImageMainServer = "http://api.drfriday.in/"


    val retrofitClient: Retrofit.Builder by lazy {
        val levelType: HttpLoggingInterceptor.Level
        if (BuildConfig.BUILD_TYPE.contentEquals("debug"))
            levelType = HttpLoggingInterceptor.Level.BODY else levelType = HttpLoggingInterceptor.Level.NONE

        val logging = HttpLoggingInterceptor()
        logging.setLevel(levelType)

        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.addInterceptor(logging)

        Retrofit.Builder()
                .baseUrl(MainServer)
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
    }

    val apiInterface: ApiInterface by lazy {
        retrofitClient
                .build()
                .create(ApiInterface::class.java)
    }


}