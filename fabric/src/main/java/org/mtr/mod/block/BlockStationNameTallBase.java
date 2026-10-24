package org.mtr.mod.block;

import org.mtr.mapping.holder.BlockEntityType;
import org.mtr.mapping.holder.BlockPos;
import org.mtr.mapping.holder.BlockSettings;
import org.mtr.mapping.holder.BlockState;
import org.mtr.mapping.mapper.BlockEntityExtension;
import org.mtr.mapping.mapper.BlockExtension;
import org.mtr.mapping.mapper.BlockWithEntity;
import org.mtr.mod.Blocks;

public abstract class BlockStationNameTallBase extends BlockExtension implements BlockWithEntity {
    public BlockStationNameTallBase(BlockSettings settings) {
        super(settings);
    }

    public BlockStationNameTallBase() {
        super(Blocks.createDefaultBlockSettings(true));
    }

    public static class BlockEntityTallBase extends BlockEntityExtension {
        public final float z;
        public final boolean doubleSided;

        public BlockEntityTallBase(BlockEntityType<?> type, BlockPos pos, BlockState state, float z, boolean doubleSided) {
            super(type, pos, state);
            this.z = z;
            this.doubleSided = doubleSided;
        }

        public int getColor(BlockState state) {
            return 0;
        }
    }
}
