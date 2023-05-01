package com.example.fitnessapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class SplashScreenActivity : AppCompatActivity() {

    private val colorList = arrayOf(
        R.color.purple1, R.color.green, R.color.red,
        R.color.purple2, R.color.green
    )

    private var colorIndex = 0

    private val colorHandler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        startColorChange()

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 3000)
    }

    private fun startColorChange() {
        colorHandler.post(object : Runnable {
            override fun run() {
                val color = ContextCompat.getColor(this@SplashScreenActivity, colorList[colorIndex])
                findViewById<View>(android.R.id.content).setBackgroundColor(color)

                colorIndex = (colorIndex + 1) % colorList.size

                colorHandler.postDelayed(this, 1000)
            }
        })
    }

    private fun stopColorChange() {
        colorHandler.removeCallbacksAndMessages(null)
    }

    override fun onDestroy() {
        super.onDestroy()
        stopColorChange()
    }
}
