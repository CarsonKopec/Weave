package dev.jkit.weave.dom.elements;

import dev.jkit.weave.dom.ElementNode;

public class Table {
    public static class TableNode extends ElementNode { public TableNode() { super("table"); } }
    public static class TrNode extends ElementNode { public TrNode() { super("tr"); } }
    public static class TdNode extends ElementNode { public TdNode() { super("td"); } }
    public static class ThNode extends ElementNode { public ThNode() { super("th"); } }
    public static class TheadNode extends ElementNode { public TheadNode() { super("thead"); } }
    public static class TbodyNode extends ElementNode { public TbodyNode() { super("tbody"); } }
    public static class TfootNode extends ElementNode { public TfootNode() { super("tfoot"); } }
    public static class CaptionNode extends ElementNode { public CaptionNode() { super("caption"); } }
    public static class ColGroupNode extends ElementNode { public ColGroupNode() { super("colgroup"); } }
    public static class ColNode extends ElementNode { public ColNode() { super("col"); } }
}
