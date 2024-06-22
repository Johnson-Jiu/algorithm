package lambda;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestLambda3 {

    List<Employee> list = Arrays.asList(
            new Employee(1,2),
            new Employee(2,3),
            new Employee(3,4)
    );
    @Test
    public void test1(){
        sort(2,(m) -> System.out.println(m));
    }
    public void sort(Integer money,Consumer<Integer> con){
        con.accept(money*money);
    }

    @Test
    public void test2(){
        System.out.println(random(10,()->((int)(Math.random()*100))));
    }
    public List random(Integer num, Supplier<Integer> res){
        List<Integer> list = new ArrayList<>();
        for (Integer i = 0; i < num; i++) {
            Integer e = res.get();
            list.add(e);
        }
        return list;
    }

    @Test
    public void test3(){
        System.out.println("\t\t\t1\tgu  1  !");
        System.out.println(fun("\t\t\t1\tgu  1  !",(x) -> x.trim()));
    }
    public String fun(String str1, Function<String,String> function){
        return function.apply(str1);
    }


    @Test
    public void test4(){
        List<String> list = Arrays.asList("1","2","30");
        System.out.println(filterStr(list,(str)->str.equals("2")));
    }
    public List<String> filterStr(List<String> str, Predicate<String> res){
        List<String> list = new ArrayList<>();
        for (String item : str) {
            if(!res.test(item)){
                list.add(item);
            }
        }
        return list;
    }
}
