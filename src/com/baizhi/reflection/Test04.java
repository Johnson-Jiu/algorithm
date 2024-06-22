package com.baizhi.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test04 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("com.baizhi.reflection.User");
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());
        Field[] fields = c1.getFields();
        for(Field field : fields){
            System.out.println(field);
        }
        Method[] methods = c1.getDeclaredMethods();
        for(Method method :methods){
            System.out.println("sadasd" + method);
        }
    }
}
