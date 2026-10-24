package org.mtr.mapping.mapper;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.*;
import net.minecraft.util.Identifier;
import org.joml.Matrix4f;
import org.mtr.mapping.tool.ColorHelper;
import org.mtr.mapping.tool.DummyClass;

public final class GuiDrawing extends DummyClass {
    private VertexConsumer vertexConsumer;
    private DrawContext drawContext;
    private BufferBuilder bufferBuilder;
    private Matrix4f matrix;
    private final GraphicsHolder graphicsHolder;

    public GuiDrawing(GraphicsHolder graphicsHolder) {
        this.graphicsHolder = graphicsHolder;
    }

    public void beginDrawingRectangle() {
        this.matrix = graphicsHolder.matrixStack == null ? null : graphicsHolder.matrixStack.peek().getPositionMatrix();
        this.vertexConsumer = graphicsHolder.vertexConsumerProvider == null ? null : graphicsHolder.vertexConsumerProvider.getBuffer(RenderLayer.getGui());
        this.drawContext = graphicsHolder.drawContext;
    }

    public void drawRectangle(double x1, double y1, double x2, double y2, int color) {
        if (matrix != null && vertexConsumer != null && drawContext != null) {
            ColorHelper.unpackColor(color, (a, r, g, b) -> {
                vertexConsumer.vertex(matrix, (float) x1, (float) y1, 0.0f).color(r, g, b, a);
                vertexConsumer.vertex(matrix, (float) x1, (float) y2, 0.0f).color(r, g, b, a);
                vertexConsumer.vertex(matrix, (float) x2, (float) y2, 0.0f).color(r, g, b, a);
                vertexConsumer.vertex(matrix, (float) x2, (float) y1, 0.0f).color(r, g, b, a);
            });
        }
    }

    public void drawRectangle(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, int color) {
        if (matrix != null && vertexConsumer != null && drawContext != null) {
            ColorHelper.unpackColor(color, (a, r, g, b) -> {
                vertexConsumer.vertex(matrix, (float) x1, (float) y1, 0.0f).color(r, g, b, a);
                vertexConsumer.vertex(matrix, (float) x2, (float) y2, 0.0f).color(r, g, b, a);
                vertexConsumer.vertex(matrix, (float) x3, (float) y3, 0.0f).color(r, g, b, a);
                vertexConsumer.vertex(matrix, (float) x4, (float) y4, 0.0f).color(r, g, b, a);
            });
        }
    }

    public void finishDrawingRectangle() {
        if (matrix != null && vertexConsumer != null && drawContext != null) {
            drawContext.draw();
        }
    }

    public void beginDrawingTexture(org.mtr.mapping.holder.Identifier identifier) {
        this.matrix = graphicsHolder.matrixStack == null ? null : graphicsHolder.matrixStack.peek().getPositionMatrix();
        Identifier id = (Identifier) identifier.data;
        RenderSystem.setShaderTexture(0, id);
        RenderSystem.enableDepthTest();
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        Tessellator tessellator = Tessellator.getInstance();
        this.bufferBuilder = tessellator.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
    }

    public void drawTexture(double x1, double y1, double x2, double y2, float u1, float v1, float u2, float v2) {
        if (matrix != null && bufferBuilder != null) {
            bufferBuilder.vertex(matrix, (float) x1, (float) y1, 0.0f).texture(u1, v1);
            bufferBuilder.vertex(matrix, (float) x1, (float) y2, 0.0f).texture(u1, v2);
            bufferBuilder.vertex(matrix, (float) x2, (float) y2, 0.0f).texture(u2, v2);
            bufferBuilder.vertex(matrix, (float) x2, (float) y1, 0.0f).texture(u2, v1);
        }
    }

    public void finishDrawingTexture() {
        if (bufferBuilder != null) {
            BufferRenderer.drawWithGlobalProgram(bufferBuilder.end());
            this.bufferBuilder = null;
        }
    }
}
