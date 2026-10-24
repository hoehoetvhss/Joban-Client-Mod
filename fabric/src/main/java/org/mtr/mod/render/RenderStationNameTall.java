package org.mtr.mod.render;

import org.mtr.mapping.mapper.BlockEntityExtension;
import org.mtr.mapping.mapper.BlockEntityRenderer;
import org.mtr.mapping.mapper.GraphicsHolder;

public abstract class RenderStationNameTall<T extends BlockEntityExtension> extends BlockEntityRenderer<T> {
    public RenderStationNameTall(Argument dispatcher, float width, float height, float offsetY) {
        super(dispatcher);
    }

    @Override
    public void render(T entity, float tickDelta, GraphicsHolder graphicsHolder, int light, int overlay) {
    }
}
