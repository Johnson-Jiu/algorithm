package com.baizhi.reflection;

import org.junit.Test;

 enum Color{
    Red,Green,Yellow

}

public class TestEnum {
    public static void main(String[] args) {
        signal(Color.Red);
    }

    public static void signal(Color color){
        switch (color){
            case Green:
                System.out.println("1");
                break;
            case Red:
                System.out.println("2");
                break;
            case Yellow:
                System.out.println("3");
                break;
        }
    }
}
