package single;

public class MyTest {
    private MyTest(){

    }

    public volatile static MyTest myTest;
    public static MyTest getInstance(){
        if(myTest == null){
            synchronized (MyTest.class){
                if(myTest == null){
                    myTest = new MyTest();
                }
            }
        }
        return myTest;
    }


}


