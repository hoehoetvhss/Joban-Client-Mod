package org.mtr.mod.block;

import org.mtr.mapping.holder.*;

public abstract class BlockPSDAPGGlassEndBase extends BlockPSDAPGGlassBase {
    public static final EnumProperty<EnumPSDAPGGlassEndSide> TOUCHING_LEFT = EnumProperty.of("touching_left", EnumPSDAPGGlassEndSide.class);
    public static final EnumProperty<EnumPSDAPGGlassEndSide> TOUCHING_RIGHT = EnumProperty.of("touching_right", EnumPSDAPGGlassEndSide.class);

    public BlockPSDAPGGlassEndBase(BlockSettings settings) {
        super(settings);
    }

    public BlockPSDAPGGlassEndBase() {
        super();
    }

    public static VoxelShape getEndOutlineShape(VoxelShape shape, BlockState state, int left, int right, boolean isLeft, boolean isRight) {
        return shape;
    }

    public enum EnumPSDAPGGlassEndSide implements StringIdentifiable {
        NONE("none"), AIR("air"), CLOSED("closed");
        private final String name;
        EnumPSDAPGGlassEndSide(String name) { this.name = name; }
        @Override
        public String asString2() { return name; }
    }
}
