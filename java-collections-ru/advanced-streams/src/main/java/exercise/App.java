package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static String getForwardedVariables(String inp) {
        if (inp.isEmpty()) {
            return "";
        }
        Pattern pattern = Pattern.compile("environment=\"(.*?)\"");
        Pattern pattern1 = Pattern.compile("X_FORWARDED_(.*?),");
        Matcher matcher = pattern.matcher(inp);
        String s = "";
        while (matcher.find()) {
            s= s + matcher.group(1) + ", ";
        }

        Matcher matcher1 = pattern1.matcher(s);
        String res = "";
        while (matcher1.find()) {
            res= res + matcher1.group(1) + ",";
        }
        return res.substring(0, res.length() - 1);
    }
}


