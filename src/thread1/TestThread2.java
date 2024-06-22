package thread1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread2 implements Runnable{

    private String url;
    private String name;

    public TestThread2(String url, String name1) {
        this.url = url;
        this.name = name1;
    }


    @Override
    public void run() {
        DownLoader downLoader = new DownLoader();
        try {
            downLoader.downLoad(url,name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        TestThread2 t1 = new TestThread2("https://oscimg.oschina.net/oscnet/up-32bf89eba4d350ef38567c053042a16c.jpg!/both/50x50","hsh");
        TestThread2 t2 = new TestThread2("https://assets.gitee.com/assets/qrcode-weixin-9e7cfb27165143d2b8e8b268a52ea822.jpg","24333");

        new Thread(t1).start();
        new Thread(t2).start();
    }
}

class DownLoader{
    public void downLoad(String url,String name) throws IOException {
        //URL url1 = new URL(url);
        FileUtils.copyURLToFile(new URL(url),new File(name));

    }
}