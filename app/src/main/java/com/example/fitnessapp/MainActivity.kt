package com.example.fitnessapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exercises = listOf(
            Exercise(
                "Age group 1",
                R.drawable.excercise1,
                "Description for Exercise 1",
                listOf("Exercise A", "Exercise B", "Exercise C")
            ),
            Exercise(
                "Age group 2",
                R.drawable.excercise2,
                "Description for Exercise 2",
                listOf("Exercise X", "Exercise Y", "Exercise Z")
            ),
            Exercise(
                "Age group 3",
                R.drawable.excercise3,
                "Description for Exercise 3",
                listOf("Exercise M", "Exercise N", "Exercise O")
            ),
            Exercise(
                "Age group 4",
                R.drawable.excercise4,
                "Description for Exercise 4",
                listOf("Exercise P", "Exercise Q", "Exercise R")
            )
        )

        val exerciseAdapter = ExerciseAdapter(exercises)
        val exerciseRecyclerView: RecyclerView = findViewById(R.id.exercise_recycler_view)
        exerciseRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        exerciseRecyclerView.adapter = exerciseAdapter

        val popular_workout_plans = listOf(
            PopularWorkoutPlan(
                "Beginner's Full Body Workout",
                "A full body workout for beginners",
                4.5,
                R.drawable.excercise1
            ),
            PopularWorkoutPlan(
                "Upper Body Strength Training",
                "A strength training workout for the upper body",
                4.2,
                R.drawable.excercise2
            ),
            PopularWorkoutPlan(
                "Lower Body Tone Up",
                "A toning workout for the lower body",
                4.7,
                R.drawable.excercise3
            ),
            PopularWorkoutPlan(
                "Lower Body Tone Up",
                "A toning workout for the lower body",
                4.7,
                R.drawable.excercise4
            ),
        )

        val popularWorkoutPlanAdapter = PopularWorkoutPlanAdapter(popular_workout_plans)
        val popularWorkoutPlanRecyclerView: RecyclerView = findViewById(R.id.popular_workout_recycler_view)
        popularWorkoutPlanRecyclerView.layoutManager = LinearLayoutManager(this)
        popularWorkoutPlanRecyclerView.adapter = popularWorkoutPlanAdapter

        //Footer logic
        val homeImageView : ImageView = findViewById(R.id.home)
        homeImageView.setOnClickListener {
            Toast.makeText(this, "You are already on the home page", Toast.LENGTH_SHORT).show()
        }

        val nutritionImageView: ImageView = findViewById(R.id.nutrition)
        nutritionImageView.setOnClickListener {
            val intent = Intent(this, NutritionActivity::class.java)
            startActivity(intent)
        }

    }
}


