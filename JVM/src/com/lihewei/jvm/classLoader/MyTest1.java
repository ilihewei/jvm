package com.lihewei.jvm.classLoader;

public class MyTest1 {
    public static void main(String[] args) {
        System.out.println(MyChild1.str);
    }
}

class  MyParent1{
    public  static  String str="hello world";
    static {
        System.out.println("Myparent static block");
    }
}

class  MyChild1 extends  MyParent1{
    public  static  String  str2="hello myChild";
    static {
        System.out.println(" MyChild2 static block");
    }
}
