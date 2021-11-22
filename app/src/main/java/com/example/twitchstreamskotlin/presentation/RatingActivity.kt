package com.example.twitchstreamskotlin.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.twitchstreamskotlin.R
import com.example.twitchstreamskotlin.databinding.ActivityRatingBinding

class RatingActivity : AppCompatActivity() {

    private val binding: ActivityRatingBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating)
        initFeedbackButton()
        initBackButton()

    }

    private fun initFeedbackButton() {
        binding.sendFeedbackBt.setOnClickListener{
            var intent:Intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(applicationContext, "Ваш рейтинг отправлен", Toast.LENGTH_LONG).show()
        }
    }

    private fun initBackButton() {
        binding.backBt.setOnClickListener{
            var intent:Intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }


}


