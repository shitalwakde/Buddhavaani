package com.lastmile.buddhavaani.ui.signup

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lastmile.buddhavaani.data.RetrofitClient
import com.lastmile.buddhavaani.model.Movies
import com.lastmile.buddhavaani.model.User
import com.lastmile.buddhavaani.room.UserDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object SignupRepository {
    private val userResult = MutableLiveData<Movies>()

    var userDatabase: UserDatabase? = null
    var user: LiveData<User>? = null

    fun initializeDB(context: Context) : UserDatabase {
        return UserDatabase.getDatabaseClient(context)
    }

    fun inserData(context: Context, username: String, password: String){
        userDatabase = initializeDB(context)

        CoroutineScope(IO).launch {
            val userDetails = User(username, password)
            userDatabase!!.Dao().InsertData(userDetails)
        }
    }

    fun getUserDetails(context: Context, username: String) : LiveData<User>? {

        userDatabase = initializeDB(context)

        user = userDatabase!!.Dao().getUserDetails(username)

        return user
    }


    fun getUserData() : MutableLiveData<Movies>{
        RetrofitClient.apiInterface.getUser().enqueue(object :
        Callback<Movies>{
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                if(response.body() != null){
                    userResult.value = response.body()!!
                } else {
                    return
                }
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.e("TAG", t.message.toString())
            }

        })
        return userResult
    }

}