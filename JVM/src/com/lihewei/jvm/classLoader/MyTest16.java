package com.lihewei.jvm.classLoader;

import java.io.*;

public class MyTest16 extends ClassLoader {

    private String classLoaderName;
    private final String fileExtension=".class";
    public  MyTest16(String classLoaderName){
        super();//将系统类加载当做该类加载器的父加载器
        this.classLoaderName=classLoaderName;
    }


    public  MyTest16(ClassLoader parent,String classLoaderName){
        super(parent);//显式指定该类加载起的父加载器
        this.classLoaderName=classLoaderName;
    }

    @Override
    public  String toString(){
        return  "["+this.classLoaderName+"]";
    }




    @Override
    protected Class<?> findClass(String name) {

       byte[] data=this.loadClassData(name);
        return super.defineClass(name,data,0,data.length);
    }

    private byte[] loadClassData(String name) throws IOException {
        InputStream is=null;
        byte[] data=null;
        ByteArrayOutputStream baos=null;
        try{
            this.classLoaderName=this.classLoaderName.replace(".","/");
            is=new FileInputStream(new File(name+this.fileExtension));
            baos=new ByteArrayOutputStream();
            int ch=0;
            while (-1!=(ch=is.read())){
                baos.write(ch);
            }
            data=baos.toByteArray();
        }catch (Exception e){
            e.printStackTrace();;
        }finally {
            is.close();
            baos.close();
        }
        return data;
    }

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        MyTest16 myTest16=new MyTest16("loader1");
        test(myTest16);
    }

    public  static  void test(ClassLoader classLoader) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class<?> clazz=classLoader.loadClass("com.lihewei.jvm.classLoader.MyTest1");
        Object object=clazz.newInstance();
        System.out.println(object);
    }

}
