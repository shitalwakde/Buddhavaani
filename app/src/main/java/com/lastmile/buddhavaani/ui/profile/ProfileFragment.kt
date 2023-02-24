package com.lastmile.buddhavaani.ui.profile

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.lastmile.buddhavaani.R
import com.lastmile.buddhavaani.databinding.FragmentProfileBinding
import com.lastmile.buddhavaani.ui.projects.ProjectsViewModel
import com.lastmile.buddhavaani.ui.signup.SignupActivity

class ProfileFragment: Fragment() {

    private var _binding:FragmentProfileBinding? = null
    private val binding get() = _binding!!

    lateinit var profileAdapter: ProfileAdapter
    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        setupUI()
        binding.progress.visibility = View.VISIBLE
        binding.rvMyPosts.visibility = View.GONE
        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        viewModel.observeMovieLiveData()?.observe(requireActivity(), Observer { movieList ->
            binding.progress.visibility = View.GONE
            binding.rvMyPosts.visibility = View.VISIBLE
            profileAdapter.setMovieList(movieList)
        })


        binding.btnEditProfile.setOnClickListener {
            startActivity(Intent(activity, SignupActivity::class.java))
        }

        setHasOptionsMenu(true)
        return binding.root
    }


    private fun setupUI() {
        profileAdapter = ProfileAdapter()
        binding.rvMyPosts.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = profileAdapter
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_logout){
            logoutUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun logoutUser(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
//            mUserViewModel.deleteUser(args.currentUser)
//            Toast.makeText(requireContext(), "Successfully removed ${args.currentUser.firstName}", Toast.LENGTH_SHORT).show()
            Toast.makeText(requireContext(), "Logout Successfully...", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_profileFragment_to_homeFragment)
        }
        builder.setNegativeButton("No") { _, _ -> }
//        builder.setTitle("Delete ${args.currentUser.firstName} ?")
        builder.setTitle("Do you really want to logout ?")
        builder.create().show()
    }


}