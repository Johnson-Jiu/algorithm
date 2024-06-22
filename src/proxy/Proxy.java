package proxy;

public class Proxy {
    public static void main(String[] args) {                            //静态代理在多线程的使用
        // Runnable 和 Thread代理都有ｒｕｎ方法，在最后调用的是Ｔｈｒｅａｄ的ｓｔａｒｔ方法，但实际执行的是Ｒｕｎｎａｂｌｅ中的ｒｕｎ方法体
        // new Thread(t1).start();
        new MarryCompany(new You()).getMarry();
      /*  MarryCompany marryCompany = new MarryCompany(new You());
        marryCompany.getMarry();*/
    }

}

interface Marry{
    void getMarry();
}

class You implements Marry{
    @Override
    public void getMarry() {
        System.out.println("老子结婚了");
    }
}

class MarryCompany implements Marry{
    private Marry target ;

    public MarryCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void getMarry() {
        before();
        this.target.getMarry();
        after();
    }

    private void after() {
        System.out.println("收钱");
    }

    private void before() {
        System.out.println("布置会所");
    }
}