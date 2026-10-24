package org.mtr.mod;

import org.mtr.mapping.holder.Item;
import org.mtr.mapping.registry.ItemRegistryObject;
import java.lang.reflect.Constructor;

public class Items {
    private static ItemRegistryObject wrap(net.minecraft.item.Item item) {
        try {
            Constructor<ItemRegistryObject> c = ItemRegistryObject.class.getDeclaredConstructor(Item.class);
            c.setAccessible(true);
            return c.newInstance(new Item(item));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static final ItemRegistryObject BASIC_DRIVER_KEY = wrap(org.mtr.registry.Items.BASIC_DRIVER_KEY.get());
    public static final ItemRegistryObject GUARD_KEY = wrap(org.mtr.registry.Items.GUARD_KEY.get());
    public static final ItemRegistryObject ADVANCED_DRIVER_KEY = wrap(org.mtr.registry.Items.ADVANCED_DRIVER_KEY.get());
    public static final ItemRegistryObject CREATIVE_DRIVER_KEY = wrap(org.mtr.registry.Items.CREATIVE_DRIVER_KEY.get());
    public static final ItemRegistryObject BRUSH = wrap(org.mtr.registry.Items.BRUSH.get());
}
