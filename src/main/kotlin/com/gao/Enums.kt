package com.gao

import com.gao.Color.*

/**
 * User: wangchen
 * Date: 2017/4/3
 * Time: 14:29
 */
//枚举类的声明
enum class Color(
        val r: Int,
        val g: Int,
        val b: Int
){
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    fun rgb(): Int = (r * 256 + g) * 256 + b
}

//通过when实现对于枚举的处理
fun getMemory(color: Color) = when (color) {
    BLUE -> "Rich"
    GREEN -> "Of"
    INDIGO -> "York"
    ORANGE -> "Gave"
    RED -> "Battle"
    VIOLET -> "In"
    YELLOW -> "Vain"
}

//多个分支聚合一个结果
fun getWarmth(color : Color) = when (color) {
    VIOLET, YELLOW, RED -> "warm"
    ORANGE, INDIGO, GREEN -> "neutral"
    BLUE -> "cold"
}

//对于多个对象的枚举判断
fun mix(color1: Color, color2: Color) = when (setOf(color1, color2)) {
    setOf(RED, YELLOW) -> ORANGE
    setOf(YELLOW, BLUE) -> GREEN
    else -> throw Exception("Dirty color")
}

//when不接受任何参数处理
fun mixOption(color1: Color, color2: Color): Color {
    return when {
        (color1 == RED && color2 == YELLOW) || (color1 == YELLOW && color2 == RED) -> ORANGE
        (color1 == YELLOW && color2 == BLUE) || (color1 == BLUE && color2 == YELLOW) -> GREEN
        (color1 == BLUE && color2 == VIOLET) || (color1 == VIOLET && color2 == BLUE) -> INDIGO

        else -> throw Exception("dirty color")
    }
}

//接口和类的定义
interface Expr
class Num(val value : Int) : Expr
class Sum(val left : Expr, val right : Expr) : Expr

//普通采用java的实现方式
fun evaljava(e: Expr): Int {

    if (e is Num) {
        val n = e as Num
        return n.value
    }
    if (e is Sum) {
        return  evaljava(e.right) + evaljava(e.left)
    }
    throw IllegalArgumentException("unknow expression")

}

fun evalKotilnOne(e: Expr): Int = (e as? Num)?.value ?: if (e is Sum) {
    evalKotilnOne(e.left) + evalKotilnOne(e.right)
} else {
    throw IllegalArgumentException("unknow expression")
}


fun main(args: Array<String>) {
    println(BLUE.rgb())

    println(getMemory(VIOLET))

    println(getWarmth(INDIGO))

    println(mix(RED, YELLOW))


    println(mixOption(RED, YELLOW))

    println(evaljava(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(evalKotilnOne(Sum(Sum(Num(1), Num(2)), Num(4))))
}