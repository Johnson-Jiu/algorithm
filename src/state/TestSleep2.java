package state;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class TestSleep2 {
    public static void main(String[] args) throws InterruptedException {
        Date date = new Date(System.currentTimeMillis());
        while (true){
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
            date = new Date(System.currentTimeMillis());
        }
    }

    public static void tenDown() throws InterruptedException {
        int i = 10;
        while(true){
            Thread.sleep(1000);
            System.out.println(i--);
            if(i < 0)
                break;
        }
    }
}
