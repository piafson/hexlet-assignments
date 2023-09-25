package exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class App {
    public static Map<String, String> genDiff(
        Map<String, Object> data1, Map<String, Object> data2) {
        TreeMap<String, String> res = new TreeMap<>();

        for (Map.Entry<String, Object> item : data1.entrySet()) {
            Object d2 = data2.get(item.getKey());
            if (d2 == null) {
                continue;
            }
            if (d2.equals(item.getValue())) {
                System.out.println(item.getKey());
                res.put(item.getKey(), "unchanged");
            } else {
                res.put(item.getKey(), "changed");
            }
        }

        Set<String> diff1 = new HashSet<>();
        diff1.addAll(data1.keySet());
        diff1.removeAll(data2.keySet());

        for (String s : diff1) {
            res.put(s, "deleted");
        }

        Set<String> diff2 = new HashSet<>();
        diff2.addAll(data2.keySet());
        diff2.removeAll(data1.keySet());

        for (String s : diff2) {
            res.put(s, "added");
        }

        return res;
    }
}

