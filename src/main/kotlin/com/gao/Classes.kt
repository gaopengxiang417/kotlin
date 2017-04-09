package com.gao

import java.io.Serializable

/**
 * User: wangchen
 * Date: 2017/4/9
 * Time: 20:06
 */

fun main(args: Array<String>) {
    val buttons = Buttons()
    buttons.click()
    buttons.setFocus(true)
    buttons.showoff()

    val richButton = RichButton()
    richButton.animate()
    richButton.disable()
    richButton.click()
}

//定义一个接口
interface Clickable {
    fun click()
    //默认方法
    fun showoff(){
        println("i am showoff")
    }
}

interface Focusable {
    fun setFocus(b : Boolean){
        println("i ${if (b) "got" else "lost"} focus")
    }
    fun showoff() {
        println("i am focusable")
    }
}

//实现一个接口
class Buttons : Clickable, Focusable {
    override fun click() {
        println("i was clicked")
    }

    override fun showoff() {
        super<Clickable>.showoff()
        super<Focusable>.showoff()
    }
}

//容许继承的类和关键字
open class RichButton : Clickable {

    //该方法不能被重载
    fun disable() {
        println("diable")
    }
    //该方法可以被重载
    open fun animate() {
        println("animate")
    }
    //重载父类的方法,同时子类不能重载该类的该方法
    final override fun click() {
        println("richbutton clicck")
    }
}

//抽象类
abstract class Animated {

    //抽象方法
    abstract fun animate()

    //子类可以覆盖
    open fun stopAnimate() {

    }

    //子类不能覆盖
    fun animateTwice() {

    }
}

internal open class Talkativebutton : Focusable {
    private fun yell() = println("hey!")
    protected fun whisper() = println("let's talk")
}

//报错 fun Talkativebutton.giveSpeech(){}

//类的嵌套
interface State : Serializable

interface ViewOne {
    fun  getCurrentState() : State
    fun restoreState(state: State){

    }
}

class ButtonView : ViewOne {
    override fun getCurrentState(): State = ButtonState()

    class ButtonState : State {
    }
}

//seal类的使用
sealed class ExprTwo {
    class NumTwo(val value : Int) : ExprTwo()
    class SumTwo(val left: ExprTwo, val right: ExprTwo) : ExprTwo()
}

fun evalTwo(e: ExprTwo) : Int = when (e) {
    is ExprTwo.NumTwo -> e.value
    is ExprTwo.SumTwo -> evalTwo(e.right) + evalTwo(e.left)
}