package org.mtr.mod.block;

import org.mtr.mapping.holder.BlockPos;
import org.mtr.mapping.holder.BlockSettings;
import org.mtr.mapping.holder.BlockState;
import org.mtr.mapping.mapper.BlockEntityExtension;

public class BlockStationNameTallStanding extends BlockStationNameTallBase {
    public static final float WIDTH = 2;
    public static final float HEIGHT = 2;
    public static final float OFFSET_Y = 0;

    public BlockStationNameTallStanding(BlockSettings settings) {
        super(settings);
    }

    public BlockStationNameTallStanding() {
        super();
    }

    @Override
    public BlockEntityExtension createBlockEntity(BlockPos blockPos, BlockState blockState) {
        return null;
    }
}
