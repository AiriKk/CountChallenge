package com.example.countchallenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countchallenge.databinding.ActivityTitleBinding

class TitleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTitleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTitleBinding.inflate(layoutInflater).apply{
            setContentView(this.root)
        }
         val mainIntent: Intent = Intent(this,MainActivity::class.java)

        //UPボタンが押された時
        binding.main.setOnClickListener{
            startActivity(mainIntent)
        }
    }
}
