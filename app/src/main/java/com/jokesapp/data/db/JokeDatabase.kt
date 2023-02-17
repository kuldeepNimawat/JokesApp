package com.jokesapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Jokes ::class], version = 1, exportSchema = false)
abstract class JokeDatabase : RoomDatabase(){
    abstract fun jokeDao() : JokeDao
}
