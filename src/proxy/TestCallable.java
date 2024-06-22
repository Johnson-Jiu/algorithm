package proxy;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class TestCallable implements Callable<Boolean> {
    private String url;
    private String name;

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        downLoad(url,name);
        return true;
    }

    public void downLoad(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://static.nowcoder.com/nc/image/identity/3.png","N");
        TestCallable t2 = new TestCallable("https://static.nowcoder.com//images-nk/img/icons/trophy.png","222");
        ExecutorService ser = Executors.newFixedThreadPool(3);

        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);

        boolean b1 = r1.get();
        boolean b2 = r2.get();
        ser.shutdownNow();

    }
}
