package demo;


import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@mtInterface
public class Application {
    public static void main(String[] args) {

    }

    public void fuck(int a ,int b){

    }

}

@Target(value = ElementType.TYPE)
@interface mtInterface {

}
