package com.example.fitnessapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView

class NutritionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nutrition)


        val card1 = findViewById<CardView>(R.id.cardview1)
        val card2 = findViewById<CardView>(R.id.cardview2)
        val card3 = findViewById<CardView>(R.id.cardview3)

        card1.setOnClickListener {
            val intent = Intent(this, NutritionActivityExpanded::class.java)
            intent.putExtra("background_color", R.color.pink) // set background color
            val items = listOf("Item 1", "Item 2", "Item 3") // create a list of items
            val card1Title = findViewById<TextView>(R.id.cardview1_title)
            intent.putStringArrayListExtra("items_list", ArrayList(items))
            intent.putExtra("title", card1Title.text.toString()) // add the title of the clicked card to the intent
            startActivity(intent)
        }

        card2.setOnClickListener {
            val intent = Intent(this, NutritionActivityExpanded::class.java)
            intent.putExtra("background_color", R.color.green) // set background color
            val items = listOf("Item 4", "Item 5", "Item 6") // create a list of items
            val card1Title = findViewById<TextView>(R.id.cardview2_title)
            intent.putStringArrayListExtra("items_list", ArrayList(items)) // add the list of items to the intent
            intent.putExtra("title", card1Title.text.toString())
            startActivity(intent)
        }

        card3.setOnClickListener {
            val intent = Intent(this, NutritionActivityExpanded::class.java)
            intent.putExtra("background_color", R.color.red) // set background color
            val items = listOf("Item 7", "Item 8", "Item 9") // create a list of items
            val card1Title = findViewById<TextView>(R.id.cardview3_title)
            intent.putStringArrayListExtra("items_list", ArrayList(items)) // add the list of items to the intent
            intent.putExtra("title", card1Title.text.toString())
            startActivity(intent)
        }

        // Footer navigation
        val homeImageView: ImageView = findViewById(R.id.home)
        val workoutImageView: ImageView = findViewById(R.id.random_workouts)
        val nutritionImageView: ImageView = findViewById(R.id.nutrition)
        val profileImageView: ImageView = findViewById(R.id.profile)

        homeImageView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        nutritionImageView.setOnClickListener {
            Toast.makeText(this, "You are already on the Nutrition page", Toast.LENGTH_SHORT).show()
        }

        workoutImageView.setOnClickListener {
            val intent = Intent(this, WorkoutActivity::class.java)
            startActivity(intent)
        }

    }
}