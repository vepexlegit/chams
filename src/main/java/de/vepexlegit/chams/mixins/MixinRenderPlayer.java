package de.vepexlegit.chams.mixins;

import net.minecraft.client.renderer.entity.RenderPlayer;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RenderPlayer.class)
public class MixinRenderPlayer {
    @Inject(method = "doRender", at = @At("HEAD"))
    private void doRenderPre(final CallbackInfo ci) {
        GL11.glEnable(32823);
        GL11.glPolygonOffset(1.0f, -1100000.0f);
    }

    @Inject(method = "doRender", at = @At("RETURN"))
    private void doRenderPost(final CallbackInfo ci) {
        GL11.glPolygonOffset(1.0f, 1100000.0f);
        GL11.glDisable(32823);
    }
}
