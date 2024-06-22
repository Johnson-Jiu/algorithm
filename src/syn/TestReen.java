package syn;

import java.util.concurrent.locks.ReentrantLock;

public class TestReen {
    public static void main(String[] args) {
        TestLock testLock = new TestLock();
        new Thread(testLock,"小黑").start();
        new Thread(testLock,"阿黄").start();
        new Thread(testLock,"狗蛋").start();
    }
}

class TestLock implements Runnable{
    int ticketNum = 10;
    boolean flag = true;
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (flag){
            buy();
        }
    }

    public  void buy(){

        try {
            lock.lock();
            if(ticketNum <= 0){
                System.out.println("没票了");
                flag = false;
                return;                 //停止条件
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "买到了" + ticketNum--);
        } finally {
            lock.unlock();
        }
    }
}