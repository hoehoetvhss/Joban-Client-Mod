package com.lx862.jcm.mod.resource;

import org.mtr.mapping.holder.Identifier;
import org.mtr.mod.resource.OptimizedModelWrapper;

import java.util.*;

public class ComplexModelStorage {
    private static final Map<Identifier, OptimizedModelWrapper> models = new HashMap<>();
    private static final Set<Identifier> modelToLoad = new HashSet<>();

    public static void requireModel(Identifier identifier) {
        modelToLoad.add(identifier);
    }

    public static OptimizedModelWrapper getModel(Identifier identifier) {
        return models.get(identifier);
    }

    public static void beginReload() {
    }

    public static void reset() {
        models.clear();
    }
}
