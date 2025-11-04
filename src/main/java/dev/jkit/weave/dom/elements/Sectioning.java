package dev.jkit.weave.dom.elements;

import dev.jkit.weave.dom.ElementNode;

public class Sectioning {
    public static class HeaderNode extends ElementNode {
        public HeaderNode() { super("header"); }
    }

    public static class FooterNode extends ElementNode {
        public FooterNode() { super("footer"); }
    }

    public static class NavNode extends ElementNode {
        public NavNode() { super("nav"); }
    }

    public static class SectionNode extends ElementNode {
        public SectionNode() { super("section"); }
    }

    public static class MainNode extends ElementNode {
        public MainNode() { super("main"); }
    }

    public static class ArticleNode extends ElementNode {
        public ArticleNode() { super("artical"); }
    }

    public static class AsideNode extends ElementNode {
        public AsideNode() { super("aside"); }
    }
}
