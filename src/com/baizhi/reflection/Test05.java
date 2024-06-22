package com.baizhi.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test05 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        Class c1 = Class.forName("com.baizhi.reflection.User");

        /*Object o = c1.newInstance();
        System.out.println(o);
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, String.class);
        User user2 = (User)constructor.newInstance("zhuosen", 18, "men");
        System.out.println(user2);

        */

        User user3 = (User)c1.newInstance();
        user3.setSex("men");
        System.out.println(user3.getSex());

        Method setSex = c1.getDeclaredMethod("setName", String.class);
        setSex.invoke(user3,"women");
        System.out.println(user3.getName());

        User user4 = (User)c1.newInstance();
        Field name = c1.getDeclaredField("name");
        name.set(user3,"miaomiao");
        System.out.println(user4.getName());
    }
}
