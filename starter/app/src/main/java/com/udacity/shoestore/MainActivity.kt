package com.udacity.shoestore

import android.app.PendingIntent.getActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import timber.log.Timber
import androidx.lifecycle.ViewModelProviders
import com.udacity.shoestore.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.plant(Timber.DebugTree())
        ViewModelProvider(this).get(MainViewModel::class.java)
    }


}
