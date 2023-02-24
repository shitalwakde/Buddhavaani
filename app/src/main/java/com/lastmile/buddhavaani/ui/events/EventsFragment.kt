package com.lastmile.buddhavaani.ui.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lastmile.buddhavaani.databinding.FragmentEventsBinding

class EventsFragment: Fragment() {

    private var _binding: FragmentEventsBinding? = null
    private val binding get() = _binding!!

    lateinit var eventsAdapter: EventsAdapter
    private lateinit var viewModel: EventsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEventsBinding.inflate(inflater, container, false)

        setupUI()
        binding.progress.visibility = View.VISIBLE
        binding.rvMovies.visibility = View.GONE
        viewModel = ViewModelProvider(this)[EventsViewModel::class.java]
        viewModel.observeMovieLiveData()?.observe(requireActivity(), Observer { movieList ->
            binding.progress.visibility = View.GONE
            binding.rvMovies.visibility = View.VISIBLE
            eventsAdapter.setMovieList(movieList)
        })



        return binding.root
    }


    private fun setupUI() {
        eventsAdapter = EventsAdapter()
        binding.rvMovies.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = eventsAdapter
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}