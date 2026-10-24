package org.mtr.mod;

import org.mtr.mapping.holder.SoundEvent;
import org.mtr.mapping.registry.SoundEventRegistryObject;

import java.lang.reflect.Constructor;

public final class SoundEvents {
    private static SoundEventRegistryObject wrap(net.minecraft.sound.SoundEvent soundEvent) {
        try {
            Constructor<SoundEventRegistryObject> c = SoundEventRegistryObject.class.getDeclaredConstructor(SoundEvent.class);
            c.setAccessible(true);
            return c.newInstance(new SoundEvent(soundEvent));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static final SoundEventRegistryObject TICKET_BARRIER = wrap(org.mtr.registry.SoundEvents.TICKET_BARRIER.get());
    public static final SoundEventRegistryObject TICKET_BARRIER_CONCESSIONARY = wrap(org.mtr.registry.SoundEvents.TICKET_BARRIER_CONCESSIONARY.get());
    public static final SoundEventRegistryObject TICKET_PROCESSOR_ENTRY = wrap(org.mtr.registry.SoundEvents.TICKET_PROCESSOR_ENTRY.get());
    public static final SoundEventRegistryObject TICKET_PROCESSOR_ENTRY_CONCESSIONARY = wrap(org.mtr.registry.SoundEvents.TICKET_PROCESSOR_ENTRY_CONCESSIONARY.get());
    public static final SoundEventRegistryObject TICKET_PROCESSOR_EXIT = wrap(org.mtr.registry.SoundEvents.TICKET_PROCESSOR_EXIT.get());
    public static final SoundEventRegistryObject TICKET_PROCESSOR_EXIT_CONCESSIONARY = wrap(org.mtr.registry.SoundEvents.TICKET_PROCESSOR_EXIT_CONCESSIONARY.get());
    public static final SoundEventRegistryObject TICKET_PROCESSOR_FAIL = wrap(org.mtr.registry.SoundEvents.TICKET_PROCESSOR_FAIL.get());
}
