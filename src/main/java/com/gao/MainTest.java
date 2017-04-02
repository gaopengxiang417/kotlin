package com.gao;

/**
 * User: wangchen
 * Date: 2017/4/2
 * Time: 22:24
 */
public class MainTest {

    public static void main(String[] args) {

        //java代码访问kotlin
        Teacher wangchen = new Teacher("wangchen", 30);
        System.out.println(wangchen.getName());
        System.out.println(wangchen.getAge());
    }
}
