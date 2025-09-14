package net.nbc.thetestermod.item;

import net.nbc.thetestermod.TesterMod;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static final Holder<ArmorMaterial> NIGHTMARE_ARMOR_MATERIAL = register("nightmare", Util.make(new EnumMap<>(ArmorItem.Type.class),
            attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 4);
                attribute.put(ArmorItem.Type.LEGGINGS, 7);
                attribute.put(ArmorItem.Type.CHESTPLATE, 10);
                attribute.put(ArmorItem.Type.HELMET, 5);
                attribute.put(ArmorItem.Type.BODY, 15);
            }), 15, 5f, 0.03f, ModItems.NIGHTMARE_INGOT);

    public static final Holder<ArmorMaterial> STORM_ARMOR_MATERIAL = register("storm", Util.make(new EnumMap<>(ArmorItem.Type.class),
            attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 3);
                attribute.put(ArmorItem.Type.LEGGINGS, 5);
                attribute.put(ArmorItem.Type.CHESTPLATE, 8);
                attribute.put(ArmorItem.Type.HELMET, 4);
                attribute.put(ArmorItem.Type.BODY, 10);
            }), 15, 10f, 0.05f, ModItems.STORM_INGOT);

    // ===== FALSE NIGHTMARE ARMOR =====
    public static final Holder<ArmorMaterial> FALSE_NIGHTMARE_ARMOR_MATERIAL = register("false_nightmarite", Util.make(new EnumMap<>(ArmorItem.Type.class),
            attr -> {
                attr.put(ArmorItem.Type.BOOTS, 3);
                attr.put(ArmorItem.Type.LEGGINGS, 5);
                attr.put(ArmorItem.Type.CHESTPLATE, 6);
                attr.put(ArmorItem.Type.HELMET, 3);
                attr.put(ArmorItem.Type.BODY, 7);
            }), 10, 2f, 0f, ModItems.FALSE_NIGHTMARITE_INGOT);

    // ===== FALSE STORM ARMOR =====
    public static final Holder<ArmorMaterial> FALSE_STORM_ARMOR_MATERIAL = register("false_stormite", Util.make(new EnumMap<>(ArmorItem.Type.class),
            attr -> {
                attr.put(ArmorItem.Type.BOOTS, 3);
                attr.put(ArmorItem.Type.LEGGINGS, 4);
                attr.put(ArmorItem.Type.CHESTPLATE, 5);
                attr.put(ArmorItem.Type.HELMET, 2);
                attr.put(ArmorItem.Type.BODY, 6);
            }), 10, 3f, 0f, ModItems.FALSE_STORMITE_INGOT);



    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection,
                                                  int enchantability, float toughness, float knockbackResistance,
                                                  Supplier<Item> ingredientItem) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, name);
        Holder<SoundEvent> equipSound = SoundEvents.ARMOR_EQUIP_NETHERITE;
        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));

        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            typeMap.put(type, typeProtection.get(type));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location,
                new ArmorMaterial(typeProtection, enchantability, equipSound, ingredient, layers, toughness, knockbackResistance));
    }




}
