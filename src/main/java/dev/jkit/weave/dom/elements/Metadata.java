package dev.jkit.weave.dom.elements;

import dev.jkit.weave.dom.ElementNode;

public class Metadata {
    public static class MetaNode extends ElementNode {
        public MetaNode() { super("meta"); }
        @Override public String toHtml() { return "<meta " + getAttributes().toHtml() + " />"; }
    }

    public static class LinkNode extends ElementNode {
        public LinkNode() { super("link"); }
        @Override public String toHtml() { return "<link " + getAttributes().toHtml() + " />"; }
    }

    public static class StyleNode extends ElementNode { public StyleNode() { super("style"); } }
    public static class BaseNode extends ElementNode {
        public BaseNode() { super("base"); }
        @Override public String toHtml() { return "<base " + getAttributes().toHtml() + " />"; }
    }
}
