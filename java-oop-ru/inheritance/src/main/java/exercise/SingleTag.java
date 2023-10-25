package exercise;

import java.util.Map;

public class SingleTag extends Tag {
    public SingleTag(String name, Map<String, String> attributes) {
        super(name, attributes);
    }

    @Override
    public String toString() {
        String result = "<" + getName() + super.attrToString() + ">";
        return result;
    }
}

