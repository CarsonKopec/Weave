package dev.jkit.weave.dom.elements;

import dev.jkit.weave.dom.ElementNode;

public class Scripting {
    public class ScriptNode extends ElementNode { public ScriptNode() { super("script"); } }
    public class NoscriptNode extends ElementNode { public NoscriptNode() { super("noscript"); } }
    public static class TemplateNode extends ElementNode { public TemplateNode() { super("template"); } }
}
