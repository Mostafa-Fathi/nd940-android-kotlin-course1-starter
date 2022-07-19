package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {
    val images: List<String> = mutableListOf();
    private val ShoeObj: Shoe= Shoe("",0.0,"","", images)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )
        binding.shoeObj=ShoeObj;
        return binding.root
    }
}