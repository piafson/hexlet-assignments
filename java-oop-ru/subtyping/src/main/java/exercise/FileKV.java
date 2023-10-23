package exercise;

import java.util.HashMap;
import java.util.Map;

public class FileKV implements KeyValueStorage {
    private String filePath;
    private Map<String, String> storage;

    public FileKV(String filePath, Map<String, String> map) {
        this.filePath = filePath;
        this.storage = new HashMap<>(map);
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void writeToFile() {
        Utils.writeFile(filePath, Utils.serialize(storage));
    }

    public void readFile() {
        storage = Utils.unserialize(Utils.readFile(filePath));
    }

    @Override
    public void set(String key, String value)  {
        this.storage.put(key, value);
    }

    @Override
    public void unset(String key)  {
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

