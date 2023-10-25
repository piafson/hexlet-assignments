package exercise;

import java.util.stream.Collectors;
import java.util.Map;

public class Tag {
    private String name;
    private Map<String, String> attributes;

    public Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public String attrToString() {
        StringBuilder mapAsString = new StringBuilder();
        for (String key : getAttributes().keySet()) {
            mapAsString.append(" " + key).append("=\"")
                    .append(getAttributes().get(key)).append("\"");
        }
        return mapAsString.toString();
    }
}
