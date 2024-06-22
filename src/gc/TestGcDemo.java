package gc;

import java.util.ArrayList;

public class TestGcDemo {
    byte[] array = new byte[1*1024*1024];

    public static void main(String[] args) {
        int count = 0;
        ArrayList<TestGcDemo> list = new ArrayList<>();

        try {
            while (true){
                list.add(new TestGcDemo());
                count++;
            }
        } catch (Error e) {
            System.out.println("count====>" + count);
            e.printStackTrace();
        }


    }
}
