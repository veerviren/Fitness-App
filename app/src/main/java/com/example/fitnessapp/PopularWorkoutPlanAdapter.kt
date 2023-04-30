package com.example.fitnessapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PopularWorkoutPlanAdapter(private val plans: List<PopularWorkoutPlan>) :
    RecyclerView.Adapter<PopularWorkoutPlanAdapter.ViewHolder>() {

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
        val planDescriptionTextView: TextView =
            view.findViewById(R.id.workout_plan_description)
        val planRatingBar: RatingBar =
            view.findViewById(R.id.workout_plan_rating)
        val planImageView: ImageView = view.findViewById(R.id.workout_plan_image)
    }
}

