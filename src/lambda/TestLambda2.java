package lambda;

public class TestLambda2 {
    public static void main(String[] args) {

        ILove ilove = (int a)-> {
            System.out.println("iaiiaiaiai" + a );
        };

        ilove.love(5);
    }
}

interface ILove{
    void love(int a);
}

class ILoveImpl implements ILove{
    @Override
    public void love(int a) {

    }
}