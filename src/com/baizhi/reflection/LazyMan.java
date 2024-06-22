package com.baizhi.reflection;

public class LazyMan {
    private LazyMan() {
    }
    public volatile static LazyMan lazyMan;
    //双重检测锁模式 懒汉式单例 DCL懒汉式
    public static LazyMan getInstance(){
        if(lazyMan == null)
            synchronized (LazyMan.class){
                if(lazyMan == null)
                    lazyMan = new LazyMan();
            }
        return lazyMan;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}

