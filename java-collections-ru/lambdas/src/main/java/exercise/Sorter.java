package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class Sorter {
    public static List takeOldestMans(List<Map<String, String>> inp) {
        return inp.stream()
                .filter(men -> men.get("gender").equals("male"))
                .sorted(Comparator.comparing(men -> men.get("birthday")))
                .map(men -> men.get("name"))
                .collect(Collectors.toList());
    }
}
