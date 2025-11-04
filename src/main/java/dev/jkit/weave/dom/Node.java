package dev.jkit.weave.dom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Node {
    protected Node parent;
    protected List<Node> children = new ArrayList<>();

    public Node getParent() {
        return parent;
    }

    public List<Node> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Node node) {
        node.parent = this;
        children.add(node);
    }

    public boolean hasChildren() {
        return !children.isEmpty();
    }


    public abstract String getTagName();

    public abstract String toHtml();
}
