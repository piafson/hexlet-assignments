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

        data1.forEach((key, value) -> {
            Object d2 = data2.get(key);
            if (d2 != null) {
                if (d2.equals(value)) {
                    res.put(key, "unchanged");
                } else {
                    res.put(key, "changed");
                }
            }
        });

        Set<String> diff1 = new HashSet<>();
        diff1.addAll(data1.keySet());
        diff1.removeAll(data2.keySet());
        diff1.forEach(key -> { res.put(key, "deleted"); });

        Set<String> diff2 = new HashSet<>();
        diff2.addAll(data2.keySet());
        diff2.removeAll(data1.keySet());
        diff2.forEach(key -> { res.put(key, "added"); });

        return res;
    }
}


