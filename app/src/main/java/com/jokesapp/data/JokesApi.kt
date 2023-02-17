package com.jokesapp.data

import retrofit2.Response
import retrofit2.http.GET

interface JokesApi {
    @GET("api?format=json")
    suspend fun getJokes() : Response<Joke>
}