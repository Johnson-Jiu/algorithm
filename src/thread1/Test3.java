package thread1;

import com.sun.corba.se.impl.orbutil.closure.Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test3 {
    public static void main(String[] args) {
        new Thread1().start();
        new Thread(new Thread2()).start();
        FutureTask futureTask = new FutureTask(new Thread3());
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class Thread1 extends Thread{
    @Override
    public void run() {
        System.out.println("111111111111");
    }
}

class Thread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("222222222222");
    }
}

class Thread3 implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("66666666666666");
        return "3333333333333";
    }
}