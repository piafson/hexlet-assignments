package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

public class App {
    public static List findWhere(
            List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<>();
        for (Map<String, String> book : books) {
            if (book.entrySet().containsAll(where.entrySet())) {
                result.add(book);
            }
        }
        return result;
    }
}

