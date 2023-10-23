package exercise;

import java.util.Map;
import java.util.HashMap;

public class InMemoryKV implements KeyValueStorage {
    private Map<String, String> storage;

    public InMemoryKV(Map<String, String> storage) {
        this.storage = new HashMap<>(storage);
    }

    public InMemoryKV() {
        this.storage = new HashMap<>();
    }

    @Override
    public void set(String key, String value) {
        this.storage.put(key, value);
    }

    @Override
    public void unset(String key) {
        this.storage.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        if (storage.get(key) == null) {
            return defaultValue;
        } else {
            return storage.get(key);
        }
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> copy = new HashMap<>(this.storage);
        return copy;
    }
}

