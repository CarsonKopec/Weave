package dev.jkit.weave.dom.elements;

import dev.jkit.weave.dom.ElementNode;

public class Form {
    public static class FormNode extends ElementNode { public FormNode() { super("form"); } }
    public static class LabelNode extends ElementNode { public LabelNode() { super("label"); } }
    public static class ButtonNode extends ElementNode { public ButtonNode() { super("button"); } }
    public static class SelectNode extends ElementNode { public SelectNode() { super("select"); } }
    public static class OptionNode extends ElementNode { public OptionNode() { super("option"); } }
    public static class TextAreaNode extends ElementNode { public TextAreaNode() { super("textarea"); } }
    public static class FieldsetNode extends ElementNode { public FieldsetNode() { super("fieldset"); } }
    public static class LegendNode extends ElementNode { public LegendNode() { super("legend"); } }

    public static class InputNode extends ElementNode {
        public InputNode() { super("input"); }
        @Override public String toHtml() { return "<input " + getAttributes().toHtml() + " />"; }
    }
}
