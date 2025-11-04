package dev.jkit.weave.dom.elements;

import dev.jkit.weave.dom.ElementNode;

public class Media {
    public static class VideoNode extends ElementNode { public VideoNode() { super("video"); } }
    public static class AudioNode extends ElementNode { public AudioNode() { super("audio"); } }
    public static class SourceNode extends ElementNode { public SourceNode() { super("source"); } }
    public static class TrackNode extends ElementNode { public TrackNode() { super("track"); } }
    public static class CanvasNode extends ElementNode { public CanvasNode() { super("canvas"); } }
    public static class SvgNode extends ElementNode { public SvgNode() { super("svg"); } }
    public static class IframeNode extends ElementNode { public IframeNode() { super("iframe"); } }
    public static class ObjectNode extends ElementNode { public ObjectNode() { super("object"); } }
    public static class EmbedNode extends ElementNode { public EmbedNode() { super("embed"); } }
}
