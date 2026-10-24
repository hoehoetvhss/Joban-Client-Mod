package com.lx862.jcm.mod.registry;

import com.lx862.jcm.mod.JCMClient;
import com.lx862.jcm.mod.data.JCMServerStats;
import com.lx862.jcm.mod.extra.JCMPatchForMTR;
import com.lx862.jcm.mod.resource.JCMResourceManager;

public class Events {
    public static void register() {
        JCMRegistry.REGISTRY.eventRegistry.registerStartServerTick(JCMServerStats::incrementGameTick);
    }

    public static void registerClient() {
        JCMRegistryClient.REGISTRY_CLIENT.eventRegistryClient.registerStartClientTick(() -> {
            JCMClient.getMcMetaManager().tick();
            JCMPatchForMTR.tick();
        });

        JCMRegistryClient.REGISTRY_CLIENT.eventRegistryClient.registerClientJoin(() -> {
            JCMPatchForMTR.cachedRailNodeState.clear();
        });
    }

    public static void onClientReloadResource() {
        JCMResourceManager.reload();
    }
}
