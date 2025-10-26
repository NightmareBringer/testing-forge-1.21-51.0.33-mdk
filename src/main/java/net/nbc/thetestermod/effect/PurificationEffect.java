package net.nbc.thetestermod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class PurificationEffect extends MobEffect
{
    protected PurificationEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        // Cancel out if Impurification is active
        if (entity.hasEffect(ModEffects.IMPURIFICATION_EFFECT)) {
            entity.removeEffect(ModEffects.IMPURIFICATION_EFFECT);
            entity.removeEffect(ModEffects.PURIFICATION_EFFECT);
            return false;
        }

        // Remove all *harmful* effects
        entity.getActiveEffects().removeIf(instance -> {
            MobEffect effect = instance.getEffect().value();
            boolean bool = !effect.isBeneficial() && effect != this;  // don't remove itself
            if (bool) {
                effect.removeAttributeModifiers(entity.getAttributes());
            }
            return bool;
        });

        return super.applyEffectTick(entity, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        return true;
    }
}
