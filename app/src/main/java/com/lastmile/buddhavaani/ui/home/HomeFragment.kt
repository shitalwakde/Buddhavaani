package com.lastmile.buddhavaani.ui.home

import android.os.Bundle
import android.os.Handler
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.lastmile.buddhavaani.R
import com.lastmile.buddhavaani.databinding.FragmentHomeBinding
import com.lastmile.buddhavaani.ui.home.viewpager.AdjustingViewPager
import com.lastmile.buddhavaani.ui.home.viewpager.ImagePagerAdapter
import java.util.*


class HomeFragment: Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    lateinit var viewPager : AdjustingViewPager
    lateinit var imageAdapter: ImagePagerAdapter
    private val imagesList: List<Int> = listOf(
            R.drawable.buddha,
            R.drawable.buddha,
            R.drawable.buddha,
            R.drawable.buddha,
            R.drawable.buddha,
            R.drawable.buddha,
            R.drawable.buddha
    )
    var currentPage: Int = 0
    var timer: Timer? = null
    val DELAY_MS: Long = 500 //delay in milliseconds before task is to be executed

    val PERIOD_MS: Long = 3000 // time in milliseconds between successive task executions.


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.llEvents.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_eventsFragment) }
        binding.llFeed.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_feedFragment) }
        binding.llFundraisers.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_fundraisersFragment) }
        binding.llProject.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_projectsFragment) }
        binding.llMembership.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_membershipFragment) }
        binding.llVihar.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_viharFragment) }


        imageAdapter = ImagePagerAdapter(imagesList)
        binding.viewPager.adapter = imageAdapter

        val handler = Handler()
        val Update = Runnable {
            if (currentPage === imagesList.size - 1) {
                currentPage = 0
            }
            binding.viewPager.setCurrentItem(currentPage++, true)
        }

        timer = Timer() // This will create a new Thread

        timer!!.schedule(object : TimerTask() {
            // task to be scheduled
            override fun run() {
                handler.post(Update)
            }
        }, DELAY_MS, PERIOD_MS)

        return binding.root
    }


    /*override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/
}