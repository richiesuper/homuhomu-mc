package net.richiesuper.homuhomu.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import net.richiesuper.homuhomu.HomuHomu;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class ModMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		HomuHomu.LOGGER.info("I hope you enjoy the mod!");
	}
}
