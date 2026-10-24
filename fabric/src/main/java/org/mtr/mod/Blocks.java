package org.mtr.mod;

import net.minecraft.block.AbstractBlock;
import org.mtr.mapping.holder.Block;
import org.mtr.mapping.holder.BlockSettings;
import org.mtr.mapping.holder.BlockState;
import org.mtr.mapping.registry.BlockRegistryObject;

import java.lang.reflect.Constructor;
import java.util.function.ToIntFunction;

public final class Blocks {
    private static BlockRegistryObject wrap(net.minecraft.block.Block block) {
        try {
            Constructor<BlockRegistryObject> c = BlockRegistryObject.class.getDeclaredConstructor(Block.class);
            c.setAccessible(true);
            return c.newInstance(new Block(block));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static final BlockRegistryObject GLASS_FENCE_CIO = wrap(org.mtr.registry.Blocks.GLASS_FENCE_CIO.get());
    public static final BlockRegistryObject GLASS_FENCE_CKT = wrap(org.mtr.registry.Blocks.GLASS_FENCE_CKT.get());
    public static final BlockRegistryObject GLASS_FENCE_HEO = wrap(org.mtr.registry.Blocks.GLASS_FENCE_HEO.get());
    public static final BlockRegistryObject GLASS_FENCE_MOS = wrap(org.mtr.registry.Blocks.GLASS_FENCE_MOS.get());
    public static final BlockRegistryObject GLASS_FENCE_PLAIN = wrap(org.mtr.registry.Blocks.GLASS_FENCE_PLAIN.get());
    public static final BlockRegistryObject GLASS_FENCE_SHM = wrap(org.mtr.registry.Blocks.GLASS_FENCE_SHM.get());
    public static final BlockRegistryObject GLASS_FENCE_STAINED = wrap(org.mtr.registry.Blocks.GLASS_FENCE_STAINED.get());
    public static final BlockRegistryObject GLASS_FENCE_STW = wrap(org.mtr.registry.Blocks.GLASS_FENCE_STW.get());
    public static final BlockRegistryObject GLASS_FENCE_TSH = wrap(org.mtr.registry.Blocks.GLASS_FENCE_TSH.get());
    public static final BlockRegistryObject GLASS_FENCE_WKS = wrap(org.mtr.registry.Blocks.GLASS_FENCE_WKS.get());
    public static final BlockRegistryObject STATION_NAME_TALL_STANDING = wrap(org.mtr.registry.Blocks.STATION_NAME_TALL_STANDING.get());

    public static BlockSettings createDefaultBlockSettings(boolean requireTool) {
        AbstractBlock.Settings settings = AbstractBlock.Settings.create();
        if(requireTool) {
            settings.requiresTool();
        }
        return new BlockSettings(settings);
    }

    public static BlockSettings createDefaultBlockSettings(boolean requireTool, ToIntFunction<BlockState> lightLevel) {
        AbstractBlock.Settings settings = AbstractBlock.Settings.create()
                .luminance(state -> lightLevel.applyAsInt(new BlockState(state)));
        if(requireTool) {
            settings.requiresTool();
        }
        return new BlockSettings(settings);
    }
}
