package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class DishAdapter(val ctx: Context, val dishList: List<Dish>): BaseAdapter() {
    override fun getCount(): Int {
        return dishList.size
    }

    override fun getItem(position: Int): Dish {
        return dishList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var myView = convertView
        if (myView == null) {
            myView = LayoutInflater.from(ctx).inflate(R.layout.dish, parent, false)
        }
        val dish = getItem(position)
        myView?.findViewById<ImageView>(R.id.imageView)?.setImageResource(dish.image)
        myView?.findViewById<TextView>(R.id.textViewId)?.text = dish.id.toString()
        myView?.findViewById<TextView>(R.id.textViewName)?.text = dish.name
        myView?.findViewById<TextView>(R.id.textViewDateStart)?.text = dish.dateStart
        myView?.findViewById<TextView>(R.id.textViewDateEnd)?.text = dish.dateEnd
        myView?.findViewById<TextView>(R.id.textViewReview)?.text = dish.review

        return myView!!

    }

}