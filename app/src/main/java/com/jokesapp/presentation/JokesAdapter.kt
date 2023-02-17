package com.jokesapp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jokesapp.R
import com.jokesapp.data.db.Jokes
import com.jokesapp.databinding.CardViewBinding

class JokesAdapter(private val mList: List<Jokes>) : RecyclerView.Adapter<JokesAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(mList[position]){
                binding.textView.text = this.joke
            }
        }
    }
    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding text
    class ViewHolder(val binding: CardViewBinding) : RecyclerView.ViewHolder(binding.root)
}