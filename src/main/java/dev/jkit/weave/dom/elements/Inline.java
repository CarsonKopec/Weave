package dev.jkit.weave.dom.elements;

import dev.jkit.weave.dom.ElementNode;

public class Inline {
    public static class ANode extends ElementNode { public ANode() {
        super("a");
        setAttribute("href", null);
        setAttribute("target", null);
        setAttribute("download", null);
        setAttribute("ping", null);
        setAttribute("rel", null);
        setAttribute("hreflang", null);
        setAttribute("type", null);
        setAttribute("referrerpolicy", null);}

        @Override public String toHtml() { return "<a " + getAttributes().toHtml() + ">"; }}

    public static class BrNode extends ElementNode {
        public BrNode() { super("br"); }
        @Override public String toHtml() { return "<br />"; }
    }

    public static class HrNode extends ElementNode {
        public HrNode() {
            super("hr");
            setAttribute("color", null);
            setAttribute("width", null);
            setAttribute("size", null);
            setAttribute("align", null);
            setAttribute("noshade", null);}
        @Override public String toHtml() { return "<hr />"; }
    }

    public static class ImgNode extends ElementNode {
        public ImgNode() {
            super("img");
            setAttribute("src", null);
            setAttribute("alt", null);
            setAttribute("width", null);
            setAttribute("height", null);}
        @Override public String toHtml() { return "<img " + getAttributes().toHtml() + " />"; }
    }

    public static class CodeNode extends ElementNode { public CodeNode() { super("code"); } }
    public static class MapNode extends ElementNode { public MapNode() {
        super("map");
        setAttribute("name", null);}
        @Override public String toHtml() { return "<map " + getAttributes().toHtml() + " >"; }
    }
    public static class AreaNode extends ElementNode { public AreaNode() {
        super("area");
        setAttribute("alt", null);
        setAttribute("coords", null);
        setAttribute("shape", null);
        setAttribute("href", null);
        setAttribute("target", null);
        setAttribute("download", null);
        setAttribute("ping", null);
        setAttribute("rel", null);
        setAttribute("referrerpolicy", null);
        setAttribute("nohref", null);
        setAttribute("type", null);}
        @Override public String toHtml() { return "<area " + getAttributes().toHtml() + " >"; }
    }
}
