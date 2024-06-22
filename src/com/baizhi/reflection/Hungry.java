package com.baizhi.reflection;

public class Hungry {
    private Hungry() {
    }
    public static final Hungry hungry= new Hungry();
    public static Hungry getInstance(){
        return hungry;
    }
}
