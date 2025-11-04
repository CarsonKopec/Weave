package dev.jkit.weave.parser;

import dev.jkit.weave.dom.ElementNode;
import dev.jkit.weave.dom.elements.*;

import java.util.HashMap;
import java.util.Map;

import static dev.jkit.weave.dom.ElementNode.GLOBAL_ATTRIBUTES;

public class NodeFactory {
    private static final Map<String, Class<? extends ElementNode>> TAG_MAP = new HashMap<>();

    static {
        // --- Document structure ---
        TAG_MAP.put("html", Document.HtmlTagNode.class);
        TAG_MAP.put("base", Metadata.BaseNode.class);
        TAG_MAP.put("head", Document.HeadNode.class);
        TAG_MAP.put("body", Document.BodyNode.class);
        TAG_MAP.put("title", Document.TitleNode.class);
        TAG_MAP.put("meta", Metadata.MetaNode.class);
        TAG_MAP.put("link", Metadata.LinkNode.class);
        TAG_MAP.put("style", Metadata.StyleNode.class);
        TAG_MAP.put("script", Scripting.ScriptNode.class);
        TAG_MAP.put("noscript", Scripting.NoscriptNode.class);

        // --- Sections & semantic grouping ---
        TAG_MAP.put("header", Sectioning.HeaderNode.class);
        TAG_MAP.put("footer", Sectioning.FooterNode.class);
        TAG_MAP.put("main", Sectioning.MainNode.class);
        TAG_MAP.put("article", Sectioning.ArticleNode.class);
        TAG_MAP.put("section", Sectioning.SectionNode.class);
        TAG_MAP.put("nav", Sectioning.NavNode.class);
        TAG_MAP.put("aside", Sectioning.AsideNode.class);

        // --- Text content ---
        TAG_MAP.put("div", Grouping.DivNode.class);
        TAG_MAP.put("span", Text.SpanNode.class);
        TAG_MAP.put("p", Text.PNode.class);
        TAG_MAP.put("h1", Text.H1Node.class);
        TAG_MAP.put("h2", Text.H2Node.class);
        TAG_MAP.put("h3", Text.H3Node.class);
        TAG_MAP.put("h4", Text.H4Node.class);
        TAG_MAP.put("h5", Text.H5Node.class);
        TAG_MAP.put("h6", Text.H6Node.class);
        TAG_MAP.put("strong", Text.StrongNode.class);
        TAG_MAP.put("em", Text.EmNode.class);
        TAG_MAP.put("b", Text.BNode.class);
        TAG_MAP.put("i", Text.INode.class);
        TAG_MAP.put("u", Text.UNode.class);
        TAG_MAP.put("small", Text.SmallNode.class);
        TAG_MAP.put("mark", Text.MarkNode.class);
        TAG_MAP.put("blockquote", Grouping.BlockquoteNode.class);
        TAG_MAP.put("code", Inline.CodeNode.class);
        TAG_MAP.put("pre", Grouping.PreNode.class);
        TAG_MAP.put("br", Inline.BrNode.class);
        TAG_MAP.put("hr", Inline.HrNode.class);

        // --- Lists ---
        TAG_MAP.put("ul", Grouping.UlNode.class);
        TAG_MAP.put("ol", Grouping.OlNode.class);
        TAG_MAP.put("li", Grouping.LiNode.class);
        TAG_MAP.put("dl", Grouping.DlNode.class);
        TAG_MAP.put("dt", Grouping.DtNode.class);
        TAG_MAP.put("dd", Grouping.DdNode.class);

        // --- Tables ---
        TAG_MAP.put("table", Table.TableNode.class);
        TAG_MAP.put("thead", Table.TheadNode.class);
        TAG_MAP.put("tbody", Table.TbodyNode.class);
        TAG_MAP.put("tfoot", Table.TfootNode.class);
        TAG_MAP.put("tr", Table.TrNode.class);
        TAG_MAP.put("th", Table.ThNode.class);
        TAG_MAP.put("td", Table.TdNode.class);
        TAG_MAP.put("caption", Table.CaptionNode.class);
        TAG_MAP.put("colgroup", Table.ColGroupNode.class);
        TAG_MAP.put("col", Table.ColNode.class);

        // --- Forms ---
        TAG_MAP.put("form", Form.FormNode.class);
        TAG_MAP.put("input", Form.InputNode.class);
        TAG_MAP.put("textarea", Form.TextAreaNode.class);
        TAG_MAP.put("button", Form.ButtonNode.class);
        TAG_MAP.put("label", Form.LabelNode.class);
        TAG_MAP.put("select", Form.SelectNode.class);
        TAG_MAP.put("option", Form.OptionNode.class);
        TAG_MAP.put("fieldset", Form.FieldsetNode.class);
        TAG_MAP.put("legend", Form.LegendNode.class);

        // --- Media & embedded content ---
        TAG_MAP.put("img", Inline.ImgNode.class);
        TAG_MAP.put("video", Media.VideoNode.class);
        TAG_MAP.put("audio", Media.AudioNode.class);
        TAG_MAP.put("source", Media.SourceNode.class);
        TAG_MAP.put("track", Media.TrackNode.class);
        TAG_MAP.put("canvas", Media.CanvasNode.class);
        TAG_MAP.put("svg", Media.SvgNode.class);
        TAG_MAP.put("iframe", Media.IframeNode.class);
        TAG_MAP.put("object", Media.ObjectNode.class);
        TAG_MAP.put("embed", Media.EmbedNode.class);

        // --- Links ---
        TAG_MAP.put("a", Inline.ANode.class);
        TAG_MAP.put("area", Inline.AreaNode.class);
        TAG_MAP.put("map", Inline.MapNode.class);

        // --- Misc ---
        TAG_MAP.put("details", Misc.DetailsNode.class);
        TAG_MAP.put("summary", Misc.SummaryNode.class);
        TAG_MAP.put("dialog", Misc.DialogNode.class);
        TAG_MAP.put("template", Scripting.TemplateNode.class);
        TAG_MAP.put("slot", Misc.SlotNode.class);
    }

    public static ElementNode createElement(String tag) {
        try {
            Class<? extends ElementNode> clazz = TAG_MAP.get(tag.toLowerCase());
            ElementNode node = (clazz != null)
                    ? clazz.getDeclaredConstructor().newInstance()
                    : new ElementNode(tag);

            initializeDefaultAttributes(node);

            return node;
        } catch (Exception e) {
            throw new RuntimeException("Could not create node for tag: " + tag, e);
        }
    }

    private static void initializeDefaultAttributes(ElementNode node) {
        for (String attr : GLOBAL_ATTRIBUTES) {
            if (!attr.endsWith("*")) {
                node.setAttribute(attr, null);
            }
        }
    }
}