package com.lx862.jcm.mod.data.pids;

import com.google.gson.JsonObject;
import com.lx862.jcm.mod.data.pids.preset.JsonPIDSPreset;
import com.lx862.jcm.mod.data.pids.preset.PIDSPresetBase;
import com.lx862.jcm.mod.util.JCMLogger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PIDSManager {
    private static final Map<String, PIDSPresetBase> presetList = new HashMap<>();

    public static void loadJson(JsonObject customResourceJson) {
        customResourceJson.get("pids_images").getAsJsonArray().forEach(e -> {
            String presetId = "(Unknown preset)";

            try {
                JsonObject jsonObject = e.getAsJsonObject();
                presetId = jsonObject.get("id").getAsString();

                boolean isScriptPreset = jsonObject.has("scriptFiles") || jsonObject.has("scriptTexts");
                PIDSPresetBase preset;

                if(isScriptPreset) {
                    JCMLogger.info("Scripted PIDS Preset {} is not supported on 1.21.1 yet, skipping.", presetId);
                    return;
                } else {
                    preset = JsonPIDSPreset.parse(e.getAsJsonObject());
                }

                if(preset != null) {
                    if(presetList.containsKey(preset.getId()) && !preset.builtin) {
                        JCMLogger.error("Custom preset \"{}\" already added!", presetId);
                    } else {
                        presetList.put(preset.getId(), preset);
                    }
                }
            } catch (Exception ex) {
                JCMLogger.error("Failed to parse PIDS Preset \"" + presetId + "\"!", ex);
            }
        });
    }

    public static PIDSPresetBase getPreset(String id, PIDSPresetBase defaultPreset) {
        return presetList.getOrDefault(id, defaultPreset);
    }

    public static PIDSPresetBase getPreset(String id) {
        return getPreset(id, null);
    }

    public static List<PIDSPresetBase> getBuiltInPresets() {
        return presetList.values().stream().filter(e -> e.builtin).collect(Collectors.toList());
    }

    public static List<PIDSPresetBase> getCustomPresets() {
        return presetList.values().stream().filter(e -> !e.builtin).collect(Collectors.toList());
    }

    public static void reset() {
        presetList.entrySet().removeIf(e -> !e.getValue().builtin);
    }
}
