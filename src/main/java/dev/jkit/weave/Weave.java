package dev.jkit.weave;

import dev.jkit.weave.dom.DocumentNode;
import dev.jkit.weave.parser.HtmlParser;

public class Weave {
    public static void main(String[] args) {
        HtmlParser parser = new HtmlParser();

        String html = """
            <!DOCTYPE html>
            <html>
                <head><title>Test</title></head>
                <body>
                    <div class="container">
                        <h1>Hello World!</h1>
                        <p>This is a test paragraph.</p>
                        <img src="logo.png" alt="Logo">
                    </div>
                </body>
            </html>
        """;

        DocumentNode doc = parser.parse(html);

        System.out.println(doc.toHtml());
    }
}
