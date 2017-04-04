package com.gao

import java.util.*

/**
 * User: wangchen
 * Date: 2017/4/4
 * Time: 10:20
 */

//while循环
var index: Int = 3

fun main(args: Array<String>) {

    while (index <= 10) {
        println(index++)
    }
    //使用for来进行
    for (i in 1..100) {
        println(fizzBuzz(i))
    }

    //更加特殊的for
    for (i in 100 downTo 1 step 2) {
        print(fizzBuzz(i))
    }

    println()

    mapIterate()

    arrayIterate()

    println(isLetter('k'))
    println(isNotDigit('9'))
}


//基础的用when来进行if处理逻辑
fun fizzBuzz(i: Int): String = when {
    i % 15 == 0 -> "fizzBuzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> "$i"
}

fun arrayIterate() {

    val list = arrayListOf("10", "11", "1020", "4343")

    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }
}

//对于map进行迭代
fun mapIterate() {

    var treeMap = TreeMap<Char, String>()

    for (c in 'A'..'M') {
        treeMap[c] = Integer.toBinaryString(c.toInt())
    }

    //获取map
    for ((letter, binary) in treeMap) {
        println("$letter = $binary")
    }
}

fun isLetter(c: Char) = c in 'a' .. 'z' || c in 'A' .. 'Z'
fun isNotDigit(c : Char) = c !in '0' .. '9'

