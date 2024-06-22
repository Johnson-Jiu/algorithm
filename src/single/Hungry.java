package single;

public class Hungry {
    private Hungry() {
    }

    public final static Hungry HUNGRY = new Hungry();
    public static Hungry getHungry(){
        return HUNGRY;
    }
}
