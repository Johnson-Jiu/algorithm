package syn;

public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(1000,"吃饭");
        Drawing you = new Drawing(account,50,"你");
        Drawing wife = new Drawing(account,100,"wife");
        you.start();

        wife.start();
    }
}

class Account{
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class Drawing extends Thread{
    Account account;
    int drawMoney;
    int nowMoney;

    public Drawing( Account account, int drawMoney,String name) {
        super(name);
        this.account = account;
        this.drawMoney = drawMoney;
    }

    @Override
    public void run() {
        synchronized (account){
            if(account.money - drawMoney < 0){
                System.out.println(Thread.currentThread().getName() + "qianbugou");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money = account.money - drawMoney;
            nowMoney = nowMoney + drawMoney;
            System.out.println(account.name + "余额" + account.money);
            System.out.println(this.getName()+ "手里的钱" + nowMoney);
        }

    }
}