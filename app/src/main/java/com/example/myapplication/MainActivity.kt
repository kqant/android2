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
import android.util.Log


class MainActivity : AppCompatActivity() {
    val dishList = mutableListOf<Dish>()
    val adapter = DishAdapter(this, dishList)


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
        val ButtonAdd = findViewById<Button>(R.id.buttonAdd)
        list.adapter = adapter
        ButtonAdd.setOnClickListener {
            Intent (this, DishCreateActivity::class.java).also {
                startActivityForResult(it, 0)
            }
        }


        list.setOnItemClickListener { parent, view, position, id ->
            Intent (this, DishActivity::class.java).also {
                it.putExtra("dish", dishList[position] as Serializable)
                startActivity(it)
            }
        }


    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                // Get the result from intent
                val result = data?.getSerializableExtra("result") as Dish
                // set the result to the text view

                dishList.add(result)
                val list = findViewById<ListView>(R.id.listView);
                adapter.notifyDataSetChanged()
            }
        }
    }

}