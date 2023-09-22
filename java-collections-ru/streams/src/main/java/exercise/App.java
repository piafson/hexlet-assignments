package exercise;

import java.util.Arrays;
import java.util.List;

public class App {
    public static long getCountOfFreeEmails(List<String> inp) {
        if (inp != null) {
            return inp.stream()
                .filter(item
                    -> item.matches("(.*)@yandex.ru(.*)")
                        || item.matches("(.*)@gmail.com(.*)")
                        || item.matches("(.*)@hotmail.com(.*)"))
                .count();
        } else {
            return 0;
        }
    }
}
