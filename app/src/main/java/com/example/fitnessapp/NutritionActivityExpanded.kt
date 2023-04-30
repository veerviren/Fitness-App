package com.example.fitnessapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NutritionActivityExpanded : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nutrition_expanded)

        // Get background color and set background
        val backgroundColor = intent.getIntExtra("background_color", R.color.white)
        findViewById<ConstraintLayout>(R.id.card_expand_layout).setBackgroundColor(ContextCompat.getColor(this, backgroundColor))

        // Get list of items and populate RecyclerView
        val items = intent.getStringArrayListExtra("items_list") ?: emptyList<String>()
        val recyclerView = findViewById<RecyclerView>(R.id.card_expand_items)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CardExpandAdapter(items)

        // Set up card expand title click listener to toggle card expand visibility
        val cardExpandedTitle = findViewById<TextView>(R.id.card_expand_title)
        val title = intent.getStringExtra("title")
        cardExpandedTitle.text = title
    }
}
