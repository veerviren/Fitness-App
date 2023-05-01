package com.example.fitnessapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

class ExerciseAdapter(private val exerciseList: List<Exercise>) :
    RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>() {
    inner class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val exerciseName: TextView = itemView.findViewById(R.id.exercise_name)
        val exerciseDescription: TextView = itemView.findViewById(R.id.exercise_description)
        val exerciseImage: ImageView = itemView.findViewById(R.id.exercise_image)

        init {
            itemView.setOnClickListener {
                val currentExercise = exerciseList[adapterPosition]
                val ageGroup = currentExercise.AgeGroup
                val exerciseName = currentExercise.name
                val context = itemView.context

                val builder = AlertDialog.Builder(context)
                when (ageGroup) {
                    "children" -> {
                        val exercise = listOf("Squats", "Lunges", "Plank", "High Knees", "Burpees")
                        builder.setTitle("$exerciseName Exercises")

                        val itemNames = exercise.map { it }
                        builder.setItems(itemNames.toTypedArray()) { _, index ->
                            Toast.makeText(context, "Great choose on ${itemNames[index]} make 5 sets", Toast.LENGTH_SHORT).show()
                        }
                        builder.setPositiveButton("Close", null)

                        val dialog = builder.create()
                        dialog.show()
                    }
                    "young" -> {
                        val exercise = listOf("Jumping Jacks", "Push Ups", "Crunches", "Leg Raises")
                        builder.setTitle("$exerciseName Exercises")

                        val itemNames = exercise.map { it }
                        builder.setItems(itemNames.toTypedArray()) { _, index ->
                            Toast.makeText(context, "Great choose on ${itemNames[index]} make 5 sets", Toast.LENGTH_SHORT).show()
                        }
                        builder.setPositiveButton("Close", null)

                        val dialog = builder.create()
                        dialog.show()
                    }
                    "parents" -> {
                        val exercise = listOf("Jumping Jacks", "Push Ups", "Crunches", "Leg Raises", "Squats")
                        builder.setTitle("$exerciseName Exercises")

                        val itemNames = exercise.map { it }
                        builder.setItems(itemNames.toTypedArray()) { _, index ->
                            Toast.makeText(context, "Great choose on ${itemNames[index]} make 5 sets", Toast.LENGTH_SHORT).show()
                        }
                        builder.setPositiveButton("Close", null)

                        val dialog = builder.create()
                        dialog.show()
                    }
                    else -> {
                        val exercise = listOf("Lunges", "Plank", "High Knees", "Burpees", "Mountain Climbers")
                        builder.setTitle("$exerciseName Exercises")

                        val itemNames = exercise.map { it }
                        builder.setItems(itemNames.toTypedArray()) { _, index ->
                            Toast.makeText(context, "Great choose on ${itemNames[index]} make 5 sets", Toast.LENGTH_SHORT).show()
                        }
                        builder.setPositiveButton("Close", null)

                        val dialog = builder.create()
                        dialog.show()
                    }
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.exercise_card_view, parent, false)
        return ExerciseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        val currentExercise = exerciseList[position]
        holder.exerciseName.text = currentExercise.name
        holder.exerciseDescription.text = currentExercise.description
        holder.exerciseImage.setImageResource(currentExercise.image)
    }

    override fun getItemCount() = exerciseList.size
}


