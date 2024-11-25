package net.nbc.thetestermod.event;

import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.server.commands.PlaySoundCommand;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.effects.PlaySoundEffect;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.effect.ModEffects;
import net.nbc.thetestermod.item.ModItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber(modid = TesterMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents
{
    private static final Logger LOGGER = LogManager.getLogger();

    @SubscribeEvent
    public static void onComputerFovModifierEvent(ComputeFovModifierEvent event) {
        if(event.getPlayer().isUsingItem() && event.getPlayer().getUseItem().getItem() == ModItems.NIGHTMARE_BOW.get()) {
            float fovModifier = 1f;
            int ticksUsingItem = event.getPlayer().getTicksUsingItem();
            float deltaTicks = (float)ticksUsingItem / 20f;
            if(deltaTicks > 1f) {
                deltaTicks = 1f;
            } else {
                deltaTicks *= deltaTicks;
            }
            fovModifier *= 1f - deltaTicks * 0.15f;
            event.setNewFovModifier(fovModifier);
        }

        if(event.getPlayer().isUsingItem() && event.getPlayer().getUseItem().getItem() == ModItems.STORM_BOW.get()) {
            float fovModifier = 1f;
            int ticksUsingItem = event.getPlayer().getTicksUsingItem();
            float deltaTicks = (float)ticksUsingItem / 20f;
            if(deltaTicks > 1f) {
                deltaTicks = 1f;
            } else {
                deltaTicks *= deltaTicks;
            }
            fovModifier *= 1f - deltaTicks * 0.15f;
            event.setNewFovModifier(fovModifier);
        }
    }

    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent event)
    {
        if(event.getEntity() instanceof IronGolem mob && event.getSource().getDirectEntity() instanceof Player player)
        {
            if(player.getMainHandItem().getItem() == Items.END_ROD)
            {
                player.sendSystemMessage(Component.literal(player.getName().getString() + "Brother! Brother, you've hit my voice module button! Brother!"));
                mob.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200, 1));
                player.getMainHandItem().shrink(1);
                player.playNotifySound(SoundEvents.GLASS_BREAK, SoundSource.BLOCKS, 1f, 0.75f);
            }
        }

        if(event.getEntity() instanceof EnderMan mob && event.getSource().getDirectEntity() instanceof Player player)
        {
            player.sendSystemMessage(Component.literal("why"));
            player.sendSystemMessage(Component.literal("do"));
            player.sendSystemMessage(Component.literal("you"));
            player.sendSystemMessage(Component.literal("feel"));
            player.sendSystemMessage(Component.literal("hate"));
            player.sendSystemMessage(Component.literal("towards"));
            player.sendSystemMessage(Component.literal("me"));
            player.sendSystemMessage(Component.literal("why"));
        }
    }

    @SubscribeEvent
    public static void onMobEffect(MobEffectEvent.Added event) {
        if (event.getEntity() instanceof Player player) {
            boolean hasPurification = player.getActiveEffects().stream()
                    .anyMatch(mobEffectInstance -> mobEffectInstance.getEffect() == ModEffects.PURIFICATION_EFFECT.get());

            boolean hasImpurification = player.getActiveEffects().stream()
                    .anyMatch(mobEffectInstance -> mobEffectInstance.getEffect() == ModEffects.IMPURIFICATION_EFFECT.get());

            if (hasPurification && !event.getEffectInstance().getEffect().get().isBeneficial()) {
                player.removeEffect(event.getEffectInstance().getEffect());
            }
            else if (hasImpurification && event.getEffectInstance().getEffect().get().isBeneficial()) {
                player.removeEffect(event.getEffectInstance().getEffect());
            }

            /*LOGGER.debug("The bool hasPurification is: {}", hasPurification);
            player.getActiveEffects().forEach(effectInstance ->
                    System.out.println("Active effect: " + effectInstance.getEffect()));*/
        }
    }
}
