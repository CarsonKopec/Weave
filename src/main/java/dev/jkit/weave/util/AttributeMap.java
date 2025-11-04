package dev.jkit.weave.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class AttributeMap extends LinkedHashMap<String, String> {
    public String toHtml() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> e : entrySet()) {
            String key = e.getKey();
            String value = e.getValue();

            if (value != null) {
                sb.append(key).append("=\"").append(value).append("\" ");
            }
        }
        return sb.toString().trim();
    }
}
