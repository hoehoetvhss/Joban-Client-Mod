package org.mtr.mod.render;

import org.mtr.mapping.mapper.BlockEntityExtension;
import org.mtr.mapping.mapper.BlockEntityRenderer;
import org.mtr.mapping.mapper.GraphicsHolder;

public abstract class RenderSignalLight2Aspect<T extends BlockEntityExtension> extends BlockEntityRenderer<T> {
    public RenderSignalLight2Aspect(Argument dispatcher, boolean redOnTop, int proceedColor) {
        super(dispatcher);
    }

    @Override
    public void render(T entity, float tickDelta, GraphicsHolder graphicsHolder, int light, int overlay) {
        if (entity instanceof org.mtr.mod.block.BlockSignalBase.BlockEntityBase) {
            org.mtr.mod.block.BlockSignalBase.BlockEntityBase signalBlockEntity = (org.mtr.mod.block.BlockSignalBase.BlockEntityBase) entity;
            StoredMatrixTransformations t = new StoredMatrixTransformations(0.5 + signalBlockEntity.getPos2().getX(), signalBlockEntity.getPos2().getY(), 0.5 + signalBlockEntity.getPos2().getZ());
            render(t, signalBlockEntity, tickDelta, 0, false);
        }
    }

    protected abstract void render(StoredMatrixTransformations t, org.mtr.mod.block.BlockSignalBase.BlockEntityBase signalBlockEntity, float v, int occupiedAspect, boolean isBackSide);
}
