package com.jokesapp.presentation

import androidx.lifecycle.ViewModel
import com.jokesapp.data.JokesApi
import com.jokesapp.data.db.JokeDatabase
import com.jokesapp.data.db.Jokes
import com.jokesapp.databinding.ActivityHomeBinding
import kotlinx.coroutines.*

class JokesViewModel: ViewModel(){
    fun getJokes( db : JokeDatabase,
                  jokesApi : JokesApi,
                   binding : ActivityHomeBinding) {
        //val dao = JokeDatabase.getDatabaseInstance(this).jokeDao()
        val dao = db.jokeDao()
        //val jokesApi = RetrofitHelper.getInstance().create(JokesApi::class.java)
        GlobalScope.launch(Dispatchers.IO) {
            while (true) {
                val joke = jokesApi.getJokes()
                if (joke != null){
                    //--delete more than 10 items---
                    dao.getAll().let {
                        if(it.size == 10){
                            dao.delete(it.get(0))
                        }
                    }
                    //---insert and display view-----
                    joke.body()?.let {
                        dao.insertJokes(Jokes(0,it.joke))
                        //println(it.joke)
                        dao.getAll().let {
                            withContext(Dispatchers.Main){
                                val adapter = JokesAdapter(it)
                                binding.recyclerview.adapter = adapter
                            }
                        }
                    }
                }
                delay(60_000)
            }
        }
    }

}