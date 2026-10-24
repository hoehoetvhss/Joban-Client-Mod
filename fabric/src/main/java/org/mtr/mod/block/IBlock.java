package org.mtr.mod.block;

import org.mtr.mapping.holder.*;

public interface IBlock extends org.mtr.block.IBlock {
    enum DoubleBlockHalf implements StringIdentifiable {
        UPPER("upper"), LOWER("lower");
        private final String name;
        DoubleBlockHalf(String name) { this.name = name; }
        @Override
        public String asString2() { return name; }
    }

    enum EnumThird implements StringIdentifiable {
        LOWER("lower"), MIDDLE("middle"), UPPER("upper");
        private final String name;
        EnumThird(String name) { this.name = name; }
        @Override
        public String asString2() { return name; }
    }

    enum EnumSide implements StringIdentifiable {
        LEFT("left"), RIGHT("right"), SINGLE("single");
        private final String name;
        EnumSide(String name) { this.name = name; }
        @Override
        public String asString2() { return name; }
    }

    EnumProperty<DoubleBlockHalf> HALF = EnumProperty.of("half", DoubleBlockHalf.class);
    EnumProperty<EnumThird> THIRD = EnumProperty.of("third", EnumThird.class);
    EnumProperty<EnumSide> SIDE = EnumProperty.of("side", EnumSide.class);
    EnumProperty<EnumSide> SIDE_EXTENDED = EnumProperty.of("side_extended", EnumSide.class);

    static <T extends Comparable<T>> T getStatePropertySafe(BlockState state, Property<T> property) {
        try {
            return state.get(property);
        } catch (Exception ignored) {
            return null;
        }
    }

    static boolean getStatePropertySafe(BlockState state, BooleanProperty property) {
        try {
            return state.data.get(property.data);
        } catch (Exception ignored) {
            return false;
        }
    }

    static int getStatePropertySafe(BlockState state, IntegerProperty property) {
        try {
            return state.data.get(property.data);
        } catch (Exception ignored) {
            return 0;
        }
    }

    static Direction getStatePropertySafe(BlockState state, DirectionProperty property) {
        try {
            return Direction.convert(state.data.get(property.data));
        } catch (Exception ignored) {
            return Direction.NORTH;
        }
    }

    static <T extends Enum<T> & StringIdentifiable> T getStatePropertySafe(BlockState state, EnumProperty<T> property) {
        try {
            return state.data.get(property.data);
        } catch (Exception ignored) {
            return null;
        }
    }

    static <T extends Comparable<T>> T getStatePropertySafe(World world, BlockPos pos, Property<T> property) {
        return getStatePropertySafe(world.getBlockState(pos), property);
    }

    static boolean getStatePropertySafe(World world, BlockPos pos, BooleanProperty property) {
        return getStatePropertySafe(world.getBlockState(pos), property);
    }

    static int getStatePropertySafe(World world, BlockPos pos, IntegerProperty property) {
        return getStatePropertySafe(world.getBlockState(pos), property);
    }

    static Direction getStatePropertySafe(World world, BlockPos pos, DirectionProperty property) {
        return getStatePropertySafe(world.getBlockState(pos), property);
    }

    static <T extends Enum<T> & StringIdentifiable> T getStatePropertySafe(World world, BlockPos pos, EnumProperty<T> property) {
        return getStatePropertySafe(world.getBlockState(pos), property);
    }

    static <T extends Comparable<T>> T getStatePropertySafe(BlockView world, BlockPos pos, Property<T> property) {
        return getStatePropertySafe(world.getBlockState(pos), property);
    }

    static boolean getStatePropertySafe(BlockView world, BlockPos pos, BooleanProperty property) {
        return getStatePropertySafe(world.getBlockState(pos), property);
    }

    static int getStatePropertySafe(BlockView world, BlockPos pos, IntegerProperty property) {
        return getStatePropertySafe(world.getBlockState(pos), property);
    }

    static Direction getStatePropertySafe(BlockView world, BlockPos pos, DirectionProperty property) {
        return getStatePropertySafe(world.getBlockState(pos), property);
    }

    static <T extends Enum<T> & StringIdentifiable> T getStatePropertySafe(BlockView world, BlockPos pos, EnumProperty<T> property) {
        return getStatePropertySafe(world.getBlockState(pos), property);
    }

    static VoxelShape getVoxelShapeByDirection(double x1, double y1, double z1, double x2, double y2, double z2, Direction facing) {
        return new VoxelShape(org.mtr.block.IBlock.getVoxelShapeByDirection(x1, y1, z1, x2, y2, z2, facing.data));
    }

    static ActionResult checkHoldingBrush(World world, PlayerEntity player, Runnable callback, Runnable elseCallback) {
        net.minecraft.util.ActionResult res = org.mtr.block.IBlock.checkHoldingBrush(world.data, player.data, callback, elseCallback);
        return ActionResult.valueOf(res.name());
    }

    static ActionResult checkHoldingBrush(World world, PlayerEntity player, Runnable callback) {
        net.minecraft.util.ActionResult res = org.mtr.block.IBlock.checkHoldingBrush(world.data, player.data, callback);
        return ActionResult.valueOf(res.name());
    }
}
