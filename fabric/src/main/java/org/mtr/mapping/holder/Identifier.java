package org.mtr.mapping.holder;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import org.mtr.mapping.tool.HolderBase;

public final class Identifier extends HolderBase<net.minecraft.util.Identifier> implements Comparable<Identifier> {

    public Identifier(net.minecraft.util.Identifier data) {
        super(data);
    }

    public Identifier(String id) {
        super(net.minecraft.util.Identifier.of(id));
    }

    public Identifier(String namespace, String path) {
        super(net.minecraft.util.Identifier.of(namespace, path));
    }

    public static Identifier cast(HolderBase<?> holder) {
        return new Identifier((net.minecraft.util.Identifier) holder.data);
    }

    public static boolean isInstance(HolderBase<?> holder) {
        return holder != null && holder.data instanceof net.minecraft.util.Identifier;
    }

    public static Identifier fromCommandInput(StringReader reader) throws CommandSyntaxException {
        return new Identifier(net.minecraft.util.Identifier.fromCommandInput(reader));
    }

    public static Identifier tryParse(String id) {
        net.minecraft.util.Identifier identifier = net.minecraft.util.Identifier.tryParse(id);
        return identifier == null ? null : new Identifier(identifier);
    }

    public String getNamespace() {
        return data.getNamespace();
    }

    public String getPath() {
        return data.getPath();
    }

    @Override
    public int compareTo(Identifier o) {
        return data.compareTo(o.data);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof HolderBase) {
            return data.equals(((HolderBase<?>) obj).data);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
