package com.lihewei.jvm.classLoader;

/**
 * Class objects for array classes are not created by class loaders,
 * but are created automatically as required by the Java runtime.
 * The class loader for an array class,
 * as returned by Class.getClassLoader() is the same as the class loader for its element type;
 * if the element type is a primitive type,
 * then the array class has no class loader.
 */
public class MyTest15 {

    class student{
        private  int id;
        private  String name;
        private  int age;

    }
    public static void main(String[] args) {
        String[] strings=new String[2];

        student[] students=new student[3];
        int[] ints=new int[2];

        System.out.println(strings.getClass().getClassLoader()); //root
        System.out.println(students.getClass().getClassLoader());//aplication
        System.out.println(ints.getClass().getClassLoader());// if the element type is a primitive type,
        // then the array class has no class loader

    }
}
