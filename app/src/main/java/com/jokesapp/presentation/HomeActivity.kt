package com.jokesapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.jokesapp.R
import com.jokesapp.data.Joke
import com.jokesapp.data.JokesApi
import com.jokesapp.data.db.JokeDatabase
import com.jokesapp.data.db.Jokes
import com.jokesapp.databinding.ActivityHomeBinding
import kotlinx.coroutines.*
import org.koin.android.ext.android.inject

class HomeActivity : AppCompatActivity() {
    lateinit var binding : ActivityHomeBinding
    private val jokesApi by inject<JokesApi>()
    private val db by inject<JokeDatabase>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@HomeActivity,R.layout.activity_home)
        binding.recyclerview.layoutManager = LinearLayoutManager(this@HomeActivity)
        val viewModel = ViewModelProvider(this).get(JokesViewModel::class.java)
        viewModel.getJokes(db,jokesApi,binding)
    }
}