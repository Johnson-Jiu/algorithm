package com.baizhi.reflection;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class Test07 {
    public void test01(Map<String,User> map,List<User> list){
    }

    public Map<String,User> peo(){
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method test01 = Test07.class.getMethod("test01", Map.class, List.class);


    }
}
