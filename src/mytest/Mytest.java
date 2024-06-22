package mytest;

public class Mytest {
    public static Mytest mytest(){
        return new Mytest();
    }

    public static void main(String[] args) {

/*        System.out.println(mytest());
        Mytest m1 = new Mytest();
        System.out.println(m1);
        System.out.println(mytest().getClass());
        System.out.println(m1.getClass());*/
        Mytest mytest = new Mytest();
        mytest.a();

    }
    public void a(){
        b();
    }
    public void b(){
        a();
    }
}
