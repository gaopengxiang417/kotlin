package com.gao

/**
 * @author: wangchen
 * @date: 2017/3/31
 * Time: 13:50
 */
data class Person(val name: String, val age: Int? = null)

fun main(args: Array<String>) {

    val list = listOf(Person("Alick"), Person("Bolb", 23))

    val max = list.maxBy { it.age ?: 0 }

    println(max)
}
