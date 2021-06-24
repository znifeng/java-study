package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterTest {
    public static void main(String[] args) {
        final List<String> PID_MONITOR_TO_DIAGNOSE = Arrays.asList(
            "/custom/6/product/preview/multiMinute/4749",
            "/custom/6/product/preview/multiMinute/5010",
            "",
            "/custom/6/product/preview/multiMinute/5010"
        );

        String url = "https://x.wy.com/custom/6/product/preview/multiMinute/5010";
        List<String> filterd = PID_MONITOR_TO_DIAGNOSE.stream().filter(t -> url!=null && url.contains(t)).collect(
            Collectors.toList());
        System.out.println(filterd);
    }
}
