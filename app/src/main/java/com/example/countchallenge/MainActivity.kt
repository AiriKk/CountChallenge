package com.example.countchallenge

import android.graphics.Color
import android.graphics.Color.RED
import android.hardware.camera2.params.RggbChannelVector.RED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countchallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply{
            setContentView(this.root)
        }
        var number: Int = 0
        binding.numberTextview.text = number.toString()

        binding.upButton.setOnClickListener{
            number += 1
            binding.numberTextview.text = number.toString()

            when(number%2){
                0 ->{binding.numberTextview.setTextColor(Color.RED)}
                1 ->{binding.numberTextview.setTextColor(Color.BLUE)}
            }
        }
    }
}
