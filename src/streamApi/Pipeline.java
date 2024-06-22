package streamApi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Pipeline {

    @Test
    public void testExecuteDetail(){
        IntStream.range(1, 10)
                .peek(x -> System.out.print("\nA" + x))
                .limit(3)
                .peek(x -> System.out.print("B" + x))
                .forEach(x -> System.out.print("C" + x));

/*        IntStream.range(1, 10)
                .peek(x -> System.out.print("\nA" + x))
                .skip(6)
                .peek(x -> System.out.print("B" + x))
                .forEach(x -> System.out.print("C" + x));*/
    }

    /**
     * 特别说明：副作用不应该被滥用，也许你会觉得在Stream.forEach()里进行元素收集是个不错的选择，
     * 就像下面代码中那样，但遗憾的是这样使用的正确性和效率都无法保证，
     * 因为Stream可能会并行执行。大多数使用副作用的地方都可以使用[归约操作]更安全和有效的完成。
     */
    @Test
    public void testSideEffects(){

        String regex = "^[0-9]*$";
        Pattern pattern = Pattern.compile(regex);
        // 错误的收集方式
        // Unnecessary use of side-effects!
        List<String> result = Arrays.asList("a1230", "152", "sss");
        ArrayList<String> collectRes = new ArrayList<>();

        result.stream()
                .filter(s -> pattern.matcher(s).matches())
                .forEach(collectRes::add);
        System.out.println(collectRes);
    
        // 正确的收集方式
        // No side-effects!
        List<String> res = result.stream()
                .filter(s -> pattern.matcher(s).matches())
                .collect(Collectors.toList());
        System.out.println(res);

    }

}
