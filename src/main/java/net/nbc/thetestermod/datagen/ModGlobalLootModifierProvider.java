package net.nbc.thetestermod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.ReloadableServerRegistries;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.enchantment.ModEnchantments;
import net.nbc.thetestermod.item.ModItems;
import net.nbc.thetestermod.loot.AddItemModifier;
import net.nbc.thetestermod.potion.ModPotions;
import net.minecraft.core.Holder;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {

    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, TesterMod.MOD_ID);
    }

    @Override
    protected void start() {

        this.add("crimson_blue_berries_from_crimson_roots",
                new AddItemModifier(new LootItemCondition[] {
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.CRIMSON_ROOTS).build(),
                        LootItemRandomChanceCondition.randomChance(0.07f).build() }, ModItems.CRIMSON_BLUE_BERRIES.get()));

        this.add("chisel_from_jungle_temple",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/jungle_temple"))
                                .and(LootItemRandomChanceCondition.randomChance(0.15f)).build()
                }, ModItems.CHISEL.get()));

        add("squidward_music_disk_from_creeper", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/creeper"))
                        .and(LootItemRandomChanceCondition.randomChance(0.05f)).build() }, // modified by the creeper's own loot table
                ModItems.HAIL_SQUIDWARD_MUSIC_DISC.get()));

        add("nightmare_trim_from_spider", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/spider"))
                        .and(LootItemRandomChanceCondition.randomChance(0.02f)).build() },
                ModItems.NIGHTEN_SMITHING_TEMPLATE.get()));

        add("storm_trim_from_stray", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/stray"))
                        .and(LootItemRandomChanceCondition.randomChance(0.02f)).build() },
                ModItems.STORMEN_SMITHING_TEMPLATE.get()));

        add("throwing_knife_from_zombie", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/zombie"))
                        .and(LootItemRandomChanceCondition.randomChance(0.08f)).build() },
                ModItems.THROWING_KNIFE.get()));

        add("energy_orb_from_drowned", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/drowned"))
                        .and(LootItemRandomChanceCondition.randomChance(0.08f)).build() },
                ModItems.ENERGY_ORB.get()));
    }
}
