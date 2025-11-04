package dev.jkit.weave.dom.elements;

import dev.jkit.weave.dom.ElementNode;

public class Document {
    public static class HtmlTagNode extends ElementNode { public HtmlTagNode() { super("html"); } }
    public static class HeadNode extends ElementNode { public HeadNode() { super("head"); } }
    public static class BodyNode extends ElementNode { public BodyNode() { super("body"); } }
    public static class TitleNode extends ElementNode { public TitleNode() { super("title"); } }
}
