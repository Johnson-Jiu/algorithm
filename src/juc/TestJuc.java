package juc;

public class TestJuc {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{ for (int i = 0; i < 60; i++) ticket.sale(); },"A").start();

        new Thread(()->{
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            } },"B").start();

        new Thread(()->{
            for (int i = 0; i < 60; i++) {
            ticket.sale();
        } },"C").start();

    }
}

class Ticket{
    private int number = 50;
    public synchronized void sale(){
        if(number > 0){
            System.out.println(Thread.currentThread().getName() + "卖出" + number-- + "票");

        }
    }
}