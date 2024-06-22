package syn;

public class UnsafrBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket,"xiaohei").start();
        new Thread(buyTicket,"阿黄").start();
        new Thread(buyTicket,"小郑").start();

    }
}

class BuyTicket implements Runnable{
    private int ticketNum = 10;
    private boolean flag = true;
    @Override
    public void run() {
        while (flag){
            buy();
        }
    }

    public synchronized void buy(){
        if(ticketNum <= 0){
            flag = false;
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "get" + ticketNum--);
    }
}