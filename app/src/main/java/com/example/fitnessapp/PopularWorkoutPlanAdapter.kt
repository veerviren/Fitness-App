package com.example.fitnessapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

class PopularWorkoutPlanAdapter(private val plans: List<PopularWorkoutPlan>) :
    RecyclerView.Adapter<PopularWorkoutPlanAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(plan: PopularWorkoutPlan)
    }

    var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.popular_workout_plan_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val plan = plans[position]
        holder.planNameTextView.text = plan.name
        holder.planDescriptionTextView.text = plan.description
        holder.planRatingBar.rating = plan.rating.toFloat()
        holder.planImageView.setImageResource(plan.imageResId)
    }

    override fun getItemCount(): Int = plans.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val planNameTextView: TextView = view.findViewById(R.id.workout_plan_name)
        val planDescriptionTextView: TextView = view.findViewById(R.id.workout_plan_description)
        val planRatingBar: RatingBar = view.findViewById(R.id.workout_plan_rating)
        val planImageView: ImageView = view.findViewById(R.id.workout_plan_image)

        init {
            view.setOnClickListener {
                onItemClickListener?.onItemClick(plans[adapterPosition])

                when (planNameTextView.text) {
                    "Beginner's Full Body Workout" -> {
                        val exercise = listOf("Jumping Jacks", "Push Ups", "Crunches", "Leg Raises", "Squats")
                        val builder = AlertDialog.Builder(itemView.context)
                        builder.setTitle("${planNameTextView.text} Exercises")

                        val itemNames = exercise.map { it }
                        builder.setItems(itemNames.toTypedArray()) { _, index ->
                            Toast.makeText(itemView.context, "Great choice on ${itemNames[index]} make 5 sets", Toast.LENGTH_SHORT).show()
                        }
                        builder.setPositiveButton("Close", null)

                        val dialog = builder.create()
                        dialog.show()
                    }
                    "Upper Body Strength Training" -> {
                        val exercise = listOf("Jumping Jacks", "Push Ups", "Crunches", "Leg Raises", "Squats", "Lunges")
                        val builder = AlertDialog.Builder(itemView.context)
                        builder.setTitle("${planNameTextView.text} Exercises")

                        val itemNames = exercise.map { it }
                        builder.setItems(itemNames.toTypedArray()) { _, index ->
                            Toast.makeText(itemView.context, "Great choice on ${itemNames[index]} make 5 sets", Toast.LENGTH_SHORT).show()
                        }
                        builder.setPositiveButton("Close", null)

                        val dialog = builder.create()
                        dialog.show()
                    }
                    "Lower Body Tone Up" -> {
                        val exercise = listOf("Jumping Jacks", "Push Ups", "Crunches", "Leg Raises", "Squats", "Lunges", "Burpees")
                        val builder = AlertDialog.Builder(itemView.context)
                        builder.setTitle("${planNameTextView.text} Exercises")

                        val itemNames = exercise.map { it }
                        builder.setItems(itemNames.toTypedArray()) { _, index ->
                            Toast.makeText(itemView.context, "Great choice on ${itemNames[index]} make 5 sets", Toast.LENGTH_SHORT).show()
                        }
                        builder.setPositiveButton("Close", null)

                        val dialog = builder.create()
                        dialog.show()
                    }
                    "Upcoming Workout Plan" -> {
                        Toast.makeText(itemView.context, "This workout plan is coming soon", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

}


