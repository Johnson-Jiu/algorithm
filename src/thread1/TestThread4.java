package thread1;

public class TestThread4 implements Runnable{

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
        TestThread4 t1 = new TestThread4();       //三个线程共享一个对象
        new Thread(t1,"laowang").start();
        new Thread(t1,"xiaoming").start();
        new Thread(t1,"dashan").start();

    }
}
