package org.mtr.mod.render;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import org.mtr.mapping.holder.Identifier;
import org.mtr.mapping.holder.Vector3d;
import org.mtr.mapping.mapper.GraphicsHolder;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.function.BiConsumer;

public class MainRenderer {
    private static final Constructor<GraphicsHolder> GRAPHICS_HOLDER_CONSTRUCTOR;
    private static final Field VERTEX_CONSUMER_FIELD;

    static {
        try {
            GRAPHICS_HOLDER_CONSTRUCTOR = GraphicsHolder.class.getDeclaredConstructor(MatrixStack.class, VertexConsumerProvider.class);
            GRAPHICS_HOLDER_CONSTRUCTOR.setAccessible(true);
            VERTEX_CONSUMER_FIELD = GraphicsHolder.class.getDeclaredField("vertexConsumer");
            VERTEX_CONSUMER_FIELD.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static GraphicsHolder createGraphicsHolder(MatrixStack matrices, VertexConsumer vertexConsumer) {
        try {
            GraphicsHolder holder = GRAPHICS_HOLDER_CONSTRUCTOR.newInstance(matrices, null);
            VERTEX_CONSUMER_FIELD.set(holder, vertexConsumer);
            return holder;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void scheduleRender(QueuedRenderLayer layer, BiConsumer<GraphicsHolder, Vector3d> callback) {
        org.mtr.render.MainRenderer.scheduleRender(layer.mtrLayer, (matrices, vertexConsumer, offset) -> {
            callback.accept(createGraphicsHolder(matrices, vertexConsumer), new Vector3d(offset));
        });
    }

    public static void scheduleRender(Identifier identifier, boolean flag, QueuedRenderLayer layer, BiConsumer<GraphicsHolder, Vector3d> callback) {
        org.mtr.render.MainRenderer.scheduleRender(identifier.data, flag, layer.mtrLayer, (matrices, vertexConsumer, offset) -> {
            callback.accept(createGraphicsHolder(matrices, vertexConsumer), new Vector3d(offset));
        });
    }
}
