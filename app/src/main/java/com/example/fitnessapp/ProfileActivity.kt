package com.example.fitnessapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class ProfileActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Footer
        val homeImageView: ImageView = findViewById(R.id.home)
        val workoutImageView: ImageView = findViewById(R.id.random_workouts)
        val nutritionImageView: ImageView = findViewById(R.id.nutrition)
        val profileImageView: ImageView = findViewById(R.id.profile)

        profileImageView.setBackgroundColor(R.color.purple2)

        homeImageView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        workoutImageView.setOnClickListener {
            val intent = Intent(this, WorkoutActivity::class.java)
            startActivity(intent)
        }

        nutritionImageView.setOnClickListener {
            val intent = Intent(this, NutritionActivity::class.java)
            startActivity(intent)
        }

        profileImageView.setOnClickListener {
            Toast.makeText(this, "You are already on the profile page!", Toast.LENGTH_SHORT).show()
        }
    }
}