package thread1;

/**
 * @author Mr Wrong
 */
public class TestThread1 extends Thread{

    @Override
    public void run() {
        System.out.println("java");
    }

    public static void main(String[] args) {
        TestThread1 t1 = new TestThread1();
        t1.start();
    }
}
