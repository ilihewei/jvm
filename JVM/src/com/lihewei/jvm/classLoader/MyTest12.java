package com.lihewei.jvm.classLoader;


class CL{
    static {
        System.out.println("Class CL");
    }
}
//调用 ClassLoader类的loadClass 方法加载一个类，并不是对类的主动使用，不会导致类的初始化。
//loadClass 加载类，加载jvm中。加载--连接--初始化。
public class MyTest12 {
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * class com.lihewei.jvm.classLoader.CL
         * -----------------
         * Class CL
         * class com.lihewei.jvm.classLoader.CL
         */


        ClassLoader loader=ClassLoader.getSystemClassLoader();
        Class<?> clazz=loader.loadClass("com.lihewei.jvm.classLoader.CL");
        System.out.println(clazz);

        System.out.println("-----------------");
        //反射主动使用
        clazz=Class.forName("com.lihewei.jvm.classLoader.CL");
        System.out.println(clazz);
    }
}
