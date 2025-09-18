package net.nbc.thetestermod.datagen;

import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.nbc.thetestermod.item.custom.EnchantableArmorItem;
import net.nbc.thetestermod.item.custom.ModArmorItem;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static final LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TesterMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Basic items
        basicItem(ModItems.NIGHTMARITE.get());
        //basicItem(ModItems.PURE_NIGHTMARITE.get());
        basicItem(ModItems.NIGHTMARE_INGOT.get());
        basicItem(ModItems.NIGHTMARE_NUGGET.get());
        basicItem(ModItems.STORMITE.get());
        basicItem(ModItems.IMPURE_STORMITE.get());
        basicItem(ModItems.STORM_INGOT.get());
        basicItem(ModItems.STORM_NUGGET.get());

        basicItem(ModItems.NIGHTMARE_HORSE_ARMOR.get());
        basicItem(ModItems.STORM_HORSE_ARMOR.get());

        // Handheld items
        // basicItem(ModItems.CHISEL.get()); // (Commented out)
        basicItem(ModItems.KRABS.get());
        basicItem(ModItems.WHITE_CARROT.get());
        basicItem(ModItems.GLISTERING_CARROT.get());
        basicItem(ModItems.CRIMSON_BLUE_BERRIES.get());
        basicItem(ModItems.PURE_EYE.get());
        basicItem(ModItems.IMPURE_EYE.get());
        handheldItem(ModItems.IMPURE_STICK.get());
        handheldItem(ModItems.DEVILS_SNATH.get());
        basicItem(ModItems.DEVILS_BLADE.get());

        basicItem(ModItems.MYSTERIOUS_DUST.get());
        basicItem(ModItems.MYSTERIOUS_STRING.get());
        handheldItem(ModItems.STRANGE_STICK.get());
        handheldItem(ModItems.PURE_STICK.get());

        basicItem(ModItems.INDIGO_DUST.get());
        basicItem(ModItems.INDIGO_BRICK.get());

        basicItem(ModItems.PURE_STORMITE.get());
        basicItem(ModItems.IMPURE_NIGHTMARITE.get());
        basicItem(ModItems.FALSE_STORMITE_INGOT.get());
        basicItem(ModItems.FALSE_NIGHTMARITE_INGOT.get());

        basicItem(ModItems.NIGHTEN_SMITHING_TEMPLATE.get());
        basicItem(ModItems.STORMEN_SMITHING_TEMPLATE.get());

        basicItem(ModItems.HAIL_SQUIDWARD_MUSIC_DISC.get());

        // Block-derived items
        buttonItem(ModBlocks.NIGHTMARE_BUTTON, ModBlocks.NIGHTMARE_BLOCK);
        fenceItem(ModBlocks.NIGHTMARE_FENCE, ModBlocks.NIGHTMARE_BLOCK);
        wallItem(ModBlocks.NIGHTMARE_WALL, ModBlocks.NIGHTMARE_BLOCK);
        simpleBlockItem(ModBlocks.NIGHTMARE_DOOR);

        buttonItem(ModBlocks.REFINED_NIGHTMARE_BUTTON, ModBlocks.REFINED_NIGHTMARE_BLOCK);
        fenceItem(ModBlocks.REFINED_NIGHTMARE_FENCE, ModBlocks.REFINED_NIGHTMARE_BLOCK);
        wallItem(ModBlocks.REFINED_NIGHTMARE_WALL, ModBlocks.REFINED_NIGHTMARE_BLOCK);

        buttonItem(ModBlocks.STORM_BUTTON, ModBlocks.STORM_BLOCK);
        fenceItem(ModBlocks.STORM_FENCE, ModBlocks.STORM_BLOCK);
        wallItem(ModBlocks.STORM_WALL, ModBlocks.STORM_BLOCK);
        simpleBlockItem(ModBlocks.STORM_DOOR);

        // Handheld tools
        handheldItem(ModItems.NIGHTMARE_SWORD);
        handheldItem(ModItems.NIGHTMARE_PICKAXE);
        handheldItem(ModItems.NIGHTMARE_SHOVEL);
        handheldItem(ModItems.NIGHTMARE_AXE);
        handheldItem(ModItems.NIGHTMARE_HOE);
        handheldItem(ModItems.NIGHTMARE_HAMMER);

        handheldItem(ModItems.PURE_NIGHTMARE_SWORD);
        handheldItem(ModItems.PURE_NIGHTMARE_PICKAXE);
        handheldItem(ModItems.PURE_NIGHTMARE_SHOVEL);
        handheldItem(ModItems.PURE_NIGHTMARE_AXE);
        handheldItem(ModItems.PURE_NIGHTMARE_HOE);
        handheldItem(ModItems.PURE_NIGHTMARE_HAMMER);

        handheldItem(ModItems.FALSE_NIGHTMARE_SWORD);
        handheldItem(ModItems.FALSE_NIGHTMARE_PICKAXE);
        handheldItem(ModItems.FALSE_NIGHTMARE_SHOVEL);
        handheldItem(ModItems.FALSE_NIGHTMARE_AXE);
        handheldItem(ModItems.FALSE_NIGHTMARE_HOE);

        handheldItem(ModItems.STORM_SWORD);
        handheldItem(ModItems.STORM_PICKAXE);
        handheldItem(ModItems.STORM_SHOVEL);
        handheldItem(ModItems.STORM_AXE);
        handheldItem(ModItems.STORM_HOE);
        handheldItem(ModItems.STORM_HAMMER);

        handheldItem(ModItems.PURE_STORM_SWORD);
        handheldItem(ModItems.PURE_STORM_PICKAXE);
        handheldItem(ModItems.PURE_STORM_SHOVEL);
        handheldItem(ModItems.PURE_STORM_AXE);
        handheldItem(ModItems.PURE_STORM_HOE);
        handheldItem(ModItems.PURE_STORM_HAMMER);

        handheldItem(ModItems.FALSE_STORM_SWORD);
        handheldItem(ModItems.FALSE_STORM_PICKAXE);
        handheldItem(ModItems.FALSE_STORM_SHOVEL);
        handheldItem(ModItems.FALSE_STORM_AXE);
        handheldItem(ModItems.FALSE_STORM_HOE);

        handheldItem(ModItems.DEVILSKNIFE);

        // Armor with trimming support
        trimmedArmorItem(ModItems.NIGHTMARE_HELMET);
        trimmedArmorItem(ModItems.NIGHTMARE_CHESTPLATE);
        trimmedArmorItem(ModItems.NIGHTMARE_LEGGINGS);
        trimmedArmorItem(ModItems.NIGHTMARE_BOOTS);

        trimmedArmorItem(ModItems.FALSE_NIGHTMARE_HELMET);
        trimmedArmorItem(ModItems.FALSE_NIGHTMARE_CHESTPLATE);
        trimmedArmorItem(ModItems.FALSE_NIGHTMARE_LEGGINGS);
        trimmedArmorItem(ModItems.FALSE_NIGHTMARE_BOOTS);

        trimmedArmorItem(ModItems.STORM_HELMET);
        trimmedArmorItem(ModItems.STORM_CHESTPLATE);
        trimmedArmorItem(ModItems.STORM_LEGGINGS);
        trimmedArmorItem(ModItems.STORM_BOOTS);

        trimmedArmorItem(ModItems.FALSE_STORM_HELMET);
        trimmedArmorItem(ModItems.FALSE_STORM_CHESTPLATE);
        trimmedArmorItem(ModItems.FALSE_STORM_LEGGINGS);
        trimmedArmorItem(ModItems.FALSE_STORM_BOOTS);

        // Other block-based item models
        buttonItem(ModBlocks.CORRUPTED_OAK_BUTTON, ModBlocks.CORRUPTED_OAK_PLANKS);
        fenceItem(ModBlocks.CORRUPTED_OAK_FENCE, ModBlocks.CORRUPTED_OAK_PLANKS);
        simpleBlockItem(ModBlocks.CORRUPTED_OAK_DOOR);

        buttonItem(ModBlocks.STEELIUM_BUTTON, ModBlocks.STEELIUM_BLOCK);
        wallItem(ModBlocks.STEELIUM_WALL, ModBlocks.STEELIUM_BLOCK);
        simpleBlockItem(ModBlocks.STEELIUM_DOOR);

        //withExistingParent(ModBlocks.STEELIUM_BARS.getId().getPath(), mcLoc("item/steelium_bars"));
        basicItem(Item.byBlock(ModBlocks.STEELIUM_BARS.get()));

        saplingItem(ModBlocks.CORRUPTED_OAK_SAPLING);

        wallItem(ModBlocks.INDIGO_BRICK_WALL, ModBlocks.INDIGO_BRICKS);

        withExistingParent(ModItems.TESTER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.ALIEN_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> block) {
        return withExistingParent(block.getId().getPath(), ResourceLocation.parse("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "block/" + block.getId().getPath()));
    }

    // Shoutout to El_Redstoniano for making this trimmed armor support
    private void trimmedArmorItem(DeferredItem<ModArmorItem> itemDeferred) {
        final String MOD_ID = TesterMod.MOD_ID; // Change this to your mod id if needed

        if (itemDeferred.get() instanceof ModArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.tryParse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.tryParse(trimPath);
                ResourceLocation trimNameResLoc = ResourceLocation.tryParse(currentTrimName);

                // Ensure the texture is recognized (this avoids potential IllegalArgumentExceptions)
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Build the trimmed armor model
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                // Set up the override for the non-trimmed (normal) variant
                this.withExistingParent(itemDeferred.getId().getPath(), mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace() + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue)
                        .end()
                        .texture("layer0", ResourceLocation.fromNamespaceAndPath(MOD_ID, "item/" + itemDeferred.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(), ResourceLocation.parse("item/handheld"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(DeferredBlock<?> block) {
        return withExistingParent(block.getId().getPath(), ResourceLocation.parse("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "item/" + block.getId().getPath()));
    }
}
