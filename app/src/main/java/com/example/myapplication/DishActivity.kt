package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish)

        val dish = intent.getSerializableExtra("dish") as? Dish

        val textViewId = findViewById<TextView>(R.id.textViewId)
        textViewId.text = dish?.id.toString()
        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setImageResource(dish?.image ?: 0)
        val textViewName = findViewById<TextView>(R.id.textViewName)
        val textViewDateStart = findViewById<TextView>(R.id.textViewDateStart)
        textViewDateStart.text = dish?.dateStart
        val textViewDateEnd = findViewById<TextView>(R.id.textViewDateEnd)
        textViewDateEnd.text = dish?.dateEnd
        val textViewReview = findViewById<TextView>(R.id.textViewReview)
        textViewReview.text = dish?.review


        val buttonBack = findViewById<Button>(R.id.buttonBack)
        buttonBack.setOnClickListener {
            finish()
        }
    }
}