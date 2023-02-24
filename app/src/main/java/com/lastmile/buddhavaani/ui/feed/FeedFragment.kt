package com.lastmile.buddhavaani.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lastmile.buddhavaani.databinding.FragmentFeedBinding
import com.lastmile.buddhavaani.ui.events.EventsViewModel

class FeedFragment: Fragment() {

    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!

    lateinit var feedAdapter: FeedAdapter
    private lateinit var viewModel: FeedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFeedBinding.inflate(inflater, container, false)

        setupUI()
        binding.progress.visibility = View.VISIBLE
        binding.rvMovies.visibility = View.GONE
        viewModel = ViewModelProvider(this)[FeedViewModel::class.java]
        viewModel.observeMovieLiveData()?.observe(requireActivity(), Observer { movieList ->
            binding.progress.visibility = View.GONE
            binding.rvMovies.visibility = View.VISIBLE
            feedAdapter.setMovieList(movieList)
        })

        return binding.root
    }


    private fun setupUI() {
        feedAdapter = FeedAdapter()
        binding.rvMovies.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = feedAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}