package lambda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapTest {
    public static void main(String[] args) {
        List<String> PID_MONITOR_TO_DIAGNOSE = Arrays.asList(
            "/custom/6/product/preview/multiMinute/4749",
            "/custom/6/product/preview/multiMinute/5010",
            "/custom/6/product/preview/multiMinute/5010"
        );

        List<String> formatList = PID_MONITOR_TO_DIAGNOSE.stream().map( x -> "http://" + x).collect(Collectors.toList());
        System.out.println(formatList);

        String ids= "12,34,56";
        List<Long> idsLong = Arrays.stream(ids.split(",")).map(item -> Long.parseLong(item)).collect(Collectors.toList());
        System.out.println(idsLong);
    }
}
