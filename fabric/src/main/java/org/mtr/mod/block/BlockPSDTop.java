package org.mtr.mod.block;

import org.mtr.mapping.holder.BlockEntityType;
import org.mtr.mapping.holder.BlockPos;
import org.mtr.mapping.holder.BlockSettings;
import org.mtr.mapping.holder.BlockState;
import org.mtr.mapping.holder.WorldAccess;
import org.mtr.mapping.mapper.BlockEntityExtension;
import org.mtr.mapping.mapper.BlockExtension;
import org.mtr.mod.Blocks;

public class BlockPSDTop extends BlockExtension {
    public BlockPSDTop(BlockSettings settings) {
        super(settings);
    }

    public BlockPSDTop() {
        super(Blocks.createDefaultBlockSettings(true));
    }

    public static BlockState getActualState(WorldAccess world, BlockPos pos) {
        return world.getBlockState(pos);
    }

    public static abstract class BlockEntityBase extends BlockEntityExtension {
        public BlockEntityBase(BlockEntityType<?> type, BlockPos pos, BlockState state) {
            super(type, pos, state);
        }
    }
}
