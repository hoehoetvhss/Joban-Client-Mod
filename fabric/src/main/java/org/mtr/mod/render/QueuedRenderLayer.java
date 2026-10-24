package org.mtr.mod.render;

public enum QueuedRenderLayer {
    LIGHT(org.mtr.render.QueuedRenderLayer.LIGHT),
    INTERIOR(org.mtr.render.QueuedRenderLayer.INTERIOR),
    EXTERIOR(org.mtr.render.QueuedRenderLayer.EXTERIOR),
    LIGHT_TRANSLUCENT(org.mtr.render.QueuedRenderLayer.LIGHT_TRANSLUCENT),
    INTERIOR_TRANSLUCENT(org.mtr.render.QueuedRenderLayer.INTERIOR_TRANSLUCENT),
    EXTERIOR_TRANSLUCENT(org.mtr.render.QueuedRenderLayer.EXTERIOR_TRANSLUCENT),
    LIGHT_2(org.mtr.render.QueuedRenderLayer.LIGHT_2),
    LINES(org.mtr.render.QueuedRenderLayer.LINES),
    TEXT(org.mtr.render.QueuedRenderLayer.LIGHT);

    public final org.mtr.render.QueuedRenderLayer mtrLayer;

    QueuedRenderLayer(org.mtr.render.QueuedRenderLayer mtrLayer) {
        this.mtrLayer = mtrLayer;
    }
}
