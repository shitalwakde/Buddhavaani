package com.lastmile.buddhavaani.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lastmile.buddhavaani.model.User


@Dao
interface DAOAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertData(user: User)

    @Query("SELECT * FROM User WHERE Username =:username")
    fun getUserDetails(username: String?) : LiveData<User>

}