package com.jokesapp.data.db

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jokesapp.data.Joke

@Entity
data class Jokes(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    @ColumnInfo(name = "joke") val joke : String
)
