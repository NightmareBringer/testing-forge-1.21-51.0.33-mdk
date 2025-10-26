package net.nbc.thetestermod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class ImpurificationEffect extends MobEffect{

    protected ImpurificationEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        // Cancel out if Purification is active
        if (entity.hasEffect(ModEffects.PURIFICATION_EFFECT)) {
            entity.removeEffect(ModEffects.PURIFICATION_EFFECT);
            entity.removeEffect(ModEffects.IMPURIFICATION_EFFECT);
            return false;
        }

        // Remove all *beneficial* effects
        entity.getActiveEffects().removeIf(instance -> {
            MobEffect effect = instance.getEffect().value();
            boolean bool = effect.isBeneficial() && effect != this; // don't remove itself
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
