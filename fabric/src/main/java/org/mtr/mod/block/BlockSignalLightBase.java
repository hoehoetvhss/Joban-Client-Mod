package org.mtr.mod.block;

import org.mtr.mapping.holder.BlockSettings;

public abstract class BlockSignalLightBase extends BlockSignalBase {
    public BlockSignalLightBase(BlockSettings settings, int shapeX, int shapeHeight) {
        super(settings);
    }

    public BlockSignalLightBase(BlockSettings settings, int shapeX) {
        super(settings);
    }
}
