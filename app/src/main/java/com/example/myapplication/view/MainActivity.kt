package com.example.myapplication.view

import Device.isconnected
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import viewmodel.ApodViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ApodViewModel
    private lateinit var binding: ActivityMainBinding
    val TAG =MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel= ViewModelProviders.of(this).get(ApodViewModel::class.java)
       if( isconnected()) {
           observeViewModel()
           viewModel.refresh()
       }
        else{
           list_error.visibility = View.VISIBLE
           Toast.makeText(this,"Connect to internet",Toast.LENGTH_LONG).show()
       }


    }

    private fun observeViewModel() {
        viewModel.apod.observe(this, Observer {
            it?.let {
                Toast.makeText(this,"Fetched details"+it,Toast.LENGTH_LONG).show()
                Glide.with(this).load(it.url).into(imageView);

            }
        })

        viewModel.loadError.observe(this, Observer {
            it?.let {
                list_error.visibility = if (it) View.VISIBLE else View.GONE
            }

        })

        viewModel.loading.observe(this, Observer {
            it?.let {
                loadingIndicator.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    list_error.visibility = View.GONE

                }
            }
        })
    }

}