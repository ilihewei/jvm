package com.lihewei.jvm.classLoader;

/**
 * public static int counter1=1;
 * 分为两步：第一步，初始化 counter1=0；
 * 第二步赋值 能： counter1=1；
 * 第三：从上向下执行
 */
public class MyTest6 {
    public static void main(String[] args) {
        SingleTon singleTon=SingleTon.getInstance();
        System.out.println("counter1===>"+SingleTon.counter1);
        System.out.println("counter2===>"+SingleTon.counter2);

    }
}

class SingleTon{
    public   static  int counter1=1;

   // public   static  int counter2=0;


    /**
     *
     * 准备阶段和初始化阶段的重要意义
     * 分两步
     * 第一：singleTon=null；
     * 第二：new SingleTon（）进行执行构造方法
     * 第三： singleTon =new Single();
     */
    private  static  SingleTon singleTon=new SingleTon();

    public  SingleTon(){
        counter1++;
        counter2++;//准备阶段的重要意义
    }

    public  static  int counter2=0;
    public  static  SingleTon getInstance(){
        System.out.println("1");
        return  singleTon;
    }
}
