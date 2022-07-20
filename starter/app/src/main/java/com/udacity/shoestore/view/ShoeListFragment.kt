package com.udacity.shoestore.view

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.model.Shoe
import com.udacity.shoestore.viewmodel.MainViewModel
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController


class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         binding = FragmentShoeListBinding.inflate(inflater, container, false)
        binding.floatingActionButton.setOnClickListener {
           it.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }
        (activity as AppCompatActivity).toolbar.visibility=View.VISIBLE
        (activity as AppCompatActivity).toolbar.title = getString(R.string.ShoeList)
        (activity as AppCompatActivity).toolbar.inflateMenu(R.menu.logout_menu);
        (activity as AppCompatActivity).toolbar.setOnMenuItemClickListener { menuItem ->
            val itemId: Int = menuItem.itemId
            if (itemId == R.id.logout_item) {
                showAlert()
                return@setOnMenuItemClickListener true
            } else return@setOnMenuItemClickListener false
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        model.shoeList.observe(viewLifecycleOwner, Observer { list ->
            addView(list)
        })
    }

    private fun showAlert(){
        val alertDialogBuilder =AlertDialog.Builder(requireActivity())
        alertDialogBuilder.setTitle(getString(R.string.overlay_title))
            .setMessage(getString(R.string.overlay_message))
            .setPositiveButton(getString(R.string.overlay_postive_button)) { dialog: DialogInterface, _: Int ->
                (activity as AppCompatActivity).toolbar.visibility=View.INVISIBLE
                findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
                dialog.dismiss()
            }.setNegativeButton(
                getString(R.string.overlay_negative_button)
            ) { dialog: DialogInterface, _: Int ->
                dialog.dismiss()
            }.show()
    }

    private fun addView(list: List<Shoe>){
        for(shoe in list ){
            val shoeCardView: View =
                LayoutInflater.from(requireContext()).inflate(R.layout.shoe_card_view, binding.linearLayout1, false)
            val tvName = shoeCardView.findViewById<TextView>(R.id.tvShoeName)
            val tvShoeCompany = shoeCardView.findViewById<TextView>(R.id.tvShoeCompany)
            val tvShoeDesc = shoeCardView.findViewById<TextView>(R.id.tvShoeDesc)
            val tvShoeSize = shoeCardView.findViewById<TextView>(R.id.tvShoeSize)

            tvName.text=shoe.name
            tvShoeCompany.text=shoe.company
            tvShoeDesc.text=shoe.description
            tvShoeSize.text=shoe.size.toString()

            binding.linearLayout1.addView(shoeCardView)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
       // inflater.inflate(R.menu.logout_menu, menu)
    }

}