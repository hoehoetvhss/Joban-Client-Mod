package org.mtr.mod.block;

import org.mtr.mapping.holder.BlockSettings;
import org.mtr.mapping.holder.DirectionProperty;
import org.mtr.mapping.holder.EnumProperty;
import org.mtr.mapping.mapper.DirectionHelper;

public abstract class BlockPSDAPGBase extends BlockDirectionalDoubleBlockBase implements IBlock {
    public static final DirectionProperty FACING = DirectionHelper.FACING;
    public static final EnumProperty<EnumSide> SIDE = IBlock.SIDE;

    public BlockPSDAPGBase(BlockSettings settings) {
        super(settings);
    }

    public BlockPSDAPGBase() {
        super();
    }

    public boolean isAPG() {
        return false;
    }
}
