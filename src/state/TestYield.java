package state;

public class TestYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "   start");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "   end");
    }

    public static void main(String[] args) {
        TestYield myThread = new TestYield();
        new Thread(myThread,"a").start();
        new Thread(myThread,"b").start();
    }
}


