package state;

public class TestStop implements Runnable{
    boolean flag = true;


    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println("running------" + i++);
        }
    }

    public void stop(){
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
            if(i == 900){
                testStop.stop();
                System.out.println("线程停止");
            }
        }
    }
}
