package gc;


public class TestBuild {
    public static void main(String[] args) {
        System.out.println("运行ExaminationDemo中的main函数，创建D类实例");
        new D();
    }
}

class E {
    E() {
        System.out.println("执行E的构造函数");
    }

    public void funcOfE() {
        System.out.println("执行E的函数");
    }
}

class F {
    F() {
        System.out.println("执行F的构造函数");
    }
    public void funcOfF() {
        System.out.println("执行F的函数");
    }
}

class B {
    E e = new E();
    static F f = new F();
    public String sb = getSb();
    static {
        System.out.println("执行B的static块(B包含E的成员变量,包含静态F的成员变量)");
        f.funcOfF();
    }
    {
        System.out.println("执行B实例的普通初始化块");
    }

    B() {
        System.out.println("执行B的构造函数(B包含E的成员变量,包含静态F类成员变量)");
        e.funcOfE();
    }

    public String getSb() {
        System.out.println("初始化B的实例成员变量sb");
        return "sb";
    }
}

class C extends B {
    static {
        System.out.println("执行C的static块(C继承B)");
    }
    {
        System.out.println("执行C的普通初始化块");
    }

    C() {
        System.out.println("执行C的构造函数(C继承B)");
    }
}

class D extends C {
    public String sd1 = getSd1();
    public static String sd = getSd();
    static {
        System.out.println("执行D的static块(D继承C)");
    }
    {
        System.out.println("执行D实例的普通初始化块");
    }

    D() {
        System.out.println("执行D的构造函数(D继承C);父类B的实例成员变量sb的值为：" + sb
                + ";本类D的static成员变量sd的值为：" + sd + ";本类D的实例成员变量sd1的值是：" + sd1);
    }

    static public String getSd() {
        System.out.println("初始化D的static成员变量sd");
        return "sd";
    }
    public String getSd1() {
        System.out.println("初始化D的实例成员变量sd1");
        return "sd1";
    }
}
