package com.example.countchallenge

import android.graphics.Color
import android.graphics.Color.RED
import android.hardware.camera2.params.RggbChannelVector.RED
import android.media.AudioAttributes
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.countchallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var mSoundPool: SoundPool
    private var soundID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply{
            setContentView(this.root)
        }
        //変数を宣言してTextViewに表示
        var number: Int = 0
        binding.numberTextview.text = number.toString()

        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .build()

        //オーディオの設定
        mSoundPool = SoundPool.Builder()
            .setAudioAttributes(audioAttributes)
            .setMaxStreams(1)
            .build()
        soundID = mSoundPool.load(this, R.raw.sound, 1)

        //UPボタンが押された時
        binding.upButton.setOnClickListener{
            number += 1
            binding.numberTextview.text = number.toString()

            //偶数と奇数で文字色を変える
            when(number%2){
                0 ->{binding.numberTextview.setTextColor(Color.RED)}
                1 ->{binding.numberTextview.setTextColor(Color.BLUE)
                    mSoundPool.play(soundID, 1.0f, 1.0f, 0, 0, 1.0f)}
            }
        }
    }
}
