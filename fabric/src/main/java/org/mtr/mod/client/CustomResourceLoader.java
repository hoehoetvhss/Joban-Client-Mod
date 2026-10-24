package org.mtr.mod.client;

public class CustomResourceLoader extends org.mtr.client.CustomResourceLoader {
    public static final OptimizedRendererWrapper OPTIMIZED_RENDERER_WRAPPER = new OptimizedRendererWrapper();

    public static class OptimizedRendererWrapper {
        public void beginReload() {}
        public void finishReload() {}
        public void queue(Object model, org.mtr.mapping.mapper.GraphicsHolder gfxHolder, int light) {}
        public Object getOptimizedRenderer() { return null; }
    }
}
