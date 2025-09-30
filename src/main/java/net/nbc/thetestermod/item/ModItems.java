package net.nbc.thetestermod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.entity.ModEntities;
import net.nbc.thetestermod.item.custom.*;
import net.nbc.thetestermod.sound.ModSounds;

import java.util.List;

public class ModItems
{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TesterMod.MOD_ID);

    public static final DeferredItem<Item> NIGHTMARITE = ITEMS.register("nightmarite",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PURE_NIGHTMARITE = ITEMS.register("pure_nightmarite",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> NIGHTMARE_INGOT = ITEMS.register("nightmare_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> NIGHTMARE_NUGGET = ITEMS.register("nightmare_nugget",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(2)));

    public static final DeferredItem<Item> KRABS = ITEMS.register("krabs",
            () -> new Item(new Item.Properties().food(ModFoodProperties.KRABS)) {
                //how to add a custom tooltip to other items
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.testermod.krabs1"));
                    pTooltipComponents.add(Component.translatable("tooltip.testermod.krabs2"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });
            //;

    public static final DeferredItem<Item> WHITE_CARROT = ITEMS.register("white_carrot",
            () -> new ItemNameBlockItem(ModBlocks.WHITE_CARROT_CROP.get(), new Item.Properties().food(ModFoodProperties.WHITE_CARROT)));

    public static final DeferredItem<Item> CRIMSON_BLUE_BERRIES = ITEMS.register("crimson_blue_berries",
            () -> new ItemNameBlockItem(ModBlocks.CRIMSON_BLUE_BERRY_BUSH.get(), new Item.Properties().food(ModFoodProperties.CRIMSON_BLUE_BERRIES)));

    public static final DeferredItem<Item> GLISTERING_CARROT = ITEMS.register("glistering_carrot",
            () -> new Item(new Item.Properties().food(ModFoodProperties.GLISTERING_CARROT)));



    public static final DeferredItem<Item> IMPURE_STICK = ITEMS.register("impure_stick",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PURE_EYE= ITEMS.register("pure_eye",
            () -> new FuelItem(new Item.Properties(), 10525));
    public static final DeferredItem<Item> IMPURE_EYE= ITEMS.register("impure_eye",
            () -> new FuelItem(new Item.Properties(), 7600));

    public static final DeferredItem<SwordItem> NIGHTMARE_SWORD = ITEMS.register("nightmare_sword",
            () -> new SwordItem(ModToolTiers.NIGHTMARE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.NIGHTMARE, 1, -2.5f))));
    public static final DeferredItem<PickaxeItem> NIGHTMARE_PICKAXE = ITEMS.register("nightmare_pickaxe",
            () -> new PickaxeItem(ModToolTiers.NIGHTMARE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.NIGHTMARE, -1, -2.6f))));
    public static final DeferredItem<ShovelItem> NIGHTMARE_SHOVEL = ITEMS.register("nightmare_shovel",
            () -> new ShovelItem(ModToolTiers.NIGHTMARE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.NIGHTMARE, -2, -3f))));
    public static final DeferredItem<AxeItem> NIGHTMARE_AXE = ITEMS.register("nightmare_axe",
            () -> new AxeItem(ModToolTiers.NIGHTMARE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.NIGHTMARE, 4f, -2.6f))));
    public static final DeferredItem<HoeItem> NIGHTMARE_HOE = ITEMS.register("nightmare_hoe",
            () -> new HoeItem(ModToolTiers.NIGHTMARE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.NIGHTMARE, -7, 0f))));

    public static final DeferredItem<Item> NIGHTMARE_HAMMER = ITEMS.register("nightmare_hammer",
            () -> new HammerItem(ModToolTiers.NIGHTMARE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.NIGHTMARE, 8f, -3.5f))) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.testermod.nightmare_hammer1"));
                    pTooltipComponents.add(Component.translatable("tooltip.testermod.nightmare_hammer2"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    public static final DeferredItem<SwordItem> PURE_NIGHTMARE_SWORD = ITEMS.register("pure_nightmare_sword",
            () -> new SwordItem(ModToolTiers.PURE_NIGHTMARE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.PURE_NIGHTMARE, 2, -2.2f))));
    public static final DeferredItem<PickaxeItem> PURE_NIGHTMARE_PICKAXE = ITEMS.register("pure_nightmare_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PURE_NIGHTMARE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.PURE_NIGHTMARE, 1, -2.5f))));
    public static final DeferredItem<ShovelItem> PURE_NIGHTMARE_SHOVEL = ITEMS.register("pure_nightmare_shovel",
            () -> new ShovelItem(ModToolTiers.PURE_NIGHTMARE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.PURE_NIGHTMARE, 2, -2.8f))));
    public static final DeferredItem<AxeItem> PURE_NIGHTMARE_AXE = ITEMS.register("pure_nightmare_axe",
            () -> new AxeItem(ModToolTiers.PURE_NIGHTMARE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.PURE_NIGHTMARE, 4f, -2.4f))));
    public static final DeferredItem<HoeItem> PURE_NIGHTMARE_HOE = ITEMS.register("pure_nightmare_hoe",
            () -> new HoeItem(ModToolTiers.PURE_NIGHTMARE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.PURE_NIGHTMARE, -7, 0f))));
    public static final DeferredItem<Item> PURE_NIGHTMARE_HAMMER = ITEMS.register("pure_nightmare_hammer",
            () -> new HammerItem(ModToolTiers.PURE_NIGHTMARE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.PURE_NIGHTMARE, 10f, -3.4f))) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.testermod.nightmare_hammer1"));
                    pTooltipComponents.add(Component.translatable("tooltip.testermod.nightmare_hammer2"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    public static final DeferredItem<ModArmorItem> NIGHTMARE_HELMET = ITEMS.register("nightmare_helmet",
            () -> new ModArmorItem(ModArmorMaterials.NIGHTMARE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(38))));
    public static final DeferredItem<ModArmorItem> NIGHTMARE_CHESTPLATE = ITEMS.register("nightmare_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.NIGHTMARE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(38))));
    public static final DeferredItem<ModArmorItem> NIGHTMARE_LEGGINGS = ITEMS.register("nightmare_leggings",
            () -> new ModArmorItem(ModArmorMaterials.NIGHTMARE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(38))));
    public static final DeferredItem<ModArmorItem> NIGHTMARE_BOOTS = ITEMS.register("nightmare_boots",
            () -> new ModArmorItem(ModArmorMaterials.NIGHTMARE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(38))));

    public static final DeferredItem<Item> STORMITE = ITEMS.register("stormite",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> IMPURE_STORMITE = ITEMS.register("impure_stormite",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> STORM_INGOT = ITEMS.register("storm_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> STORM_NUGGET = ITEMS.register("storm_nugget",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<SwordItem> STORM_SWORD = ITEMS.register("storm_sword",
            () -> new SwordItem(ModToolTiers.STORM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.STORM, 2, -2.4f))));
    public static final DeferredItem<PickaxeItem> STORM_PICKAXE = ITEMS.register("storm_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STORM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.STORM, 1, -2.7f))));
    public static final DeferredItem<ShovelItem> STORM_SHOVEL = ITEMS.register("storm_shovel",
            () -> new ShovelItem(ModToolTiers.STORM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.STORM, 2, -2.9f))));
    public static final DeferredItem<AxeItem> STORM_AXE = ITEMS.register("storm_axe",
            () -> new AxeItem(ModToolTiers.STORM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.STORM, 4f, -2.7f))));
    public static final DeferredItem<HoeItem> STORM_HOE = ITEMS.register("storm_hoe",
            () -> new HoeItem(ModToolTiers.STORM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.STORM, -7, 0f))));
    public static final DeferredItem<Item> STORM_HAMMER = ITEMS.register("storm_hammer",
            () -> new HammerItem(ModToolTiers.STORM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.STORM, 10f, -3.4f))) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.testermod.storm_hammer1"));
                    pTooltipComponents.add(Component.translatable("tooltip.testermod.storm_hammer2"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    public static final DeferredItem<SwordItem> PURE_STORM_SWORD = ITEMS.register("pure_storm_sword",
            () -> new SwordItem(ModToolTiers.PURE_STORM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.PURE_STORM, 2, -2.3f))));
    public static final DeferredItem<PickaxeItem> PURE_STORM_PICKAXE = ITEMS.register("pure_storm_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PURE_STORM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.PURE_STORM, 1, -2.8f))));
    public static final DeferredItem<ShovelItem> PURE_STORM_SHOVEL = ITEMS.register("pure_storm_shovel",
            () -> new ShovelItem(ModToolTiers.PURE_STORM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.PURE_STORM, 2, -3f))));
    public static final DeferredItem<AxeItem> PURE_STORM_AXE = ITEMS.register("pure_storm_axe",
            () -> new AxeItem(ModToolTiers.PURE_STORM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.PURE_STORM, 4f, -2.8f))));
    public static final DeferredItem<HoeItem> PURE_STORM_HOE = ITEMS.register("pure_storm_hoe",
            () -> new HoeItem(ModToolTiers.PURE_STORM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.PURE_STORM, -7, 0f))));
    public static final DeferredItem<Item> PURE_STORM_HAMMER = ITEMS.register("pure_storm_hammer",
            () -> new HammerItem(ModToolTiers.PURE_STORM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.PURE_STORM, 10f, -3.5f))) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.testermod.storm_hammer1"));
                    pTooltipComponents.add(Component.translatable("tooltip.testermod.storm_hammer2"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    public static final DeferredItem<ModArmorItem> STORM_HELMET = ITEMS.register("storm_helmet",
            () -> new ModArmorItem(ModArmorMaterials.STORM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(34))));
    public static final DeferredItem<ModArmorItem> STORM_CHESTPLATE = ITEMS.register("storm_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.STORM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(34))));
    public static final DeferredItem<ModArmorItem> STORM_LEGGINGS = ITEMS.register("storm_leggings",
            () -> new ModArmorItem(ModArmorMaterials.STORM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(34))));
    public static final DeferredItem<ModArmorItem> STORM_BOOTS = ITEMS.register("storm_boots",
            () -> new ModArmorItem(ModArmorMaterials.STORM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(34))));

    public static final DeferredItem<Item> DEVILS_BLADE = ITEMS.register("devils_blade",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DEVILS_SNATH = ITEMS.register("devils_snath",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<AxeItem> DEVILSKNIFE = ITEMS.register("devilsknife",
            () -> new AxeItem(ModToolTiers.DEVILSKNIFE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.DEVILSKNIFE, 7.66f, -2.9f))));

    public  static final DeferredItem<Item> NIGHTMARE_HORSE_ARMOR = ITEMS.register("nightmare_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.NIGHTMARE_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN,
                    false, new Item.Properties().stacksTo(64)));

    public  static final DeferredItem<Item> STORM_HORSE_ARMOR = ITEMS.register("storm_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.STORM_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN,
                    false, new Item.Properties().stacksTo(64)));

    public static final DeferredItem<Item> NIGHTEN_SMITHING_TEMPLATE = ITEMS.register("nighten_armor_trim_smithing_template",
            () -> SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "nighten")));
    public static final DeferredItem<Item> STORMEN_SMITHING_TEMPLATE = ITEMS.register("stormen_armor_trim_smithing_template",
            () -> SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "stormen")));

    // Both nightmare and storm bows are unused in-game as of the 1.2.5 update
    // due to them using stolen art, of which I am also too lazy to redo, (all of those textures should be removed now)
    // and for the fact that they are just regular bows with no difference
    // from vanilla ones, might come back to these at a later update (with updated textures of course)
    public static final DeferredItem<Item> NIGHTMARE_BOW = ITEMS.register("nightmare_bow",
            () -> new BowItem(new Item.Properties().durability(500)));
    public static final DeferredItem<Item> STORM_BOW = ITEMS.register("storm_bow",
            () -> new BowItem(new Item.Properties().durability(250)));

    public static final DeferredItem<Item> HAIL_SQUIDWARD_MUSIC_DISC = ITEMS.register("all_hail_squidward_music_disc",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.HAIL_SQUIDWARD_KEY).stacksTo(1)));

    public static final DeferredItem<Item> MYSTERIOUS_DUST = ITEMS.register("mysterious_dust",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> MYSTERIOUS_STRING = ITEMS.register("mysterious_string",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> STRANGE_STICK = ITEMS.register("strange_stick",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> TESTER_SPAWN_EGG = ITEMS.register("tester_spawn_egg",
            () -> new SpawnEggItem(ModEntities.TESTER_MOB.get(), 0xfafafa, 0x00b1ff , new Item.Properties()));

    public static final DeferredItem<Item> THROWING_KNIFE = ITEMS.register("throwing_knife",
            () -> new ThrowingKnifeItem(new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.KNIFE, 1, -1.0f))
                    .stacksTo(4)));

    public static final DeferredItem<Item> ENERGY_ORB = ITEMS.register("orb_of_energy",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> INDIGO_DUST = ITEMS.register("indigo_dust",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> INDIGO_BRICK = ITEMS.register("indigo_brick",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PURE_STICK = ITEMS.register("pure_stick",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PURE_STORMITE = ITEMS.register("pure_stormite",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IMPURE_NIGHTMARITE = ITEMS.register("impure_nightmarite",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> FALSE_STORMITE_INGOT = ITEMS.register("false_stormite_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> FALSE_NIGHTMARITE_INGOT = ITEMS.register("false_nightmarite_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<SwordItem> FALSE_NIGHTMARE_SWORD = ITEMS.register("false_nightmarite_sword",
            () -> new SwordItem(ModToolTiers.FALSE_NIGHTMARE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.FALSE_NIGHTMARE, 2, -2.8f))));
    public static final DeferredItem<PickaxeItem> FALSE_NIGHTMARE_PICKAXE = ITEMS.register("false_nightmarite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.FALSE_NIGHTMARE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.FALSE_NIGHTMARE, 1, -2.9f))));
    public static final DeferredItem<ShovelItem> FALSE_NIGHTMARE_SHOVEL = ITEMS.register("false_nightmarite_shovel",
            () -> new ShovelItem(ModToolTiers.FALSE_NIGHTMARE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.FALSE_NIGHTMARE, 2, -3f))));
    public static final DeferredItem<AxeItem> FALSE_NIGHTMARE_AXE = ITEMS.register("false_nightmarite_axe",
            () -> new AxeItem(ModToolTiers.FALSE_NIGHTMARE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.FALSE_NIGHTMARE, 4f, -3f))));
    public static final DeferredItem<HoeItem> FALSE_NIGHTMARE_HOE = ITEMS.register("false_nightmarite_hoe",
            () -> new HoeItem(ModToolTiers.FALSE_NIGHTMARE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.FALSE_NIGHTMARE, -4, 0f))));

    public static final DeferredItem<SwordItem> FALSE_STORM_SWORD = ITEMS.register("false_stormite_sword",
            () -> new SwordItem(ModToolTiers.FALSE_STORM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.FALSE_STORM, 2, -2.6f))));
    public static final DeferredItem<PickaxeItem> FALSE_STORM_PICKAXE = ITEMS.register("false_stormite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.FALSE_STORM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.FALSE_STORM, 1, -2.8f))));
    public static final DeferredItem<ShovelItem> FALSE_STORM_SHOVEL = ITEMS.register("false_stormite_shovel",
            () -> new ShovelItem(ModToolTiers.FALSE_STORM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.FALSE_STORM, 2, -3f))));
    public static final DeferredItem<AxeItem> FALSE_STORM_AXE = ITEMS.register("false_stormite_axe",
            () -> new AxeItem(ModToolTiers.FALSE_STORM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.FALSE_STORM, 4f, -3f))));
    public static final DeferredItem<HoeItem> FALSE_STORM_HOE = ITEMS.register("false_stormite_hoe",
            () -> new HoeItem(ModToolTiers.FALSE_STORM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.FALSE_STORM, -5, 0f))));

    public static final DeferredItem<ModArmorItem> FALSE_STORM_HELMET = ITEMS.register("false_stormite_helmet",
            () -> new ModArmorItem(ModArmorMaterials.FALSE_STORM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(24))));
    public static final DeferredItem<ModArmorItem> FALSE_STORM_CHESTPLATE = ITEMS.register("false_stormite_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.FALSE_STORM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(24))));
    public static final DeferredItem<ModArmorItem> FALSE_STORM_LEGGINGS = ITEMS.register("false_stormite_leggings",
            () -> new ModArmorItem(ModArmorMaterials.FALSE_STORM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(24))));
    public static final DeferredItem<ModArmorItem> FALSE_STORM_BOOTS = ITEMS.register("false_stormite_boots",
            () -> new ModArmorItem(ModArmorMaterials.FALSE_STORM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(24))));

    public static final DeferredItem<ModArmorItem> FALSE_NIGHTMARE_HELMET = ITEMS.register("false_nightmarite_helmet",
            () -> new ModArmorItem(ModArmorMaterials.FALSE_NIGHTMARE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(22))));
    public static final DeferredItem<ModArmorItem> FALSE_NIGHTMARE_CHESTPLATE = ITEMS.register("false_nightmarite_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.FALSE_NIGHTMARE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(22))));
    public static final DeferredItem<ModArmorItem> FALSE_NIGHTMARE_LEGGINGS = ITEMS.register("false_nightmarite_leggings",
            () -> new ModArmorItem(ModArmorMaterials.FALSE_NIGHTMARE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(22))));
    public static final DeferredItem<ModArmorItem> FALSE_NIGHTMARE_BOOTS = ITEMS.register("false_nightmarite_boots",
            () -> new ModArmorItem(ModArmorMaterials.FALSE_NIGHTMARE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(22))));

    public static final DeferredItem<PickaxeItem> STEELICHROME_PICKAXE = ITEMS.register("steelichrome_pickaxe",
            () -> new SpecialPickaxeItem(ModToolTiers.STEELIUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.STEELIUM, 1, -2.9f))));

    public static final DeferredItem<Item> STEELICHROME_KEYS = ITEMS.register("steelichrome_keys",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> ALIEN_SPAWN_EGG = ITEMS.register("alien_spawn_egg",
            () -> new SpawnEggItem(ModEntities.ALIEN_MOB.get(), 0x000000, 0xfafafa, new Item.Properties()));

    public static final DeferredItem<Item> ARMORED_ALIEN_SPAWN_EGG = ITEMS.register("armored_alien_spawn_egg",
            () -> new SpawnEggItem(ModEntities.ARMORED_ALIEN_MOB.get(), 0x000000, 0x00b1ff, new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
