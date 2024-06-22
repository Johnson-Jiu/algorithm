package thread1;

public class MyTest implements Runnable{
    private String winner;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(hashWinner(i)){
                break;
            }
            System.out.println(Thread.currentThread().getName() + "已经跑了" + i);
        }
    }


    public boolean hashWinner(int step){
        if(winner != null){
            return true;
        }else{
            if(step == 100){
                winner = Thread.currentThread().getName();
                System.out.println("winner is " + winner);
                return true;
            }
        }


        return false;
    }
    public static void main(String[] args) {
        MyTest t1 = new MyTest();
        new Thread(t1,"猫猫").start();
        new Thread(t1,"狗狗").start();
    }
}
