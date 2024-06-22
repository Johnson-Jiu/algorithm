package thread1;

public class TestThread3 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("我爱吃便便");
        }
    }

    public static void main(String[] args) {
        TestThread3 testThread3 = new TestThread3();
       new Thread(testThread3).start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("111111111111");
        }

    }
}
