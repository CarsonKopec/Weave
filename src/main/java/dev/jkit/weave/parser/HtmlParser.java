package dev.jkit.weave.parser;

import dev.jkit.weave.dom.DocumentNode;
import dev.jkit.weave.dom.ElementNode;
import dev.jkit.weave.dom.Node;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;

import java.io.IOException;

public class HtmlParser {
    public DocumentNode parse(String html) {
        org.jsoup.nodes.Document jsoupDoc = Jsoup.parse(html);
        DocumentNode documentNode = new DocumentNode();

        for (org.jsoup.nodes.Node child : jsoupDoc.childNodes()) {
            Node converted = convertNode(child);
            if (converted != null) {
                documentNode.addChild(converted);
            }
        }
        return documentNode;
    }

    public DocumentNode parseFile(String filePath) throws IOException {
        org.jsoup.nodes.Document jsoupDoc = Jsoup.parse(new java.io.File(filePath), "UTF-8");
        return parse(jsoupDoc.outerHtml());
    }

    private Node convertNode(org.jsoup.nodes.Node node) {
        if (node instanceof org.jsoup.nodes.TextNode textNode) {
            String text = textNode.text();
            if (text.isBlank()) return null;
            return new dev.jkit.weave.dom.TextNode(text);
        }

        if (node instanceof org.jsoup.nodes.Comment comment) {
            return new dev.jkit.weave.dom.CommentNode(comment.getData());
        }

        if (node instanceof org.jsoup.nodes.Element element) {
            ElementNode elNode = NodeFactory.createElement(element.tagName());

            element.attributes().forEach(attr ->
                    elNode.getAttributes().put(attr.getKey(), attr.getValue())
            );

            for (org.jsoup.nodes.Node child : element.childNodes()) {
                Node converted = convertNode(child);
                if (converted != null) {
                    elNode.addChild(converted);
                }
            }

            return elNode;
        }

        return null;
    }
}
