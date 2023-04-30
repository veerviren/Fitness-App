package com.example.fitnessapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.DrawableRes

class WorkoutActivity : AppCompatActivity() {
    private lateinit var exerciseImageView: ImageView
    private lateinit var previousButton: Button
    private lateinit var nextButton: Button
    private lateinit var timerTextView: TextView
    private lateinit var exerciseNameTextView: TextView
    private lateinit var startStopButton: Button
    private var isTimerRunning = false
    private var countDownTimer: CountDownTimer? = null

    private var currentExerciseIndex = 0
    private val exerciseList = listOf(
        Exercise("Push-up", R.drawable.excercise1),
        Exercise("Squat", R.drawable.excercise2),
        Exercise("Lunge", R.drawable.excercise3)
    )

    private var timeLeftInMillis: Long = 60000 // 60 seconds

    @SuppressLint("MissingInflatedId", "ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)

        exerciseImageView = findViewById(R.id.workout_gif)
        previousButton = findViewById(R.id.workout_previous)
        nextButton = findViewById(R.id.workout_next)
        startStopButton = findViewById(R.id.workout_start_stop)
        timerTextView = findViewById(R.id.workout_timer)
        exerciseNameTextView = findViewById(R.id.workout_title)


        // Set the first exercise as the current exercise
        setExercise(exerciseList[currentExerciseIndex])

        // Set up previous button click listener
        previousButton.setOnClickListener {
            if (currentExerciseIndex > 0) {
                currentExerciseIndex--
                setExercise(exerciseList[currentExerciseIndex])
            }else{
                Toast.makeText(this, "No previous exercise", Toast.LENGTH_SHORT).show()
            }
        }

        // Set up next button click listener
        nextButton.setOnClickListener {
            if (currentExerciseIndex < exerciseList.size - 1) {
                currentExerciseIndex++
                setExercise(exerciseList[currentExerciseIndex])
            }
            else{
                Toast.makeText(this, "No next exercise", Toast.LENGTH_SHORT).show()
            }
        }

        startStopButton.setOnClickListener {
            if (isTimerRunning) {
                // Pause timer
                isTimerRunning = false
                countDownTimer?.cancel()
                startStopButton.text = "Start"
            } else {
                // Start timer
                isTimerRunning = true
                startStopButton.text = "Pause"
                countDownTimer = object : CountDownTimer(timeLeftInMillis, 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        timeLeftInMillis = millisUntilFinished
                        updateTimer()
                    }

                    override fun onFinish() {
                        isTimerRunning = false
                        startStopButton.text = "Start"
                        if (currentExerciseIndex < exerciseList.size - 1) {
                            currentExerciseIndex++
                            setExercise(exerciseList[currentExerciseIndex])
                            timeLeftInMillis = 60000
                            updateTimer()
                        } else {
                            // Workout finished
                            timeLeftInMillis = 0
                            updateTimer()
                            Toast.makeText(applicationContext, "Workout finished", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }.start()
            }
        }

        //Footer navigation
        val homeImageView: ImageView = findViewById(R.id.home)
        val workoutImageView: ImageView = findViewById(R.id.random_workouts)
        val nutritionImageView: ImageView = findViewById(R.id.nutrition)
        val profileImageView: ImageView = findViewById(R.id.profile)

        workoutImageView.setBackgroundColor(R.color.purple2)

        homeImageView.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        nutritionImageView.setOnClickListener {
            val intent = Intent(this, NutritionActivity::class.java)
            startActivity(intent)
        }

        workoutImageView.setOnClickListener {
            Toast.makeText(this, "You are already on the Workout page", Toast.LENGTH_SHORT).show()
        }

        profileImageView.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setExercise(exercise: Exercise) {
        exerciseImageView.setImageResource(exercise.imageResource)
        exerciseNameTextView.text = exercise.name
        timeLeftInMillis = 60000 // 60 seconds
        countDownTimer?.cancel()
        updateTimer()
    }

    @SuppressLint("SetTextI18n")
    private fun updateTimer() {
        val seconds = timeLeftInMillis / 1000
        timerTextView.text = String.format("%02d", seconds / 60) + ":" + String.format("%02d", seconds % 60)
    }

    data class Exercise(val name: String, @DrawableRes val imageResource: Int)
}
