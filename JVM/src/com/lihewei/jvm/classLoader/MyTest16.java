package com.lihewei.jvm.classLoader;

import java.io.*;

/**
 * 1.JVM 规范允许类加载器在预料某个类将要被使用时就预先加载它，
 * 如果在预先加载的过程中遇到了.class 文件缺失或存在错误，
 * 类加载器必须在程序首次主动使用该类时才报告错误(LinkageError错误)
 * <p>
 * 2.如果这个类一直没有被程序主动使用，那么类加载器就不会报告错误。
 *
 *
 *
 *
 *          命名空间
 * 1.每个类加载器都有自己的命名空间，命名空间由该加载器及所有父加载器的类组成
 * 2.在同一个命名空间中，不会出现类的完整名字（包括类的包名）相同的两个类
 * 3.在不同的命名空间中，有可能会出现类的完整名字（包括类的报名）相同的两个类
 *
 *
 * 关于命名空间的重要说明
 * 1.子加载器所加载的类能访问到父加载器所加载的类
 * 2.父加载器所加载的类无法访问到子加载器的所加载的类
 */
public class MyTest16 extends ClassLoader {

    private final String fileExtension = ".class";
    private String classLoaderName;

    public MyTest16(String classLoaderName) {
        super();//将系统类加载当做该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }


    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent);//显式指定该类加载起的父加载器
        this.classLoaderName = classLoaderName;
    }

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        MyTest16 myTest16 = new MyTest16("loader1");
        test(myTest16);
    }

    public static void test(ClassLoader classLoader) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class<?> clazz = classLoader.loadClass("com.lihewei.jvm.classLoader.MyTest1");
        Object object = clazz.newInstance();
        System.out.println(object);
    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]";
    }

    @Override
    protected Class<?> findClass(String name) {

        byte[] data = this.loadClassData(name);
        return super.defineClass(name, data, 0, data.length);
    }

    private byte[] loadClassData(String name) throws IOException {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try {
            this.classLoaderName = this.classLoaderName.replace(".", "/");
            is = new FileInputStream(new File(name + this.fileExtension));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            ;
        } finally {
            is.close();
            baos.close();
        }
        return data;
    }

}
