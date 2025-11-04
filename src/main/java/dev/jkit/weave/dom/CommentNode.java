package dev.jkit.weave.dom;


public class CommentNode extends Node {
    private final String comment;

    public CommentNode(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String getTagName() {
        return "#comment";
    }

    @Override
    public String toHtml() {
        return "<!-- " + comment + " -->";
    }
}
