package juc;

import org.junit.Test;

public class TestThreadLocal {
    private static final ThreadLocal<Integer> STATIC_NUM = new ThreadLocal<>();
    private static final ThreadLocal<Integer> STATIC_NUM2 = new ThreadLocal<>();


    @Test
    public void test(){
        Integer integer = STATIC_NUM.get();
        STATIC_NUM.set(1);
        STATIC_NUM2.get();
        STATIC_NUM2.set(2);
        STATIC_NUM.remove();

    }
}
