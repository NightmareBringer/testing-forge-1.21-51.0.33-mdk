package net.nbc.thetestermod.enchantment;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.item.enchantment.effects.EnchantmentAttributeEffect;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.enchantment.custom.FortificationEnchantmentEffect;
import net.nbc.thetestermod.enchantment.custom.LightningStrikerEnchantmentEffect;

import java.util.Collections;

public class ModEnchantments
{
    public static final ResourceKey<Enchantment> LIGHTNING_STRIKER = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "lightning_striker"));

    public static final ResourceKey<Enchantment> FORTIFICATION = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "fortification"));

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        var enchantments = context.lookup(Registries.ENCHANTMENT);
        var items = context.lookup(Registries.ITEM);

        register(context, LIGHTNING_STRIKER, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(ItemTags.BOW_ENCHANTABLE),
                        5,
                        3,
                        Enchantment.dynamicCost(5, 8),
                        Enchantment.dynamicCost(25, 8),
                        2,
                        EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.BOW_EXCLUSIVE))
                .exclusiveWith(HolderSet.direct(enchantments.getOrThrow(Enchantments.FLAME)))
                .withEffect(EnchantmentEffectComponents.POST_ATTACK, EnchantmentTarget.ATTACKER,
                        EnchantmentTarget.VICTIM, new LightningStrikerEnchantmentEffect()));

        register(context, FORTIFICATION, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
                        5,
                        3,
                        Enchantment.dynamicCost(5, 8),
                        Enchantment.dynamicCost(25, 8),
                        2,
                        EquipmentSlotGroup.ARMOR))
                .exclusiveWith(HolderSet.direct(enchantments.getOrThrow(Enchantments.UNBREAKING)))
                .exclusiveWith(HolderSet.direct(enchantments.getOrThrow(Enchantments.BINDING_CURSE)))
                .withEffect(EnchantmentEffectComponents.PREVENT_ARMOR_CHANGE)
                .withEffect(EnchantmentEffectComponents.TICK, new FortificationEnchantmentEffect())
                );
    }

    private static void register(BootstrapContext<Enchantment> registry, ResourceKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.location()));
    }
}
