package exercise;

import java.util.Map;
import java.util.Map.Entry;
//import java.util.Set;

public class App {
    public static void main(String[] args) {
        KeyValueStorage storage = new InMemoryKV(Map.of("key", "10"));
        System.out.println(storage.get("key", "default"));
        System.out.println(storage.get("unknown", "default"));
        storage.set("key2", "value2");
        System.out.println(storage.get("key2", "default"));
        storage.unset("key2");
        System.out.println(storage.get("key2", "default"));

        Map<String, String> data = storage.toMap();
        System.out.println(data);

    }

    public static void swapKeyValue(KeyValueStorage inp) {
        for (Map.Entry<String, String> entry : inp.toMap().entrySet()) {
            inp.unset(entry.getKey());
            inp.set(entry.getValue(), entry.getKey());
        }
    }
}

