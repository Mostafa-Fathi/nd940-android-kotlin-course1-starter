package com.udacity.shoestore.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.model.Shoe
import com.udacity.shoestore.viewmodel.MainViewModel

class ShoeDetailFragment : Fragment() {
    val images: List<String> = mutableListOf();
    var shoeName: String? = null
    var shoeSize: String? = null
    var companyName: String? = null
    var shoeDesc: String? = null
    private val shoeObj: Shoe= Shoe("",0.0,"","", images)
    private lateinit var binding: FragmentShoeDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )
        binding.shoeObj=shoeObj;

        val model=ViewModelProvider(requireActivity()).get(MainViewModel::class.java)


        binding.saveBtn.setOnClickListener {
            if (validate()) {
                model.addShoeTOList(shoeObj)
                it.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
            }
        }
        binding.cancelBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }
        return binding.root
    }

    private fun validate(): Boolean {

        if (shoeObj.company.isEmpty()) {
            binding.companyEditText.requestFocus()
            binding.companyEditText.error = getString(R.string.required)
            return false
        }
        if (shoeObj.name.isEmpty()) {
            binding.ShoeNameEditText.requestFocus()
            binding.ShoeNameEditText.error = getString(R.string.required)
            return false
        }
        if (shoeObj.size.toString().isEmpty()) {
            binding.sizeEditText.requestFocus()
            binding.sizeEditText.error = getString(R.string.required)
            return false
        }

        if (shoeObj.description.isEmpty()) {
            binding.descriptionEditText.requestFocus()
            binding.descriptionEditText.error = getString(R.string.required)
            return false
        }
        return true
    }
}