package single;

public class LazyMan {
    private LazyMan(){

    }

    public volatile  static LazyMan lazyMan;
/*    public static LazyMan getInstance(){
        if(lazyMan == null){
            lazyMan = new LazyMan();
        }
        return lazyMan;
    }*/


    /**
     * 双重检测所模式
     */
    public static LazyMan getInstance(){
        if(lazyMan == null){
            synchronized (LazyMan.class){
                if(lazyMan == null){
                    lazyMan = new LazyMan();
                }
            }
        }
        return lazyMan;
    }
}
