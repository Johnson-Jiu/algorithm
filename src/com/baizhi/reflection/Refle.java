package com.baizhi.reflection;

public class Refle {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.baizhi.reflection.Test");
    }



}

class Test {
    static int m = 1;
    static {
        System.out.println("静态！");
         m = 1000;
    }

    public Test() {
        System.out.println("我是构造方法");
    }
}