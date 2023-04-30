package com.example.fitnessapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExerciseAdapter(private val exerciseList: List<Exercise>) :
    RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(exercise: Exercise)
    }

    var onItemClickListener: OnItemClickListener? = null

    inner class ExerciseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val exerciseName: TextView = itemView.findViewById(R.id.exercise_name)
        val exerciseDescription: TextView = itemView.findViewById(R.id.exercise_description)
        val exerciseImage: ImageView = itemView.findViewById(R.id.exercise_image)

        init {
            itemView.setOnClickListener {
                onItemClickListener?.onItemClick(exerciseList[adapterPosition])
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


