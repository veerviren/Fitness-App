package com.example.fitnessapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView

class NutritionActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nutrition)


        val card1 = findViewById<CardView>(R.id.cardview1)
        val card2 = findViewById<CardView>(R.id.cardview2)
        val card3 = findViewById<CardView>(R.id.cardview3)

        card1.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Protein Fruits")
            val items = listOf(
                NutritionItem(R.drawable.apple, "Apples", "A popular fruit known for its crunchy texture and mildly sweet taste. Apples are a great source of fiber, vitamin C, and antioxidants."),
                NutritionItem(R.drawable.banana, "Bananas", "A sweet and creamy fruit that is a great source of potassium and vitamin C. Bananas can help regulate blood sugar levels and aid digestion."),
                NutritionItem(R.drawable.orange, "Oranges", "A juicy and tangy fruit that is packed with vitamin C and fiber. Oranges may help reduce the risk of heart disease and improve skin health."),
                NutritionItem(R.drawable.grapes, "Grapes", "A sweet and juicy fruit that is rich in antioxidants and vitamin K. Grapes may help protect against certain types of cancer and improve brain function."),
                NutritionItem(R.drawable.kiwi, "Kiwi", "A small and fuzzy fruit that is loaded with vitamin C and fiber. Kiwis may help improve immune function and lower inflammation."),
                NutritionItem(R.drawable.mango, "Mango", "A sweet and tropical fruit that is rich in vitamins A and C. Mangoes may help lower cholesterol levels and improve digestion."),
                NutritionItem(R.drawable.pineapple, "Pineapple", "A sweet and juicy fruit that is high in vitamin C and manganese. Pineapple may help reduce inflammation and aid in digestion."),
                NutritionItem(R.drawable.watermelon, "Watermelon", "A refreshing and hydrating fruit that is packed with vitamins A and C. Watermelon may help lower blood pressure and reduce muscle soreness."),
                NutritionItem(R.drawable.blueberries, "Blueberries", "A small and sweet fruit that is a great source of antioxidants and fiber. Blueberries may help improve memory and reduce inflammation."),
                NutritionItem(R.drawable.strawberries, "Strawberries", "A juicy and sweet fruit that is high in vitamin C and antioxidants. Strawberries may help reduce the risk of heart disease and improve skin health.")
            )
            val itemNames = items.map { it.name }
            builder.setItems(itemNames.toTypedArray()) { _, index ->
                val selectedItem = items[index]

                // Inflate custom layout for selected item
                val inflater = LayoutInflater.from(this)
                val customView = inflater.inflate(R.layout.card_expand_item_layout, null)

                // Set values in custom layout
                customView.findViewById<TextView>(R.id.card_expand_items_title).text = selectedItem.name
                customView.findViewById<TextView>(R.id.card_expand_items_description).text = selectedItem.description
                customView.findViewById<ImageView>(R.id.card_expand_items_image).setImageResource(selectedItem.image)

                // Create AlertDialog with custom layout
                val customBuilder = AlertDialog.Builder(this)
                customBuilder.setView(customView)
                customBuilder.setPositiveButton("Close", null)
                customBuilder.show()
            }
            builder.setPositiveButton("Close", null)

            val dialog = builder.create()
            dialog.show()
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


        nutritionImageView.setBackgroundColor(R.color.purple2)

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

        profileImageView.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}