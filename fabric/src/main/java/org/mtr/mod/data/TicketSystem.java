package org.mtr.mod.data;

import org.mtr.mapping.holder.PlayerEntity;
import org.mtr.mapping.holder.World;

public class TicketSystem {
    public static final String BALANCE_OBJECTIVE = org.mtr.data.TicketSystem.BALANCE_OBJECTIVE;
    public static final String BALANCE_OBJECTIVE_TITLE = org.mtr.data.TicketSystem.BALANCE_OBJECTIVE_TITLE;

    public static int getBalance(World world, PlayerEntity player) {
        return org.mtr.data.TicketSystem.getBalance(world.data, player.data);
    }

    public static void addBalance(World world, PlayerEntity player, int amount) {
        org.mtr.data.TicketSystem.addBalance(world.data, player.data, amount);
    }
}
