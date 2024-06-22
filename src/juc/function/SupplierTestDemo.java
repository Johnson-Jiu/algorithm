package juc.function;

import java.util.function.Supplier;

public class SupplierTestDemo {
    public static void main(String[] args) {
        Supplier supplier = ()->{
            return 1024;
        };
        System.out.println(supplier.get());
    }
}
