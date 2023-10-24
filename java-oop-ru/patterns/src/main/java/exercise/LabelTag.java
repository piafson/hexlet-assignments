package exercise;

public class LabelTag implements TagInterface {
    private String text;
    TagInterface children;

    public LabelTag(String text, TagInterface children) {
        this.text = text;
        this.children = children;
    }

    public String getText() {
        return text;
    }

    public TagInterface getChildren() {
        return children;
    }

    @Override
    public String render() {
        return "<label>" + getText() + getChildren().render() + "</label>";
    }
}
