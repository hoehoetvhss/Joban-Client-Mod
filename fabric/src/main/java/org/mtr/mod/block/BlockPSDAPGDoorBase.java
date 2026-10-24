package org.mtr.mod.block;

import org.mtr.mapping.holder.BlockEntityType;
import org.mtr.mapping.holder.BlockPos;
import org.mtr.mapping.holder.BlockSettings;
import org.mtr.mapping.holder.BlockState;
import org.mtr.mapping.holder.BooleanProperty;
import org.mtr.mapping.mapper.BlockEntityExtension;
import org.mtr.mapping.mapper.BlockWithEntity;

public abstract class BlockPSDAPGDoorBase extends BlockPSDAPGBase implements BlockWithEntity {
    public static final BooleanProperty END = BooleanProperty.of("end");
    public static final BooleanProperty UNLOCKED = BooleanProperty.of("unlocked");

    public BlockPSDAPGDoorBase(BlockSettings settings) {
        super(settings);
    }

    public BlockPSDAPGDoorBase() {
        super();
    }

    public static abstract class BlockEntityBase extends BlockEntityExtension {
        private double doorValue = 0.0;

        public BlockEntityBase(BlockEntityType<?> type, BlockPos pos, BlockState state) {
            super(type, pos, state);
        }

        public double getDoorValue() {
            return doorValue;
        }

        public void setDoorValue(double doorValue) {
            this.doorValue = doorValue;
        }

        public void tick(float tickDelta) {
        }
    }
}
