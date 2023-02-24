package com.lastmile.buddhavaani.ui.membership

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lastmile.buddhavaani.databinding.FragmentMembershipBinding
import com.tbuonomo.creativeviewpagersample.NatureCreativePagerAdapter

class MembershipFragment: Fragment() {

    private var _binding: FragmentMembershipBinding? = null
    private val binding get() = _binding!!

    lateinit var membershipAdapter: MembershipAdapter
    private lateinit var viewModel: MembershipViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMembershipBinding.inflate(inflater, container, false)

        binding.creativeViewPagerView.setCreativeViewPagerAdapter(NatureCreativePagerAdapter(requireContext()))

        /*setupUI()
        binding.progress.visibility = View.VISIBLE
        binding.rvMovies.visibility = View.GONE
        viewModel = ViewModelProvider(this)[MembershipViewModel::class.java]
        viewModel.observeMovieLiveData()?.observe(requireActivity(), Observer { movieList ->
            binding.progress.visibility = View.GONE
            binding.rvMovies.visibility = View.VISIBLE
            membershipAdapter.setMovieList(movieList)
        })*/

        /*binding.imgDown.setOnClickListener {
            binding.imgUp.visibility = View.VISIBLE
            binding.imgDown.visibility = View.GONE
        }

        binding.imgUp.setOnClickListener {
            binding.imgUp.visibility = View.GONE
            binding.imgDown.visibility = View.VISIBLE
        }*/

        return binding.root
    }


    /*private fun setupUI() {
        membershipAdapter = MembershipAdapter()
        binding.rvMovies.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = membershipAdapter
        }
    }*/


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}