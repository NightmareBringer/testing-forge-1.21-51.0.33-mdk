package net.nbc.thetestermod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.enchantment.ModEnchantments;
import net.nbc.thetestermod.item.ModItems;
import net.nbc.thetestermod.loot.AddItemModifier;
import net.nbc.thetestermod.potion.ModPotions;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {

    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, TesterMod.MOD_ID, registries);
    }

    @Override
    protected void start(HolderLookup.Provider provider) {

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

        add("lightning_shot_from_skeleton", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/skeleton"))
                        .and(LootItemRandomChanceCondition.randomChance(0.05f)).build() }, // modified by the skeleton's own loot table
                ModItems.ENERGY_ORB.get()));
    }
}
