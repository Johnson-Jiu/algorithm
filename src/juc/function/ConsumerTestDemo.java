package juc.function;

import java.util.function.Consumer;

public class ConsumerTestDemo {
    public static void main(String[] args) {
        Consumer<String> consumer = (str)->{
            System.out.println(str);
        };
        consumer.accept("sdasdasd");
    }
}
