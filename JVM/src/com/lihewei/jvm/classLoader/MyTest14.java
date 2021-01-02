package com.lihewei.jvm.classLoader;

import java.io.IOException;
import java.net.URL;

import java.util.Enumeration;


/**
 * 获得当前的类ClasLoader
 * clazz.getClassLoader()
 * 获得当前线程上下文的ClassLoader
 *  Thread.currentThread().getContextLoader()
 *  获得系统的ClassLoader
 *  ClassLoader.getSystemClassLoader()
 *  获得调用者的classloader
 *  DriverManager.getCallerClassLoader()
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
