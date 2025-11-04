package dev.jkit.weave.dom;

import java.util.Set;

public final class GlobalAttributes {
    private GlobalAttributes() {}

    public static final Set<String> GLOBAL = Set.of(
            "id", "class", "style", "title", "hidden", "lang", "dir",
            "accesskey", "draggable", "tabindex", "translate", "data-*"
    );

    public static boolean isGlobal(String attr) {
        if (attr.startsWith("data-")) return true;
        return GLOBAL.contains(attr.toLowerCase());
    }
}
