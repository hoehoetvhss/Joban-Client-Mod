package org.mtr.mod.data;

public interface IGui extends org.mtr.data.IGui {
    static boolean isCjk(String text) {
        return org.mtr.data.IGui.isCjk(text);
    }

    static String formatStationName(String text) {
        return org.mtr.data.IGui.formatStationName(text);
    }

    static String textOrUntitled(String text) {
        return org.mtr.data.IGui.textOrUntitled(text);
    }
}
