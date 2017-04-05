package com.gao

/**
 * User: wangchen
 * Date: 2017/4/2
 * Time: 21:46
 */
fun main(args: Array<String>) {
    println("hello, world")

    println(answer.javaClass)
    println(yearsToCompute.javaClass)

    //变量模板
    println("hello, $name")
    println("hello, ${name}")
    println("hello, ${if (true) "bigger" else "smaller"}")

    //调用另外的函数逻辑
    println("kotlin".lastChar())
}

/**
 * 函数定义
 */
fun max(a: Int, b: Int): Int = if (a > b) a else b

//变量定义
var question = "the ultimate question of life, the universe, and everything"

var answer = 43

var answer2 : Int = 44

var yearsToCompute = 23.43

//var 对应于java的可变变量
//val 对应于java的不可变变量
val answer3 = 22

/**
 * 有时候虽然val是不可变变量，但是可能指向的还是可变变量 val str = "china
 * 有时候var虽然是可变变量，但是指向的引用可能还是不可变, var in = 43; in = "3232" 这个时候编译器会报错
 * */
var name = "kotin"