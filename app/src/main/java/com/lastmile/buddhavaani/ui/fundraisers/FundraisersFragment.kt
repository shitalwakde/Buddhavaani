package com.lastmile.buddhavaani.ui.fundraisers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lastmile.buddhavaani.databinding.FragmentFundraisersBinding


class FundraisersFragment: Fragment() {

    private var _binding: FragmentFundraisersBinding? = null
    private val binding get() = _binding!!

    lateinit var fundsraisersAdapter: FundsraisersAdapter
    private lateinit var viewModel: FundraisersViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFundraisersBinding.inflate(inflater, container, false)


        setupUI()

        binding.progress.visibility = View.VISIBLE
        binding.rvMovies.visibility = View.GONE
        viewModel = ViewModelProvider(this)[FundraisersViewModel::class.java]
        viewModel.observeMovieLiveData()?.observe(requireActivity(), Observer { movieList ->
            binding.progress.visibility = View.GONE
            binding.rvMovies.visibility = View.VISIBLE
            fundsraisersAdapter.setMovieList(movieList)
        })

        return binding.root
    }


    private fun setupUI() {
        fundsraisersAdapter = FundsraisersAdapter()
        binding.rvMovies.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = fundsraisersAdapter
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}