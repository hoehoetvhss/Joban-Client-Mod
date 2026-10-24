package com.lx862.jcm.mod.network;

import com.lx862.jcm.mod.Constants;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record JCMPacketPayload(byte[] data) implements CustomPayload {
    public static final CustomPayload.Id<JCMPacketPayload> ID = new CustomPayload.Id<>(Identifier.of(Constants.MOD_ID, "packet"));

    public static final PacketCodec<PacketByteBuf, JCMPacketPayload> CODEC = CustomPayload.codecOf(
        (value, buf) -> buf.writeByteArray(value.data),
        buf -> new JCMPacketPayload(buf.readByteArray())
    );

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
