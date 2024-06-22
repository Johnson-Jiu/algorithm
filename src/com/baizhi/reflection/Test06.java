package com.baizhi.reflection;

import java.lang.reflect.Method;

public class Test06 {
    public static void test01(){
        User user = new User();
        long startTime = System.currentTimeMillis();
        for (int i = 0;i < 100000000;i++){
            user.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }

    public static void main(String[] args) {
        test01();

    }

}
