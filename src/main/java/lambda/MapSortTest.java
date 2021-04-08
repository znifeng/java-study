package lambda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSortTest {
    public static void main(String[] args){
        List<Map<String, String>> allMaps = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("name","dani");
        map1.put("gmt_modified", "2021-03-31 07:11:16");

        Map<String, String> map2 = new HashMap<>();
        map2.put("name","cy");
        map2.put("gmt_modified", "2022-03-31 07:11:16");

        Map<String, String> map3 = new HashMap<>();
        map3.put("name","dongdong");
        map3.put("gmt_modified", "2023-03-31 07:11:16");

        allMaps.add(map1);
        allMaps.add(map2);
        allMaps.add(map3);

        List<Map<String, String>> collect = allMaps.stream().sorted(new Comparator<Map<String, String>>() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            @Override
            public int compare(Map<String, String> o1, Map<String, String> o2) {
                try {
                    Date time1 = sdf.parse(o1.get("gmt_modified"));
                    Date time2 = sdf.parse(o2.get("gmt_modified"));
                    return time1.compareTo(time2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return 0;
            }
        }.reversed()).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(allMaps);
    }
}
