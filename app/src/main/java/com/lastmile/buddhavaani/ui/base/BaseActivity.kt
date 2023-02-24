package com.lastmile.buddhavaani.ui.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lastmile.buddhavaani.ui.movie.MovieViewModel
import com.lastmile.buddhavaani.databinding.ActivityBaseBinding
import com.lastmile.buddhavaani.ui.home.NewsAdapter

class BaseActivity : AppCompatActivity() {

    private lateinit var binding:ActivityBaseBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}