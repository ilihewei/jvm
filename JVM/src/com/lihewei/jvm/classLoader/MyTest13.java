package com.lihewei.jvm.classLoader;


/**
 * 双亲委派机制
 * sun.misc.Launcher$AppClassLoader@18b4aac2
 * sun.misc.Launcher$ExtClassLoader@6e0be858
 * null  //根类加载器
 */
public class MyTest13 {
    public static void main(String[] args) {
        ClassLoader loader=ClassLoader.getSystemClassLoader();

        System.out.println(loader);
        while (null!=loader){
            loader = loader.getParent();
            System.out.println(loader);
        }
    }
}
