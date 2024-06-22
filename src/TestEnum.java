import java.util.HashMap;
import java.util.Map;

public enum  TestEnum {
    //星期
    MONDAY(1,"周一");

    private final Integer code;
    private final String name;

    TestEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
    private static Map<Integer,TestEnum> WEEK_MAP = new HashMap<>();

    static {
        for(TestEnum value : TestEnum.values()){
            WEEK_MAP.put(value.getCode(),value);
        }
    }

    public static TestEnum getTestEnum(Integer code){
        return WEEK_MAP.get(code);
    }
}

class Test{
    public static void main(String[] args) {
        System.out.println(TestEnum.getTestEnum(1));
    }
}
