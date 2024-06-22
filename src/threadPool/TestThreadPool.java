package threadPool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {
    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
                10,
                30,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(10),
                new ThreadPoolExecutor.AbortPolicy());

        executor.execute(new TestThread());
        executor.execute(new TestThread());
        executor.execute(new TestThread());
        executor.execute(new TestThread());
        executor.execute(new TestThread());


    }

    public static void sayHi(String name) {
        String printStr = "thread-name:" + Thread.currentThread().getName() + ",执行方式：" + name;
        System.out.println(printStr);
        throw new RuntimeException(printStr + " error!!!");
    }

}

class TestThread implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}