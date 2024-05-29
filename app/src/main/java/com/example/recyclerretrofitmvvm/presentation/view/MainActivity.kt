package com.example.recyclerretrofitmvvm.presentation.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerretrofitmvvm.R
import com.example.recyclerretrofitmvvm.databinding.ActivityMainBinding
import com.example.recyclerretrofitmvvm.presentation.view.adapters.RickandMortyAdapter
import com.example.recyclerretrofitmvvm.presentation.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    private lateinit var viewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adaptadorRickandMortyAdapter = RickandMortyAdapter()
        binding.rvRecycler.layoutManager = LinearLayoutManager(this)
        binding.rvRecycler.adapter = adaptadorRickandMortyAdapter
        viewModel.characterListLV.observe(this, Observer {
            adaptadorRickandMortyAdapter.charactersRickandMorty = it
        })


    }

    private fun setupViewModel(){
       viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        /* val transactionObserver = Observer<MutableList<Transaction>>{
             Log.i("transacciones",it.toString())*/
    }

}