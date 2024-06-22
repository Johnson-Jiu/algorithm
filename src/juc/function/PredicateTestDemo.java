package juc.function;

import java.util.function.Predicate;

public class PredicateTestDemo {
    public static void main(String[] args) {
        Predicate<String> predicate = (str)->{
            return str.isEmpty();
        };
        System.out.println(predicate.test(""));
    }
}
