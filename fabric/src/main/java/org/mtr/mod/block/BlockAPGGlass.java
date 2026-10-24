package org.mtr.mod.block;

import org.mtr.mapping.holder.BlockPos;
import org.mtr.mapping.holder.BlockSettings;
import org.mtr.mapping.holder.BlockState;
import org.mtr.mapping.holder.IntegerProperty;
import org.mtr.mapping.mapper.BlockEntityExtension;
import org.mtr.mapping.mapper.BlockWithEntity;

public class BlockAPGGlass extends BlockPSDAPGGlassBase implements BlockWithEntity {
    public static final IntegerProperty ARROW_DIRECTION = IntegerProperty.of("arrow_direction", 0, 3);

    public BlockAPGGlass(BlockSettings settings) {
        super(settings);
    }

    public BlockAPGGlass() {
        super();
    }

    @Override
    public BlockEntityExtension createBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }
}
