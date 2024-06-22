package gc;

public class TestGc {
    public static void main(String[] args) {
        long l = Runtime.getRuntime().maxMemory();
        System.out.println("max" + l/1024/1024);

        long total = Runtime.getRuntime().totalMemory();
        System.out.println("total" + total/1024/1024);
    }
}
