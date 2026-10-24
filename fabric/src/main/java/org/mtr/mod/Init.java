package org.mtr.mod;

import org.mtr.core.data.Position;
import org.mtr.mapping.holder.BlockPos;
import org.mtr.mapping.holder.World;

public final class Init {
    public static final String MOD_ID = "mtr";
    public static final String MOD_ID_NTE = "nte";

    public static BlockPos positionToBlockPos(Position position) {
        return new BlockPos((int)position.getX(), (int)position.getY(), (int)position.getZ());
    }

    public static Position blockPosToPosition(BlockPos blockPos) {
        return new Position(blockPos.getX(), blockPos.getY(), blockPos.getZ());
    }

    public static BlockPos newBlockPos(double x, double y, double z) {
        return new BlockPos((int)Math.floor(x), (int)Math.floor(y), (int)Math.floor(z));
    }

    public static String getWorldId(World world) {
        if(world == null || world.data == null) return "";
        return world.data.getRegistryKey().getValue().toString();
    }
}
