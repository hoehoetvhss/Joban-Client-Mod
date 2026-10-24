package org.mtr.mod.block;

import org.mtr.mapping.holder.*;
import org.mtr.mapping.mapper.BlockEntityExtension;
import org.mtr.mapping.mapper.BlockExtension;
import org.mtr.mapping.mapper.BlockWithEntity;
import org.mtr.mapping.mapper.DirectionHelper;
import org.mtr.mod.Blocks;

public abstract class BlockSignalBase extends BlockExtension implements DirectionHelper, BlockWithEntity {
    public static final DirectionProperty FACING = DirectionHelper.FACING;

    public enum EnumBooleanInverted implements StringIdentifiable {
        FALSE(false), TRUE(true);
        public final boolean booleanValue;
        EnumBooleanInverted(boolean booleanValue) {
            this.booleanValue = booleanValue;
        }
        @Override
        public String asString2() {
            return String.valueOf(booleanValue);
        }
    }

    public static final EnumProperty<EnumBooleanInverted> IS_22_5 = EnumProperty.of("is_22_5", EnumBooleanInverted.class);
    public static final EnumProperty<EnumBooleanInverted> IS_45 = EnumProperty.of("is_45", EnumBooleanInverted.class);

    public BlockSignalBase(BlockSettings settings) {
        super(settings);
    }

    public BlockSignalBase() {
        super(Blocks.createDefaultBlockSettings(true));
    }

    public static abstract class BlockEntityBase extends BlockEntityExtension {
        public final boolean isDoubleSided;

        public BlockEntityBase(BlockEntityType<?> type, boolean isDoubleSided, BlockPos pos, BlockState state) {
            super(type, pos, state);
            this.isDoubleSided = isDoubleSided;
        }
    }
}
