package dev.jkit.weave.dom;

public class TextNode extends Node {
    private final String text;

    public TextNode(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String getTagName() {
        return "#text";
    }

    @Override
    public String toHtml() {
        return text;
    }
}
