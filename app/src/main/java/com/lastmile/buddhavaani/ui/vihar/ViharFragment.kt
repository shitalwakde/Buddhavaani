package com.lastmile.buddhavaani.ui.vihar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lastmile.buddhavaani.databinding.FragmentViharBinding

class ViharFragment: Fragment() {

    private var _binding: FragmentViharBinding? = null
    private val binding get() = _binding!!

    lateinit var viharAdapter: ViharAdapter
    private lateinit var viewModel: ViharViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentViharBinding.inflate(inflater, container, false)

        setupUI()
        binding.progress.visibility = View.VISIBLE
        binding.rvMovies.visibility = View.GONE
        viewModel = ViewModelProvider(this)[ViharViewModel::class.java]
        viewModel.observeMovieLiveData()?.observe(requireActivity(), Observer { movieList ->
            binding.progress.visibility = View.GONE
            binding.rvMovies.visibility = View.VISIBLE
            viharAdapter.setMovieList(movieList)
        })

        return binding.root
    }


    private fun setupUI() {
        viharAdapter = ViharAdapter()
        binding.rvMovies.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = viharAdapter
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}