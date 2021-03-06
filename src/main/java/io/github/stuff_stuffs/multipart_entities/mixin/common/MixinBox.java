package io.github.stuff_stuffs.multipart_entities.mixin.common;

import io.github.stuff_stuffs.multipart_entities.common.util.CompoundOrientedBox;
import net.minecraft.util.math.Box;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Box.class)
public class MixinBox {
    @Inject(method = "intersects(Lnet/minecraft/util/math/Box;)Z", at = @At("HEAD"), cancellable = true)
    private void hook(final Box box, final CallbackInfoReturnable<Boolean> cir) {
        if (box instanceof CompoundOrientedBox) {
            cir.setReturnValue(box.intersects((Box) (Object) this));
        }
    }
}
