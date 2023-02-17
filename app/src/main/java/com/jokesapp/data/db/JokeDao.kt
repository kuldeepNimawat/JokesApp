package com.jokesapp.data.db

import androidx.room.*
import com.jokesapp.data.Joke

@Dao
interface JokeDao {
    @Transaction
    @Query("SELECT * FROM jokes")
    fun getAll(): List<Jokes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertJokes(jokes: Jokes)

    @Delete
    suspend fun delete(jokes : Jokes)
}