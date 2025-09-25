package net.nbc.thetestermod.enchantment.custom;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderOwner;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.item.enchantment.effects.EnchantmentLocationBasedEffect;
import net.minecraft.world.item.enchantment.effects.EnchantmentValueEffect;
import net.minecraft.world.phys.Vec3;
import net.nbc.thetestermod.TesterMod;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Stream;

public record FortificationEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<FortificationEnchantmentEffect> CODEC = MapCodec.unit(FortificationEnchantmentEffect::new);

    @Override
    public void apply(ServerLevel serverLevel, int i, EnchantedItemInUse enchantedItemInUse, Entity entity, Vec3 vec3) {
        if (!(entity instanceof Player player)) return;

        AttributeInstance armorAttribute = player.getAttribute(Attributes.ARMOR);
        if (armorAttribute == null) return;

        EquipmentSlot slot = enchantedItemInUse.inSlot();
        ResourceLocation modifierId = ResourceLocation.fromNamespaceAndPath(
                TesterMod.MOD_ID, "fortification_boost_" + slot.getName()
        );

        // If the item is not in an armor slot, remove any lingering modifier
        if (slot.getType() != EquipmentSlot.Type.HUMANOID_ARMOR) {
            if (armorAttribute.getModifier(modifierId) != null) {
                armorAttribute.removeModifier(modifierId);
            }
            return;
        }

        // Always remove any old modifier for this slot first
        if (armorAttribute.getModifier(modifierId) != null) {
            armorAttribute.removeModifier(modifierId);
        }

        // Get the item stack and check durability
        ItemStack stack = enchantedItemInUse.itemStack();
        int maxDurability = stack.getMaxDamage();
        int currentDamage = stack.getDamageValue();
        float durabilityPercent = (float) (maxDurability - currentDamage) / maxDurability;

        boolean boost = switch (i) {
            case 1 -> durabilityPercent >= 0.85f;
            case 2 -> durabilityPercent >= 0.75f;
            case 3 -> durabilityPercent >= 0.50f;
            default -> false;
        };

        if (boost) {
            double boostAmount = switch (i) {
                case 1 -> 2.0;
                case 2 -> 3.0;
                case 3 -> 4.0;
                default -> 0.0;
            };

            armorAttribute.addTransientModifier(new AttributeModifier(
                    modifierId, boostAmount, AttributeModifier.Operation.ADD_VALUE
            ));
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}
