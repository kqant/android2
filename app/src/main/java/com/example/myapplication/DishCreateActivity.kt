package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class DishCreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dish_create)
        val buttonSave = findViewById<Button>(R.id.buttonSave)

        buttonSave.setOnClickListener{
            val textViewId = findViewById<EditText>(R.id.textViewId)
            val imageView = findViewById<ImageView>(R.id.imageView)
            val textViewName = findViewById<EditText>(R.id.textViewName)
            val textViewDateStart = findViewById<EditText>(R.id.textViewDateStart)
            val textViewDateEnd = findViewById<EditText>(R.id.textViewDateEnd)
            val textViewReview = findViewById<EditText>(R.id.textViewReview)

            val dish = Dish(
                textViewId.text.toString().toInt(),
                R.drawable.img1,
                textViewName.text.toString(),
                textViewDateStart.text.toString(),
                textViewDateEnd.text.toString(),
                textViewReview.text.toString()
            )

            val intent = Intent()
            intent.putExtra("result", dish)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setOnClickListener(){
            val intent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.INTERNAL_CONTENT_URI)

            intent.putExtra("crop", "true")
            intent.putExtra("scale", true)
            intent.putExtra("outputX", 256)
            intent.putExtra("outputY", 256)
            intent.putExtra("aspectX", 1)
            intent.putExtra("aspectY", 1)
            intent.putExtra("return-data", true)
            startActivityForResult(intent, 1)
        }


    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != RESULT_OK) {
            return
        }
        if (requestCode == 1) {
            val extras = data?.extras
            if (extras != null) {
                //Get image
                val newProfilePic = extras.getParcelable<Bitmap>("data")
                val imageView = findViewById<ImageView>(R.id.imageView)
                imageView.setImageBitmap(newProfilePic)
            }
        }
    }



}