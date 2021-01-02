package com.lihewei.jvm.classLoader;

/**
 * 类加载器与类初始化深度解析
 */

class Parent2{
    static  int a=3;

    static {
        System.out.println("Parent2 static block");
    }
}


class  Child2 extends Parent2{
    static  int b=4;
    static {
        System.out.println("Child 2 static block");
    }
}
public class MyTest10 {
    static {
        System.out.println("MyTest10 static block");
    }

    //只会初始化一次父类
    public static void main(String[] args) {
        Parent2 parent2; // 引用
        System.out.println("----------------");
        parent2=new Parent2();//实例<主动使用>
        System.out.println("----------");
        System.out.println(Parent2.a);
        System.out.println("---------------");
        System.out.println(Child2.b); //初始化 child2，已经执行化完了 parent2

    }
}
