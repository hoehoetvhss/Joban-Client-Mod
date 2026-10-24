package org.mtr.mod.render;

import org.mtr.mapping.holder.Identifier;
import org.mtr.mapping.holder.RenderLayer;

public class MoreRenderLayers {
    public static RenderLayer getLight(Identifier id, boolean flag) {
        return new RenderLayer(org.mtr.render.MoreRenderLayers.getLight(id.data, flag));
    }

    public static RenderLayer getLight2(Identifier id) {
        return new RenderLayer(org.mtr.render.MoreRenderLayers.getLight2(id.data));
    }

    public static RenderLayer getInterior(Identifier id) {
        return new RenderLayer(org.mtr.render.MoreRenderLayers.getInterior(id.data));
    }

    public static RenderLayer getExterior(Identifier id) {
        return new RenderLayer(org.mtr.render.MoreRenderLayers.getExterior(id.data));
    }
}
