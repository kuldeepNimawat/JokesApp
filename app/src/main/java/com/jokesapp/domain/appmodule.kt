package com.jokesapp.domain

import android.content.Context
import androidx.room.Room
import com.jokesapp.data.JokesApi
import com.jokesapp.data.db.JokeDao
import com.jokesapp.data.db.JokeDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appmodule = module {
    single {
        Retrofit.Builder().baseUrl("https://geek-jokes.sameerkumar.website")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JokesApi::class.java)
    }

    single {
        Room.databaseBuilder(
            androidApplication(),
            JokeDatabase::class.java,
            "jokes_db.db"
        ).build()
    }
}