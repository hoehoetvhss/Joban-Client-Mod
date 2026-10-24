package net.minecraft.client.gui.widget;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.text.Text;

public class CheckboxWidgetHelper extends CheckboxWidget {
    public CheckboxWidgetHelper(int x, int y, int width, Text text, TextRenderer textRenderer, boolean checked, Callback callback) {
        super(x, y, width, text, textRenderer, checked, callback);
    }

    public void setCheckedInternal(boolean value) {
        if (isChecked() != value) {
            onPress();
        }
    }
}
