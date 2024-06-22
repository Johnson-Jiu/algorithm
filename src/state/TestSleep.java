package state;

import thread1.TestThread4;
//模拟网络延时，放大问题的发生性
public class TestSleep implements Runnable{

    private  int ticksNum = 10;
    @Override
    public void run() {
        while (true){
            if(ticksNum <= 0)
                break;
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了第" + ticksNum--);
        }
    }

    public static void main(String[] args) {
        TestSleep t1 = new TestSleep();       //三个线程共享一个对象
        new Thread(t1,"laowang").start();
        new Thread(t1,"xiaoming").start();
        new Thread(t1,"dashan").start();

    }
}
