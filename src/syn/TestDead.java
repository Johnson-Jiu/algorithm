package syn;

public class TestDead {
    public static void main(String[] args) {
        Makeup m1 = new Makeup(0,"小黑");
        Makeup m2 = new Makeup(1,"阿黄");
        new Thread(m1).start();
        new Thread(m2).start();
    }
}

class Mirror{

}
class LipStack{

}
class Makeup implements Runnable{
    int choice;
    String girlName;
    static Mirror mirror = new Mirror();
    static LipStack lipStack = new LipStack();

    public Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        makeup();
    }
    public void makeup(){
        if(choice == 0){
            synchronized (mirror){
                System.out.println("我要镜子");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipStack){
                    System.out.println("我要口红");
                }
            }
        }else{
            synchronized (lipStack){
                System.out.println("我要口红");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror){
                    System.out.println("我要镜子");
                }
            }
        }
    }
}