package org.mtr.mod.screen;

import org.mtr.core.data.Platform;
import org.mtr.libraries.it.unimi.dsi.fastutil.objects.ObjectArrayList;
import org.mtr.libraries.it.unimi.dsi.fastutil.objects.ObjectImmutableList;

public class PIDSConfigScreen {
    public static ObjectImmutableList<DashboardListItem> getPlatformsForList(ObjectArrayList<Platform> platforms) {
        ObjectArrayList<DashboardListItem> list = new ObjectArrayList<>();
        for (Platform platform : platforms) {
            list.add(new DashboardListItem(platform.getId(), platform.getName(), platform.getColor()));
        }
        return new ObjectImmutableList<>(list);
    }
}
