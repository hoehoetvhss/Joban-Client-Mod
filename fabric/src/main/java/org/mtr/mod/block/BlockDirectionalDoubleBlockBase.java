package org.mtr.mod.block;

import org.mtr.mapping.holder.BlockSettings;
import org.mtr.mapping.mapper.BlockExtension;
import org.mtr.mapping.mapper.DirectionHelper;
import org.mtr.mod.Blocks;

public abstract class BlockDirectionalDoubleBlockBase extends BlockExtension implements IBlock, DirectionHelper {
    public BlockDirectionalDoubleBlockBase(BlockSettings settings) {
        super(settings);
    }

    public BlockDirectionalDoubleBlockBase() {
        super(Blocks.createDefaultBlockSettings(true));
    }
}
