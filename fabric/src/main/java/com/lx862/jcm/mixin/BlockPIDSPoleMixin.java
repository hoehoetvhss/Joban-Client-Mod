package com.lx862.jcm.mixin;

import com.lx862.jcm.mod.block.PIDS1ABlock;
import net.minecraft.block.AbstractBlock;
import org.mtr.block.BlockPIDSPole;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = BlockPIDSPole.class, remap = false)
public class BlockPIDSPoleMixin {
    @Inject(method = "isBlock", at = @At("HEAD"), cancellable = true)
    public void checkForPIDS1A(AbstractBlock block, CallbackInfoReturnable<Boolean> cir) {
        if(block instanceof PIDS1ABlock) cir.setReturnValue(true);
    }
}
