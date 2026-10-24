package com.lx862.amberui.gui.screen;

import com.lx862.amberui.gui.GuiHelper;
import com.lx862.jcm.mod.util.TextCategory;
import com.lx862.jcm.mod.util.TextUtil;
import org.mtr.client.MinecraftClientData;
import org.mtr.core.data.Position;
import org.mtr.core.data.Station;
import org.mtr.data.IGui;
import org.mtr.mapping.holder.BlockPos;
import org.mtr.mapping.holder.MutableText;

/**
 * GUI Screen for configuring block settings, you should extend this class for your own block config screen
 */
public abstract class BlockConfigScreen extends SavableScreen implements GuiHelper {
    protected final BlockPos blockPos;

    public BlockConfigScreen(BlockPos blockPos) {
        super(false);
        this.blockPos = blockPos;
    }

    protected int getContentWidth() {
        return (int)Math.min((width * 0.75), MAX_CONTENT_WIDTH);
    }

    @Override
    public MutableText getScreenSubtitle() {
        Station atStation = null;
        if(MinecraftClientData.getInstance() != null && MinecraftClientData.getInstance().stations != null) {
            Position pos = new Position(blockPos.getX(), blockPos.getY(), blockPos.getZ());
            for(Station s : MinecraftClientData.getInstance().stations) {
                if(s.inArea(pos)) {
                    atStation = s;
                    break;
                }
            }
        }

        if(atStation != null) {
            return TextUtil.translatable(TextCategory.GUI,
                    "block_config.subtitle_with_station",
                    blockPos.getX(), blockPos.getY(), blockPos.getZ(),
                    IGui.formatStationName(atStation.getName())
            );
        } else {
            return TextUtil.translatable(TextCategory.GUI,
                    "block_config.subtitle",
                    blockPos.getX(), blockPos.getY(), blockPos.getZ()
            );
        }
    }
}
