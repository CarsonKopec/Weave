package dev.jkit.weave.dom;

import dev.jkit.weave.util.AttributeMap;

import java.util.Set;

public class ElementNode extends Node {
    protected final String tagName;
    protected final AttributeMap attributes = new AttributeMap();

    public static final Set<String> GLOBAL_ATTRIBUTES = Set.of(
            "id", "class", "style", "title", "lang", "dir",
            "hidden", "tabindex", "draggable", "accesskey", "data-*"
    );

    public ElementNode(String tagName) {
        this.tagName = tagName.toLowerCase();
        initializeDefaults();
    }


    protected void initializeDefaults() {
        addDefaults();
    }

    protected void addDefaults() {
        // Example in subclasses: attributes.putIfAbsent("href", "#");
    }

    @Override
    public String getTagName() {
        return tagName;
    }

    public AttributeMap getAttributes() {
        return attributes;
    }

    public String getAttribute(String key) {
        return attributes.get(key);
    }

    public void setAttribute(String key, String value) {
        attributes.put(key, value);
    }

    public boolean isGlobalAttribute(String key) {
        return key.startsWith("data-") || GLOBAL_ATTRIBUTES.contains(key.toLowerCase());
    }

    protected boolean validateAttribute(String key) {
        return true;
    }

    public void addClass(String className) {
        String existing = attributes.getOrDefault("class", "");
        if (!existing.isEmpty()) existing += " ";
        attributes.put("class", existing + className);
    }

    public void setStyle(String key, String value) {
        String style = attributes.getOrDefault("style", "");
        if (!style.isEmpty() && !style.endsWith(";")) style += "; ";
        attributes.put("style", style + key + ":" + value + ";");
    }

    @Override
    public String toHtml() {
        StringBuilder html = new StringBuilder();
        html.append("<").append(tagName);

        if (!attributes.isEmpty()) {
            html.append(" ").append(attributes.toHtml());
        }

        if (isSelfClosing()) {
            html.append(" />");
            return html.toString();
        }

        html.append(">");

        for (Node child : children) {
            html.append(child.toHtml());
        }

        html.append("</").append(tagName).append(">");
        return html.toString();
    }


    protected boolean isSelfClosing() {
        return Set.of(
                "br", "hr", "img", "meta", "link", "input",
                "source", "track", "area", "base", "col", "embed", "param", "wbr"
        ).contains(tagName);
    }
}