package com.lx862.jcm.mod.registry;

import com.lx862.jcm.mod.network.JCMPacketPayload;
import com.lx862.jcm.mod.network.block.*;
import com.lx862.jcm.mod.network.gui.*;
import com.lx862.jcm.mod.util.JCMLogger;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import org.mtr.mapping.holder.MinecraftServer;
import org.mtr.mapping.holder.PlayerEntity;
import org.mtr.mapping.holder.ServerPlayerEntity;
import org.mtr.mapping.registry.PacketHandler;
import org.mtr.mapping.tool.PacketBufferReceiver;
import org.mtr.mapping.tool.PacketBufferSender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Networking {
    private static final List<String> registeredPackets = new ArrayList<>();
    private static final Map<String, Function<PacketBufferReceiver, ? extends PacketHandler>> PACKETS = new HashMap<>();

    public static void register() {
        JCMLogger.debug("Registering network packets...");
        PayloadTypeRegistry.playC2S().register(JCMPacketPayload.ID, JCMPacketPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(JCMPacketPayload.ID, JCMPacketPayload.CODEC);

        ServerPlayNetworking.registerGlobalReceiver(JCMPacketPayload.ID, (payload, context) -> {
            net.minecraft.server.network.ServerPlayerEntity player = context.player();
            net.minecraft.server.MinecraftServer server = context.server();
            server.execute(() -> {
                PacketBufferReceiver.receive(Unpooled.wrappedBuffer(payload.data()), packetBufferReceiver -> {
                    String className = packetBufferReceiver.readString();
                    Function<PacketBufferReceiver, ? extends PacketHandler> getInstance = PACKETS.get(className);
                    if (getInstance != null) {
                        PacketHandler packet = getInstance.apply(packetBufferReceiver);
                        packet.runServer(new MinecraftServer(server), new ServerPlayerEntity(player));
                    }
                }, runnable -> server.execute(runnable));
            });
        });

        // Block Entity Update
        registerPacket(ButterflyLightUpdatePacket.class, ButterflyLightUpdatePacket::new);
        registerPacket(EnquiryUpdateGUIPacket.class, EnquiryUpdateGUIPacket::new);
        registerPacket(FareSaverUpdatePacket.class, FareSaverUpdatePacket::new);
        registerPacket(OperatorButtonUpdatePacket.class, OperatorButtonUpdatePacket::new);
        registerPacket(PIDSUpdatePacket.class, PIDSUpdatePacket::new);
        registerPacket(PIDSProjectorUpdatePacket.class, PIDSProjectorUpdatePacket::new);
        registerPacket(SoundLooperUpdatePacket.class, SoundLooperUpdatePacket::new);
        registerPacket(SubsidyMachineUpdatePacket.class, SubsidyMachineUpdatePacket::new);

        // GUI Screen
        registerPacket(ButterflyLightGUIPacket.class, ButterflyLightGUIPacket::new);
        registerPacket(FareSaverGUIPacket.class, FareSaverGUIPacket::new);
        registerPacket(OperatorButtonGUIPacket.class, OperatorButtonGUIPacket::new);
        registerPacket(PIDSGUIPacket.class, PIDSGUIPacket::new);
        registerPacket(PIDSProjectorGUIPacket.class, PIDSProjectorGUIPacket::new);
        registerPacket(SoundLooperGUIPacket.class, SoundLooperGUIPacket::new);
        registerPacket(SubsidyMachineGUIPacket.class, SubsidyMachineGUIPacket::new);
    }

    public static void registerClient() {
        ClientPlayNetworking.registerGlobalReceiver(JCMPacketPayload.ID, (payload, context) -> {
            net.minecraft.client.MinecraftClient client = context.client();
            client.execute(() -> {
                PacketBufferReceiver.receive(Unpooled.wrappedBuffer(payload.data()), packetBufferReceiver -> {
                    String className = packetBufferReceiver.readString();
                    Function<PacketBufferReceiver, ? extends PacketHandler> getInstance = PACKETS.get(className);
                    if (getInstance != null) {
                        PacketHandler packet = getInstance.apply(packetBufferReceiver);
                        packet.runClient();
                    }
                }, runnable -> client.execute(runnable));
            });
        });
    }

    public static <T extends PacketHandler> void registerPacket(Class<T> classObject, Function<PacketBufferReceiver, T> getInstance) {
        registeredPackets.add(classObject.getName());
        PACKETS.put(classObject.getName(), getInstance);
    }

    public static <T extends PacketHandler> void sendPacketToServer(T data) {
        if(!registeredPackets.contains(data.getClass().getName())) {
            JCMLogger.warn("Non-registered packets is sent: " + data.getClass().getName());
            JCMLogger.warn("Consider registering in method: mod/registry/Networking.register()");
        }
        PacketBufferSender packetBufferSender = new PacketBufferSender(Unpooled::buffer);
        packetBufferSender.writeString(data.getClass().getName());
        data.write(packetBufferSender);
        packetBufferSender.send(byteBuf -> {
            byte[] bytes = new byte[byteBuf.readableBytes()];
            byteBuf.readBytes(bytes);
            ClientPlayNetworking.send(new JCMPacketPayload(bytes));
        }, runnable -> net.minecraft.client.MinecraftClient.getInstance().execute(runnable));
    }

    public static <T extends PacketHandler> void sendPacketToClient(PlayerEntity player, T data) {
        if(!registeredPackets.contains(data.getClass().getName())) {
            JCMLogger.warn("Non-registered packets is sent: " + data.getClass().getName());
            JCMLogger.warn("Consider registering in method: mod/registry/Networking.register()");
        }
        PacketBufferSender packetBufferSender = new PacketBufferSender(Unpooled::buffer);
        packetBufferSender.writeString(data.getClass().getName());
        data.write(packetBufferSender);
        ServerPlayerEntity serverPlayer = ServerPlayerEntity.cast(player);
        packetBufferSender.send(byteBuf -> {
            byte[] bytes = new byte[byteBuf.readableBytes()];
            byteBuf.readBytes(bytes);
            ServerPlayNetworking.send(serverPlayer.data, new JCMPacketPayload(bytes));
        }, runnable -> serverPlayer.data.server.execute(runnable));
    }
}
