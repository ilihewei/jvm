package com.lihewei.jvm.classLoader;

import java.util.Random;

/**
 * 当一个接口初始化时，并不要求其父接口完成初始化
 * 只有在真正使用到父接口的时候，（如引用接口中所定义的常量时），才会初始化
 */
public class MyTest5 {
    public static void main(String[] args) {
      //  System.out.println(MyChild5.a);
        System.out.println(MyChild5.c);
    }
}

interface  MyParent5{
    public  static  int a=5;
}

  interface  MyChild5 extends  MyParent5{
    public  static  int b=6;
    public  static  final  int c=new Random().nextInt(4);
}