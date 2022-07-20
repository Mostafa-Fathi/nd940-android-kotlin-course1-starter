package com.udacity.shoestore.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.model.Shoe

class MainViewModel : ViewModel(){
    private val _shoeList: MutableLiveData<List<Shoe>> = MutableLiveData()
    private var list=mutableListOf<Shoe>()
    val shoeList: LiveData<List<Shoe>> =_shoeList

    @SuppressLint("LogNotTimber")
    fun addShoeTOList(shoe: Shoe){
        list.add(shoe)
        _shoeList.postValue(list)
        Log.e("adding",list.size.toString())
    }
}