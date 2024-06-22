package lambda.LambdaTest;


import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;

public class LambdaTest {
    public static void main(String[] args) throws Exception {
        doConsume(System.out::println);
    }

    private static void doConsume(SerializableConsumer<Long> consumer) throws Exception {
        consumer.accept(123L);
        // 直接调用writeReplace
        Method writeReplace = consumer.getClass().getDeclaredMethod("writeReplace");
        writeReplace.setAccessible(true);
        Object sl = writeReplace.invoke(consumer);
        SerializedLambda serializedLambda = (SerializedLambda) sl;
        System.out.println(serializedLambda);
    }
}

