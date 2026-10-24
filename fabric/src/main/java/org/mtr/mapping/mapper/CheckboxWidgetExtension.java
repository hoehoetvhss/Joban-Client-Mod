package org.mtr.mapping.mapper;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.CheckboxWidgetHelper;
import net.minecraft.text.Text;
import org.mtr.mapping.holder.MutableText;

import java.util.function.Consumer;

public class CheckboxWidgetExtension extends CheckboxWidgetHelper {

    public CheckboxWidgetExtension(int x, int y, int width, int height, boolean checked, Consumer<Boolean> callback) {
        this(x, y, width, height, Text.empty(), checked, callback);
    }

    public CheckboxWidgetExtension(int x, int y, int width, int height, String message, boolean checked, Consumer<Boolean> callback) {
        this(x, y, width, height, Text.literal(message), checked, callback);
    }

    public CheckboxWidgetExtension(int x, int y, int width, int height, MutableText message, boolean checked, Consumer<Boolean> callback) {
        this(x, y, width, height, message.data, checked, callback);
    }

    private CheckboxWidgetExtension(int x, int y, int width, int height, Text message, boolean checked, Consumer<Boolean> callback) {
        super(x, y, width, message, MinecraftClient.getInstance().textRenderer, checked, (checkbox, value) -> {
            if (callback != null) {
                callback.accept(value);
            }
        });
    }

    @Override
    public void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {
        GraphicsHolder.createInstanceSafe(context, graphicsHolder -> render(graphicsHolder, mouseX, mouseY, delta));
        super.renderWidget(context, mouseX, mouseY, delta);
    }

    public void render(GraphicsHolder graphicsHolder, int mouseX, int mouseY, float delta) {
    }

    public void onPress2() {
        onPress();
    }

    public void setChecked(boolean checked) {
        setCheckedInternal(checked);
    }

    public boolean isChecked2() {
        return isChecked();
    }

    public int getX2() {
        return getX();
    }

    public int getY2() {
        return getY();
    }

    public void setX2(int x) {
        setX(x);
    }

    public void setY2(int y) {
        setY(y);
    }

    public int getWidth2() {
        return getWidth();
    }

    public int getHeight2() {
        return getHeight();
    }

    public void setWidth2(int width) {
        setWidth(width);
    }

    public boolean getActiveMapped() {
        return active;
    }

    public void setActiveMapped(boolean active) {
        this.active = active;
    }

    public boolean getVisibleMapped() {
        return visible;
    }

    public void setVisibleMapped(boolean visible) {
        this.visible = visible;
    }

    public void setAlpha2(float alpha) {
        setAlpha(alpha);
    }

    public void setMessage2(org.mtr.mapping.holder.Text message) {
        setMessage(message.data);
    }

    public void setMessage2(MutableText message) {
        setMessage(message.data);
    }
}
