
@file:JvmName("FunctionCallKtt")
package com.gao

/**
 * User: wangchen
 * Date: 2017/4/4
 * Time: 11:37
 */

//常量的定义
var opCount = 0
//等同于public static final String UNIX_TIME = "TEST"
const val UNIX_TIME = "TEST"

fun main(args: Array<String>) {

    //集合的创建
    val set = hashSetOf(1, 2, 4, 66)
    val list = arrayListOf(1, 2, 4, 66)
    val map = hashMapOf(1 to "cne", 7 to "seven", 66 to "fifty-three")

    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)

    val stringlist = listOf("first", "second", "third")
    println(stringlist.last())

    println(set.max())


    println(set)


    println(joinToString(list, ";", "(", ")"))
    //调用的时候指定值对应的参数
    println(joinToString(list, sepator = ";", prefix = "(", suffix = ")"))

    println("kotlin".lastChar())

    println(list.joinToStringW(":"))

    val view : View = Button()
    view.click()

    view.showOff()
}

/**
 * 进行字符串的聚合
 * 默认参数值
 */
fun <T> joinToString(collection: Collection<T>,
                     sepator: String = ",", prefix: String = "", suffix: String = "") : String {
    val sb = StringBuffer(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) {
            sb.append(sepator)
        }
        sb.append(element)
    }

    sb.append(suffix)
    return sb.toString()
}

//在已有的类基础之上扩展
fun String.lastChar() : Char = get(length - 1)

//最终扩展函数
fun <T> Collection<T>.joinToStringW(sepator: String = ",", prefix: String = "", suffix: String = ""): String {
    val sb = StringBuffer(prefix)
    for ((index, element) in withIndex()) {
        if (index > 0) {
            sb.append(sepator)
        }
        sb.append(element)
    }

    sb.append(suffix)
    return sb.toString()
}

//类的继承
open class View {
    open fun click() {
        println("i am a view")
    }
}

class Button : View() {
    override fun click() {
        println("i am a button")
    }
}

fun View.showOff() = println("view show")
fun Button.showOff() = println("view show")