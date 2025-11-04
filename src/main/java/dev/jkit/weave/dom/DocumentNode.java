package dev.jkit.weave.dom;

public class DocumentNode extends Node {

    @Override
    public String getTagName() {
        return "#document";
    }

    @Override
    public String toHtml() {
        StringBuilder sb = new StringBuilder();
        for (Node child : children) {
            sb.append(child.toHtml());
        }
        return sb.toString();
    }
}
