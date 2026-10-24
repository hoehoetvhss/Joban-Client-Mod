package org.mtr.mod.render;

import org.mtr.mapping.holder.Vector3d;
import org.mtr.mapping.mapper.GraphicsHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class StoredMatrixTransformations {
    private final List<Consumer<GraphicsHolder>> transformations = new ArrayList<>();
    private final double x;
    private final double y;
    private final double z;

    public StoredMatrixTransformations(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public StoredMatrixTransformations() {
        this(0, 0, 0);
    }

    public void add(Consumer<GraphicsHolder> transformation) {
        transformations.add(transformation);
    }

    public void transform(GraphicsHolder graphicsHolder, Vector3d offset) {
        graphicsHolder.push();
        graphicsHolder.translate(x - offset.getXMapped(), y - offset.getYMapped(), z - offset.getZMapped());
        for (Consumer<GraphicsHolder> transformation : transformations) {
            transformation.accept(graphicsHolder);
        }
    }

    public StoredMatrixTransformations copy() {
        StoredMatrixTransformations copy = new StoredMatrixTransformations(x, y, z);
        copy.transformations.addAll(transformations);
        return copy;
    }
}
