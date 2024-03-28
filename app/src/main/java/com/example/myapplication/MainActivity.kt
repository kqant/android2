package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val list = findViewById<ListView>(R.id.listView);
        val ButtonAdd = findViewById<Button>(R.id.buttonAdd);

        val dishList = mutableListOf<Dish>()
        dishList.add(
            Dish(
                1,
                R.drawable.img1,
                "Пицца",
                "11.01.2022",
                "12.01.2022",
                "Вкусная пицца"
            )
        )
        dishList.add(
            Dish(
                2,
                R.drawable.img2,
                "Макароны",
                "11.01.2022",
                "12.01.2022",
                "Вкусная свинина"
            )
        )
        dishList.add(Dish(3, R.drawable.img3, "Шаурма", "11.01.2022", "12.01.2022", "Вкусный сыр"))

        val adapter = DishAdapter(this, dishList)
        list.adapter = adapter
        ButtonAdd.setOnClickListener {
            dishList.add(Dish(4, R.drawable.img1, "Пицца", "11.01.2022", "12.01.2022", "Вкусная пицца"))
            adapter.notifyDataSetChanged()
        }

        list.setOnItemClickListener { parent, view, position, id ->
            Intent (this, DishActivity::class.java).also {
                it.putExtra("dish", dishList[position] as Serializable)
                startActivity(it)
            }
        }


    }

}