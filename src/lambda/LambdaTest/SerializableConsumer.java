package lambda.LambdaTest;

import java.io.Serializable;

public interface SerializableConsumer<T> extends Serializable {
    /**
     * 消费
     * @param t
     */
    void accept(T t);
}
