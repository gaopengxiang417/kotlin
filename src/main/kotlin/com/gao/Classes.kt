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

    //类实例的创建
    println(UserOne("first"))
    println(UserTow("second"))
    println(UserThree("second", false))

    println(PrivateUser("wangchen@ttt.com").nickName)
    println(SubscribingUser("wangchen@email.com").nickName)

    val userTen = UserTen("ailce")
    userTen.address = "i am wangchen"

    val lengthCounter = LengthCounter()
    lengthCounter.addWord("hahha")
}

//方法访问可见性，可以不对外提供set方法访问权限
class LengthCounter {

    var counter : Int = 0
    private set

    fun addWord(word: String) {
        counter += word.length
    }
}

class UserTen(val name: String){
    var address: String = "unspecified"
        set(value: String) {
            println("addess was changed for $name: $field -> $value")
            field = value
        }
}

//接口中定义属性
interface UserSecond {
    val nickName : String
}

//覆盖父类的属性
class PrivateUser(override val nickName: String) : UserSecond

class SubscribingUser(val email: String) : UserSecond {
    override val nickName: String
        get() = email.substringBefore('@')
}

//二级构造器的定义
open class ViewFirst {

    constructor(ctx : Int)
    constructor(ctx : Int, attr: String)
}

//子类继承父类
class ButtonFirst : ViewFirst {
    constructor(ctx: Int) : super(ctx)
    constructor(ctx: Int, attr: String) : super(ctx, attr)
}

//类继承以后对于父类的构造器使用
open class UserFive(val name: String)
class SonUser(name: String) : UserFive(name)

//该类使用默认构造器
open class ButtonThree

//没有提供任何构造器，必须调用父类的构造器
class RadioButton : ButtonThree()


//类的声明中添加默认参数
data class UserThree(val name: String, val substrbed : Boolean = true)


//在kotlin中一个标准的构造器如下
data class UserOne constructor(val _name: String){
    val name : String
    init {
        name = _name
    }
}

//更进一步声明一个类
data class UserTow constructor(val _name : String){
    val name = _name
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