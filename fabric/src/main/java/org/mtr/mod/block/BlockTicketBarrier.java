package org.mtr.mod.block;

import org.mtr.mapping.holder.BlockSettings;
import org.mtr.mapping.holder.DirectionProperty;
import org.mtr.mapping.mapper.BlockExtension;
import org.mtr.mapping.mapper.DirectionHelper;
import org.mtr.mod.Blocks;

public class BlockTicketBarrier extends BlockExtension implements DirectionHelper {
    public static final DirectionProperty FACING = DirectionHelper.FACING;
    public final boolean isEntrance;

    public BlockTicketBarrier(BlockSettings settings, boolean isEntrance) {
        super(settings);
        this.isEntrance = isEntrance;
    }

    public BlockTicketBarrier(boolean isEntrance) {
        super(Blocks.createDefaultBlockSettings(true));
        this.isEntrance = isEntrance;
    }
}
