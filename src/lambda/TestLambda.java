package lambda;

public class TestLambda {

   static class MyHabbit implements Habbit{
        @Override
        public void getHabbit() {
            System.out.println("我可喜欢睡觉了");
        }
    }


    public static void main(String[] args) {
        Habbit myHabbit = new MyHabbit(); //接口new 一个实现类  创建对象
        myHabbit.getHabbit();


        class MyHabbit2 implements Habbit{
            @Override
            public void getHabbit() {
                System.out.println("我可喜欢睡觉了///");
            }
        }
        myHabbit = new MyHabbit2();
        myHabbit.getHabbit();

        myHabbit = new Habbit() {
            @Override
            public void getHabbit() {

                System.out.println("我可喜欢睡觉了///***");
            }
        };
        myHabbit.getHabbit();


        myHabbit = ()->{
            System.out.println("我可喜欢睡觉了///**sdadasdasdasdasdsad*");
        };
        myHabbit.getHabbit();
    }
}

interface Habbit{
    void getHabbit();
}

class MyHabbit implements Habbit{
    @Override
    public void getHabbit() {
        System.out.println("我可喜欢睡觉了");
    }
}