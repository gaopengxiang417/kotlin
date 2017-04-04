package com.gao

import java.io.BufferedReader
import java.io.StringReader

/**
 * User: wangchen
 * Date: 2017/4/4
 * Time: 11:20
 */

fun main(args: Array<String>) {


    val number = 11
    val percent = if (number in 0 .. 100) number else throw IllegalArgumentException("percepent is not correct")
    println(percent)

    val bufferedReader = BufferedReader(StringReader("12312"))
    println(readNumber(bufferedReader))

    readNumber2(bufferedReader)

    readNumber3(BufferedReader(StringReader("is e")))
}

fun readNumber3(reader: BufferedReader) {

    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: Exception) {
        null
    }
    println(number)
}

fun readNumber2(reader: BufferedReader) {

    val number: Int = try {
        Integer.parseInt(reader.readLine())
    } catch (e: Exception) {
        return
    }
    println(number)
}

fun readNumber(reader: BufferedReader): Int? {

    try {
        val readLine = reader.readLine()
        return Integer.parseInt(readLine)
    } catch (e: Exception) {
        return null
    }finally {
        reader.close()
    }
}