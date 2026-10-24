package com.lx862.jcm.mod.extra;

import com.lx862.jcm.mod.config.JCMClientConfig;
import it.unimi.dsi.fastutil.longs.Long2IntArrayMap;
import org.mtr.mapping.holder.*;
import org.mtr.mapping.render.shader.ModShaderHandler;
import org.mtr.mod.resource.CustomResourceTools;

import java.nio.file.FileSystems;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class JCMPatchForMTR {
    private final static int RAIL_CULLING_AREA_LIMIT = Integer.MAX_VALUE / 2;
    private static boolean cachedRenderingShadow = false;
    private static final Long2IntArrayMap liftInstructions = new Long2IntArrayMap();
    public static Identifier LIFT_DING_SOUND = new Identifier("minecraft:block.note_block.pling");
    public static Map<BlockPos, BlockState> cachedRailNodeState = new HashMap<>();
    public static boolean isSitting = false;
    public static boolean wasSneaking = false;

    public static void reloadOptimizedRenderingShader() {
    }

    public static void tick() {
        if(MinecraftClient.getInstance().getPlayerMapped() != null) {
            if(JCMClientConfig.INSTANCE.mtrPatch.allowCameraLowering.value()) {
                boolean isPlayerSneaking = MinecraftClient.getInstance().getPlayerMapped().isSneaking();
                boolean inVehicle = MinecraftClient.getInstance().getPlayerMapped().data.hasVehicle();
                if(!inVehicle) {
                    JCMPatchForMTR.isSitting = false;
                } else {
                    if(isPlayerSneaking && !JCMPatchForMTR.wasSneaking) {
                        JCMPatchForMTR.isSitting = !JCMPatchForMTR.isSitting;
                    }
                }
                JCMPatchForMTR.wasSneaking = isPlayerSneaking;
            }
        }
    }

    public static Identifier resolveRelativePath(String basePath, String resource, String extension) {
        if (resource.contains(":")) {
            return CustomResourceTools.formatIdentifierWithDefault(resource, extension);
        } else {
            Identifier basePathId = new Identifier(basePath);
            String relative = resource.toLowerCase(Locale.ROOT).replace('\\', '/');

            String resolvedPath = FileSystems.getDefault().getPath(basePathId.getPath()).getParent().resolve(relative).toString().replace('\\', '/');
            return new Identifier(basePathId.getNamespace(), resolvedPath);
        }
    }

    public static void setInstruction(long sidingId, int instruction) {
        liftInstructions.put(sidingId, instruction);
    }

    public static int getInstruction(long sidingId) {
        return liftInstructions.getOrDefault(sidingId, -1);
    }

    public static boolean hasInstruction(long sidingId) {
        return liftInstructions.containsKey(sidingId);
    }

    public static void removeInstruction(long sidingId) {
        liftInstructions.remove(sidingId);
    }

    public static boolean liftJustArrived(long liftId, int currentInstructionSize) {
        long lastValue = liftInstructions.getOrDefault(liftId, currentInstructionSize);
        boolean liftJustArrived = currentInstructionSize == 0 && lastValue == 1;
        liftInstructions.put(liftId, currentInstructionSize);
        return liftJustArrived;
    }

    public static void onPreRender() {
        cachedRenderingShadow = ModShaderHandler.renderingShadows();
    }

    public static boolean isRenderingShadow() {
        return cachedRenderingShadow;
    }
}
