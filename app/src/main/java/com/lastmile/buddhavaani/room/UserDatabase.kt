package com.lastmile.buddhavaani.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lastmile.buddhavaani.model.User

@Database(entities = arrayOf(User::class), version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun Dao(): DAOAccess

    companion object{

        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDatabaseClient(context: Context) : UserDatabase {
            if(INSTANCE != null) return INSTANCE!!

            synchronized(this){
                INSTANCE = Room
                    .databaseBuilder(context, UserDatabase::class.java, "USER_DATABASE")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE!!
        }

    }


}