package demo;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class test {

    @Test
    public void test(){
        System.out.println((-2 & 1));

    }

    public static void main (String[] arr) throws Exception{
        Object a=new Object ();
        Object b=new Object ();
        Object c=new Object ();


        Thread A=new Thread (new t ("A",a,b));//这个执行顺序 可以看下面代码撸一下
        A.start ();
        Thread.sleep (10); // 这里sleep主要保证线程启动顺序
        Thread B=new Thread (new t ("B",b,c));
        B.start ();
        Thread.sleep (10);
        Thread C=new Thread (new t ("C",c,a));
        C.start ();


    }

    static class t implements Runnable{
        private String ms;
        private Object my; // 我的锁
        private Object you; // 下一个要执行线程的锁

        public t (String ms, Object my, Object you) {
            this.ms = ms;
            this.my = my;
            this.you = you;
        }

        @Override
        public void run () {
            int count = 10;
            while (count > 0) {
                synchronized (my) { //锁住自身 ，进入代码块
                    System.out.print (ms);
                    count--;
                    synchronized (you) {
                        you.notifyAll ();
                    }
                    try {
                        if (count == 0) {
                            my.notifyAll ();
                        } else {
                            my.wait (); // 执行了一次后让自己等待，注意此时释放锁，等待其他线程调用“my”.notifyAll(),
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace ();
                    }
                }
            }
        }
    }
}