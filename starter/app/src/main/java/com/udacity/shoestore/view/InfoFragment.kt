package com.udacity.shoestore.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInfoBinding


class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding: FragmentInfoBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_info, container, false
        )
        binding.nextBtn.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_info2_to_shoeListFragment)

        }
        return binding.root
    }
}