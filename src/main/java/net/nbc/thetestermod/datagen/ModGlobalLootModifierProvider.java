package net.nbc.thetestermod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.nbc.thetestermod.loot.custom.ChargedCreeperCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.item.ModItems;
import net.nbc.thetestermod.loot.AddItemModifier;

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
                        LootItemRandomChanceCondition.randomChance(0.06f).build() }, ModItems.CRIMSON_BLUE_BERRIES.get()));

        this.add("crimson_berries_from_bastion_treasure",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/bastion_treasure"))
                                .and(LootItemRandomChanceCondition.randomChance(0.07f)).build()
                }, ModItems.CRIMSON_BLUE_BERRIES.get()));

        this.add("crimson_berries_from_nether_bridge",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/nether_bridge"))
                                .and(LootItemRandomChanceCondition.randomChance(0.09f)).build()
                }, ModItems.CRIMSON_BLUE_BERRIES.get()));

        this.add("mystery_dust_from_pillager_outpost",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/pillager_outpost"))
                                .and(LootItemRandomChanceCondition.randomChance(0.10f)).build()
                }, ModItems.MYSTERIOUS_DUST.get()));

        this.add("mystery_dust_from_igloo_chest",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/igloo_chest"))
                                .and(LootItemRandomChanceCondition.randomChance(0.12f)).build()
                }, ModItems.MYSTERIOUS_DUST.get()));

        this.add("strange_stick_from_bastion_bridge",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/bastion_bridge"))
                                .and(LootItemRandomChanceCondition.randomChance(0.12f)).build()
                }, ModItems.STRANGE_STICK.get()));

        this.add("strange_stick_from_bastion_other",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/bastion_other"))
                                .and(LootItemRandomChanceCondition.randomChance(0.12f)).build()
                }, ModItems.STRANGE_STICK.get()));

        this.add("chisel_from_jungle_temple",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/jungle_temple"))
                                .and(LootItemRandomChanceCondition.randomChance(0.14f)).build()
                }, ModItems.CHISEL.get()));

        this.add("chisel_from_pyramid",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/desert_pyramid"))
                                .and(LootItemRandomChanceCondition.randomChance(0.09f)).build()
                }, ModItems.CHISEL.get()));

        this.add("devils_snath_from_stronghold_corridor",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/stronghold_corridor"))
                                .and(LootItemRandomChanceCondition.randomChance(0.02f)).build()
                }, ModItems.DEVILS_SNATH.get()));

        this.add("devils_blade_from_stronghold_crossing",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/stronghold_crossing"))
                                .and(LootItemRandomChanceCondition.randomChance(0.03f)).build()
                }, ModItems.DEVILS_BLADE.get()));

        this.add("throwing_knife_from_ruined_portal",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/ruined_portal"))
                                .and(LootItemRandomChanceCondition.randomChance(0.12f)).build()
                }, ModItems.THROWING_KNIFE.get()));

        this.add("white_carrot_from_village_plains_house",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/village/village_plains_house"))
                                .and(LootItemRandomChanceCondition.randomChance(0.11f)).build()
                }, ModItems.WHITE_CARROT.get()));

        this.add("white_carrot_from_igloo_chest",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/igloo_chest"))
                                .and(LootItemRandomChanceCondition.randomChance(0.11f)).build()
                }, ModItems.WHITE_CARROT.get()));

        this.add("squidward_music_from_mineshaft",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/abandoned_mineshaft"))
                                .and(LootItemRandomChanceCondition.randomChance(0.13f)).build()
                }, ModItems.VOID_MUSIC_DISK.get()));

        this.add("squidward_music_from_simple_dungeon",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/simple_dungeon"))
                                .and(LootItemRandomChanceCondition.randomChance(0.10f)).build()
                }, ModItems.VOID_MUSIC_DISK.get()));

        add("energy_orb_from_from_charged_creeper", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/creeper"))
                        .and(LootItemRandomChanceCondition.randomChance(0.85f)).build(), new ChargedCreeperCondition() },
                ModItems.ENERGY_ORB.get()));

        add("nightmare_trim_from_spider", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/spider"))
                        .and(LootItemRandomChanceCondition.randomChance(0.04f)).build() },
                ModItems.NIGHTEN_SMITHING_TEMPLATE.get()));

        add("storm_trim_from_stray", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/stray"))
                        .and(LootItemRandomChanceCondition.randomChance(0.04f)).build() },
                ModItems.STORMEN_SMITHING_TEMPLATE.get()));

        add("throwing_knife_from_zombie", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/zombie"))
                        .and(LootItemRandomChanceCondition.randomChance(0.07f)).build() },
                ModItems.THROWING_KNIFE.get()));
    }
}
