package net.nbc.thetestermod.trim;

import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.item.ModItems;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTrimPatterns
{
    public static final ResourceKey<TrimPattern> NIGHTEN = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "nighten"));

    public static final ResourceKey<TrimPattern> STORMEN = ResourceKey.create(Registries.TRIM_PATTERN,
            ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "stormen"));

    public static void bootstrap(BootstrapContext<TrimPattern> context) {
        register(context, ModItems.NIGHTEN_SMITHING_TEMPLATE.get(), NIGHTEN);
        register(context, ModItems.STORMEN_SMITHING_TEMPLATE.get(), STORMEN);
    }

    private static void register(BootstrapContext<TrimPattern> context, Item item, ResourceKey<TrimPattern> key) {
        TrimPattern trimPattern = new TrimPattern(key.location(), ForgeRegistries.ITEMS.getHolder(item).get(),
                Component.translatable(Util.makeDescriptionId("trim_pattern", key.location())), false);
        context.register(key, trimPattern);
    }
}
