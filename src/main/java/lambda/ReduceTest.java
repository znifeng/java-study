package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class ReduceTest {
    public static void main(String[] args){
        List<String> appList = Arrays.asList(
            "ads-web",
            "p4p-apps",
            "p4pservice"
        );

        String appStr = appList.stream().reduce(new BinaryOperator<String>() {
            @Override
            public String apply(String s, String s2) {
                return s+","+s2;
            }
        }).get();
        System.out.println(appStr);
    }
}
