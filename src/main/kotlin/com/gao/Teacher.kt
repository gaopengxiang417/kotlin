package com.gao

import java.util.*

/**
 * User: wangchen
 * Date: 2017/4/2
 * Time: 22:19
 */

class Teacher(

        val name: String,

        var age: Int
)

fun main(args: Array<String>) {

    val teacher = Teacher("wangchen", 30)
    println(teacher.name)
    println(teacher.age)

    val rectangle = Rectangle(32, 43)
    println(rectangle.isSquare)
}

//定制的getter方法
class Rectangle(val height: Int, val width : Int){
    val isSquare: Boolean
    get() {
        return height == width
    }
}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}