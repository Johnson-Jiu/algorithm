package thread1;

public class Race implements Runnable{
    private static String win ;

    @Override
    public void run() {
        for (int i = 0; i <= 50; i++) {

            if(winner(i)){
                break;
            }
            System.out.println(Thread.currentThread().getName() + "已经跑了" + i);
        }
    }

    public boolean winner(int step){

        if(win != null){
            return true;
        }else{
            if(step == 50){
                win = Thread.currentThread().getName();
                System.out.println("winner is " + win);
                return true;
            }
        }


        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }

}
