package org.mtr.mod.client;

import org.mtr.mapping.holder.Direction;
import org.mtr.mapping.mapper.GraphicsHolder;

public interface IDrawing extends org.mtr.client.IDrawing {
    static void drawTexture(GraphicsHolder graphicsHolder, float x1, float y1, float z1, float x2, float y2, float z2, Direction facing, int color, int light) {
        drawTexture(graphicsHolder, x1, y1, z1, x2, y2, z2, 0, 0, 1, 1, facing, color, light);
    }

    static void drawTexture(GraphicsHolder graphicsHolder, float x1, float y1, float z1, float x2, float y2, float z2, float u1, float v1, float u2, float v2, Direction facing, int color, int light) {
        drawTexture(graphicsHolder, x1, y1, z1, x2, y1, z2, x2, y2, z2, x1, y2, z1, u1, v1, u2, v2, facing, color, light);
    }

    static void drawTexture(GraphicsHolder graphicsHolder, float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3, float x4, float y4, float z4, float u1, float v1, float u2, float v2, Direction facing, int color, int light) {
        graphicsHolder.drawTextureInWorld(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4, u1, v1, u2, v2, facing, color, light);
    }
}
