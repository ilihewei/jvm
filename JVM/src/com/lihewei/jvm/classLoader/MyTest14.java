package com.lihewei.jvm.classLoader;

import java.io.IOException;
import java.net.URL;

import java.util.Enumeration;


/**
 *
 * https://blog.csdn.net/u010312474/article/details/91046318
 *
 * 获得当前的类ClasLoader
 * clazz.getClassLoader()
 * 获得当前线程上下文的ClassLoader
 *  Thread.currentThread().getContextLoader()
 *  获得系统的ClassLoader
 *  ClassLoader.getSystemClassLoader()
 *  获得调用者的classloader
 *  DriverManager.getCallerClassLoader()
 *
 *
 *
 *  Class objects for array classes are not created by class loaders,
 *  but are created automatically as required by the Java runtime.
 *  The class loader for an array class, as returned by Class.getClassLoader()
 *  is the same as the class loader for its element type; if the element type is a primitive type,
 *  then the array class has no class loader.
 */
public class MyTest14 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader=Thread.currentThread().getContextClassLoader();

        String urlsName="com/lihewei/jvm/classLoader/MyTest13.class";
        Enumeration<URL> resources = classLoader.getResources(urlsName);
        while (resources.hasMoreElements()){
            URL url = resources.nextElement();
            //url===>file:/Users/apple/IdeaProjects/jvm/out/production/jvm/com/lihewei/jvm/classLoader/MyTest13.class
            System.out.println("url===>"+url);
        }

        //根类加载器
        Class<String> str = String.class;
        System.out.println(str.getClassLoader());
    }
}
