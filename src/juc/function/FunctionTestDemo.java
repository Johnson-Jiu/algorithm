package juc.function;

import java.util.function.Function;

public class FunctionTestDemo {
    public static void main(String[] args) {
        Function<String, String> function = (str)->{
            return str;
        };
        System.out.println(function.apply("45646"));
    }
}
