package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static boolean scrabble(String set, String word) {
        if (set.length() < word.length()) {
            return false;
        }
        boolean res = true;
        List<Character> charsSet = new ArrayList<>();
        for (char ch: set.toLowerCase().toCharArray()) {
            charsSet.add(ch);
        }

        for (char ch : word.toLowerCase().toCharArray()) {
            int i = charsSet.indexOf(ch);
            if (i == -1) {
                res = false;
                break;
            } else {
                charsSet.remove(i);
            }
        }
        return res;
    }
}

