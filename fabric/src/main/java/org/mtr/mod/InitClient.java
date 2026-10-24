package org.mtr.mod;

import org.mtr.core.data.Depot;
import org.mtr.core.data.Platform;
import org.mtr.core.data.Position;
import org.mtr.core.data.Station;
import org.mtr.mapping.holder.BlockPos;
import org.mtr.mod.client.MinecraftClientData;

import java.util.function.Consumer;

public class InitClient {
    public static Station findStation(BlockPos blockPos) {
        if(MinecraftClientData.getInstance() == null || MinecraftClientData.getInstance().stations == null) return null;
        Position pos = new Position(blockPos.getX(), blockPos.getY(), blockPos.getZ());
        for(Station s : MinecraftClientData.getInstance().stations) {
            if(s.inArea(pos)) return s;
        }
        return null;
    }

    public static Depot findDepot(BlockPos blockPos) {
        if(MinecraftClientData.getInstance() == null || MinecraftClientData.getInstance().depots == null) return null;
        Position pos = new Position(blockPos.getX(), blockPos.getY(), blockPos.getZ());
        for(Depot d : MinecraftClientData.getInstance().depots) {
            if(d.inArea(pos)) return d;
        }
        return null;
    }

    public static void findClosePlatform(BlockPos blockPos, int radius, Consumer<Platform> callback) {
        if(MinecraftClientData.getInstance() == null || MinecraftClientData.getInstance().platforms == null) return;
        Position pos = new Position(blockPos.getX(), blockPos.getY(), blockPos.getZ());
        for(Platform p : MinecraftClientData.getInstance().platforms) {
            if(p.closeTo(pos, radius)) {
                callback.accept(p);
            }
        }
    }

    public static int getStationColor(BlockPos blockPos) {
        Station s = findStation(blockPos);
        return s != null ? (int)s.getColor() : 0;
    }

    public static double getGameTick() {
        return (System.currentTimeMillis() % 86400000L) / 50.0;
    }
}
