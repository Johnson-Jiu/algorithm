package juc.rwlocl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyTest {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        for (int i = 0; i < 100; i++) {
            final int temp = i;
            new Thread(()->{
                myThread2.put(temp + "",temp + "");
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            final int temp = i;
            new Thread(()->{
                myThread2.get(temp + "");
            }).start();
        }
    }
}
class MyThread1{
    private volatile Map<String,String> map = new HashMap<>();
    public void put(String key,String value){
        System.out.println("要添加" + key);
        map.put(key,value);
        System.out.println("已经添加" + key);
    }

    public void get(String key){
        System.out.println("要得到" + key);
        map.get(key);
        System.out.println("已经得到" + key);
    }
}
class MyThread2{
    private volatile Map<String,String> map = new HashMap<>();
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key,String value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println("要添加-------------------------" + key);
            map.put(key,value);
            System.out.println("已经添加" + key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println("要得到" + key);
            map.get(key);
            System.out.println("已经得到" + key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}