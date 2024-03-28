package com.example.myapplication

import java.io.Serializable

class Dish(
    var id: Int,
    var image: Int,
    var name: String,
    var dateStart: String,
    var dateEnd: String,
    var review: String
) : Serializable {


}
