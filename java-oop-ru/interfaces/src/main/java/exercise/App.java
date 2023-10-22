package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        CharSequence text = new ReversedSequence("abcdef");
        System.out.println(text.toString());
        System.out.println(text.charAt(1));
        System.out.println(text.length());
        System.out.println(text.subSequence(1, 4).toString());

    }

    public static List<String> buildApartmentsList(List<Home> inp , int n) {
        List<String> res = new ArrayList<>();
        if (inp.size() == 0) {
            return res;
        }
        List<Home> sorted = inp.stream()
                .sorted((o1, o2) -> o1.compareTo(o2))
                .collect(Collectors.toList());
        for (int i = 0; i < n; i++) {
            res.add(sorted.get(i).toString());
        }
        return res;
    }
}
