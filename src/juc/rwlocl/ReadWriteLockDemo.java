package juc.rwlocl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            new Thread(()->{
                myThread.put(temp + "", temp + "");
            }).start();
        }

        for (int i = 1; i <= 5 ; i++) {
            final int temp = i;
            new Thread(()->{
                myThread.get(temp+"");
                },String.valueOf(i)).start(); }
    }
}

class MyThread{
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private volatile Map<String,Object> map = new HashMap<>();

    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"写入"+key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key){
        readWriteLock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName()+"读取"+key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }


    }
}
