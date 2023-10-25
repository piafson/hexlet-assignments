package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class PairedTag extends Tag {
    private String body;
    private List<Tag> children;

    public PairedTag(String name,
                     Map<String, String> attributes,
                     String body,
                     List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("<" + getName() + super.attrToString() + ">");
        result.append(children.stream()
                .map(String::valueOf)
                .collect(Collectors.joining()) + body);
        result.append("</" + getName() + ">");
        return result.toString();
    }
}

