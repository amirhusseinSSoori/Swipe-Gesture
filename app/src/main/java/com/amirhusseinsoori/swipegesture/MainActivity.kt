package com.amirhusseinsoori.swipegesture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amirhusseinsoori.swipegesture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var swipeListener: SwipeListener
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        swipeListener = SwipeListener(binding.mainContainer, binding.txtGesture, applicationContext)


    }
}