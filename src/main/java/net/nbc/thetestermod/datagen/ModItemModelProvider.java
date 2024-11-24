package net.nbc.thetestermod.datagen;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
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
        basicItem(ModItems.NIGHTMARITE.get());
        basicItem(ModItems.PURE_NIGHTMARITE.get());
        basicItem(ModItems.NIGHTMARE_INGOT.get());
        basicItem(ModItems.NIGHTMARE_NUGGET.get());
        basicItem(ModItems.STORMITE.get());
        basicItem(ModItems.IMPURE_STORMITE.get());
        basicItem(ModItems.STORM_INGOT.get());
        basicItem(ModItems.STORM_NUGGET.get());

        basicItem(ModItems.NIGHTMARE_HORSE_ARMOR.get());
        basicItem(ModItems.STORM_HORSE_ARMOR.get());

        //basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.KRABS.get());
        basicItem(ModItems.PURE_EYE.get());
        basicItem(ModItems.IMPURE_EYE.get());
        basicItem(ModItems.IMPURE_STICK.get());
        basicItem(ModItems.DEVILS_SNATH.get());
        basicItem(ModItems.DEVILS_BLADE.get());

        basicItem(ModItems.NIGHTEN_SMITHING_TEMPLATE.get());
        basicItem(ModItems.STORMEN_SMITHING_TEMPLATE.get());

        basicItem(ModItems.HAIL_SQUIDWARD_MUSIC_DISC.get());

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

        handheldItem(ModItems.NIGHTMARE_SWORD);
        handheldItem(ModItems.NIGHTMARE_PICKAXE);
        handheldItem(ModItems.NIGHTMARE_SHOVEL);
        handheldItem(ModItems.NIGHTMARE_AXE);
        handheldItem(ModItems.NIGHTMARE_HOE);
        handheldItem(ModItems.NIGHTMARE_HAMMER);

        handheldItem(ModItems.STORM_SWORD);
        handheldItem(ModItems.STORM_PICKAXE);
        handheldItem(ModItems.STORM_SHOVEL);
        handheldItem(ModItems.STORM_AXE);
        handheldItem(ModItems.STORM_HOE);
        handheldItem(ModItems.STORM_HAMMER);

        handheldItem(ModItems.DEVILSKNIFE);

        trimmedArmorItem(ModItems.NIGHTMARE_HELMET);
        trimmedArmorItem(ModItems.NIGHTMARE_CHESTPLATE);
        trimmedArmorItem(ModItems.NIGHTMARE_LEGGINGS);
        trimmedArmorItem(ModItems.NIGHTMARE_BOOTS);

        trimmedArmorItem(ModItems.STORM_HELMET);
        trimmedArmorItem(ModItems.STORM_CHESTPLATE);
        trimmedArmorItem(ModItems.STORM_LEGGINGS);
        trimmedArmorItem(ModItems.STORM_BOOTS);
    }

    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = TesterMod.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
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
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void buttonItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void fenceItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<? extends Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
