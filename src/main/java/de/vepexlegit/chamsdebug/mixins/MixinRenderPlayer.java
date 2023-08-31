package de.vepexlegit.chamsdebug.mixins;

import de.vepexlegit.chamsdebug.Chams;
import de.vepexlegit.chamsdebug.commands.ChamsCommand;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraftforge.client.ClientCommandHandler;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RenderPlayer.class)
public class MixinRenderPlayer {
    @Inject(method = "doRender", at = @At("RETURN"))
    private void startGame(final CallbackInfo ci) {
        ClientCommandHandler.instance.registerCommand(new ChamsCommand());
    }

    @Inject(method = "doRender", at = @At("HEAD"))
    private void doRenderPre(final CallbackInfo ci) {
        if(Chams.INSTANCE.isEnabled()) {
            GL11.glEnable(32823);
            GL11.glPolygonOffset(1.0f, -1100000.0f);
        }
    }

    @Inject(method = "doRender", at = @At("RETURN"))
    private void doRenderPost(final CallbackInfo ci) {
        GL11.glPolygonOffset(1.0f, 1100000.0f);
        GL11.glDisable(32823);
    }
}
