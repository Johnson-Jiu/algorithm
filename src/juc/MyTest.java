package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyTest {
    public static void main(String[] args) {
        Test test = new Test();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                test.incr();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                test.decr();
            }
        },"B").start();

    }

}
class Test{
    private int number = 0;
    private Lock lock= new ReentrantLock();
    Condition condition = lock.newCondition();
    public void incr(){
        lock.lock();
        try {
            while (number != 0){
                condition.await();
            }
            number = 1;
            System.out.println(Thread.currentThread().getName() + "已经生产，数量为1");
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();

        }

    }

    public void decr(){
        lock.lock();
        try {
            while (number != 1){
                condition.await();
            }
            number = 0;
            System.out.println(Thread.currentThread().getName() + "已经消费，数量为0");
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}