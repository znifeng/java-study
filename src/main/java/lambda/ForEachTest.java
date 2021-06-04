package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ForEachTest {
    public static void main(String[] args) {
        List<String> PID_MONITOR_TO_DIAGNOSE = Arrays.asList(
            "/custom/6/product/preview/multiMinute/4749",
            "/custom/6/product/preview/multiMinute/5010",
            "/custom/6/product/preview/multiMinute/5010"
        );

        PID_MONITOR_TO_DIAGNOSE.forEach(x ->{
            String prefix = "http:/";
            System.out.println(prefix + x);
        });
    }
}
