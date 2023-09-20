package exercise;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static Map getWordCount(String sentence) {
        if (sentence.equals("")) {
            return new HashMap<String, Integer>();
        }
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = sentence.split(" ");
        for (String word : words) {
            Integer oddCount = wordCount.get(word);
            if (oddCount == null) {
                oddCount = 0;
            }
            wordCount.put(word, oddCount + 1);
        }
        return wordCount;
    }

    public static String toString(Map<String, Integer> map) {
        if (map.isEmpty()) {
            return "{}";
        }
        String result = "{\n";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            result = result + "  " + key + ": " + value + "\n";
        }
        result = result + "}";
        return result;
    }
}

