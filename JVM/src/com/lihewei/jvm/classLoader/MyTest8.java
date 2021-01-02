package com.lihewei.jvm.classLoader;

import java.util.Random;

class FinalTest{

    public  static  final int x=2;

    static {
        System.out.println("finalTest static block");
    }
}

class FinalTest2{

    public  static   int y=2;

    static {
        System.out.println("finalTest static block");
    }
}

class FinalTest3{
    public  static  final int x=new Random().nextInt(3);
    static {
        System.out.println("finalTest static block");
    }
}
public class MyTest8 {
    public static void main(String[] args) {
        System.out.println(FinalTest.x);
        System.out.println(FinalTest2.y);
        System.out.println(FinalTest3.x);
    }
}
