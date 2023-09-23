package exercise;

import java.util.Arrays;

public class App {
    public static String[][] enlargeArrayImage(String[][] inp) {
        if (inp == null) {
            return null;
        }

        String[][] res = new String[inp.length * 2][inp.length * 2];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                res[i][j] = inp[i / 2][j / 2];
            }
        }
        return res;
    }
}
