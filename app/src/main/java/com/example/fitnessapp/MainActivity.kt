package com.example.fitnessapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exercises = listOf(
            Exercise(
                "Age 5 - 12",
                R.drawable.children,
                "Calm your mind and body with this relaxing yoga routine. ",
                listOf("Exercise A", "Exercise B", "Exercise C"),
                "children"
            ),
            Exercise(
                "Age 13-20",
                R.drawable.young,
                "Regular exercise can help boost energy, maintain your independence, ",
                listOf("Exercise X", "Exercise Y", "Exercise Z"),
                "young"
            ),
            Exercise(
                "Age 21 - 50",
                R.drawable.parents,
                "Increase your flexibility and improve your balance with this set of exercises.",
                listOf("Exercise M", "Exercise N", "Exercise O"),
                "parents"
            ),
            Exercise(
                "Age above 50",
                R.drawable.excercise3,
                "Medication to manage symptoms like tremors, stiffness, and slow movement.",
                listOf("Exercise P", "Exercise Q", "Exercise R"),
                "above 50"
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
                R.drawable.fullbody
            ),
            PopularWorkoutPlan(
                "Upper Body Strength Training",
                "A strength training workout for the upper body",
                4.2,
                R.drawable.upperbody
            ),
            PopularWorkoutPlan(
                "Lower Body Tone Up",
                "A toning workout for the lower body",
                4.7,
                R.drawable.lowerbody
            ),
            PopularWorkoutPlan(
                "Upcoming Workout Plan",
                "stay tuned for more workout plans",
                4.7,
                R.drawable.upcomming
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

        homeImageView.setBackgroundColor(R.color.purple2)

        val nutritionImageView: ImageView = findViewById(R.id.nutrition)
        nutritionImageView.setOnClickListener {
            val intent = Intent(this, NutritionActivity::class.java)
            startActivity(intent)
        }

        val workoutImageView: ImageView = findViewById(R.id.random_workouts)
        workoutImageView.setOnClickListener {
            val intent = Intent(this, WorkoutActivity::class.java)
            startActivity(intent)
        }

        val profileImageView: ImageView = findViewById(R.id.profile)
        profileImageView.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}


