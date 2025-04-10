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

    public static final DeferredItem<EnchantableSwordItem> NIGHTMARE_SWORD = ITEMS.register("nightmare_sword",
            () -> new EnchantableSwordItem(ModToolTiers.NIGHTMARE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.NIGHTMARE, 1, -1.65f))));
    public static final DeferredItem<EnchantablePickaxeItem> NIGHTMARE_PICKAXE = ITEMS.register("nightmare_pickaxe",
            () -> new EnchantablePickaxeItem(ModToolTiers.NIGHTMARE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.NIGHTMARE, -1, -2.5f))));
    public static final DeferredItem<EnchantableShovelItem> NIGHTMARE_SHOVEL = ITEMS.register("nightmare_shovel",
            () -> new EnchantableShovelItem(ModToolTiers.NIGHTMARE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.NIGHTMARE, -2, -3.0f))));
    public static final DeferredItem<EnchantableAxeItem> NIGHTMARE_AXE = ITEMS.register("nightmare_axe",
            () -> new EnchantableAxeItem(ModToolTiers.NIGHTMARE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.NIGHTMARE, 3.25f, -2.3f))));
    public static final DeferredItem<EnchantableHoeItem> NIGHTMARE_HOE = ITEMS.register("nightmare_hoe",
            () -> new EnchantableHoeItem(ModToolTiers.NIGHTMARE, new Item.Properties()
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

    public static final DeferredItem<EnchantableArmorItem> NIGHTMARE_HELMET = ITEMS.register("nightmare_helmet",
            () -> new EnchantableArmorItem(ModArmorMaterials.NIGHTMARE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(50))));
    public static final DeferredItem<EnchantableArmorItem> NIGHTMARE_CHESTPLATE = ITEMS.register("nightmare_chestplate",
            () -> new EnchantableArmorItem(ModArmorMaterials.NIGHTMARE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(50))));
    public static final DeferredItem<EnchantableArmorItem> NIGHTMARE_LEGGINGS = ITEMS.register("nightmare_leggings",
            () -> new EnchantableArmorItem(ModArmorMaterials.NIGHTMARE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(50))));
    public static final DeferredItem<EnchantableArmorItem> NIGHTMARE_BOOTS = ITEMS.register("nightmare_boots",
            () -> new EnchantableArmorItem(ModArmorMaterials.NIGHTMARE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(50))));

    public static final DeferredItem<Item> STORMITE = ITEMS.register("stormite",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> IMPURE_STORMITE = ITEMS.register("impure_stormite",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> STORM_INGOT = ITEMS.register("storm_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> STORM_NUGGET = ITEMS.register("storm_nugget",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<EnchantableSwordItem> STORM_SWORD = ITEMS.register("storm_sword",
            () -> new EnchantableSwordItem(ModToolTiers.STORM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.STORM, 2, -1.85f))));
    public static final DeferredItem<EnchantablePickaxeItem> STORM_PICKAXE = ITEMS.register("storm_pickaxe",
            () -> new EnchantablePickaxeItem(ModToolTiers.STORM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.STORM, 1, -2.7f))));
    public static final DeferredItem<EnchantableShovelItem> STORM_SHOVEL = ITEMS.register("storm_shovel",
            () -> new EnchantableShovelItem(ModToolTiers.STORM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.STORM, 2, -3.2f))));
    public static final DeferredItem<EnchantableAxeItem> STORM_AXE = ITEMS.register("storm_axe",
            () -> new EnchantableAxeItem(ModToolTiers.STORM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.STORM, 4f, -2.5f))));
    public static final DeferredItem<EnchantableHoeItem> STORM_HOE = ITEMS.register("storm_hoe",
            () -> new EnchantableHoeItem(ModToolTiers.STORM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.STORM, -7, 0f))));

    public static final DeferredItem<Item> STORM_HAMMER = ITEMS.register("storm_hammer",
            () -> new HammerItem(ModToolTiers.STORM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.STORM, 10f, -3.5f))) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.testermod.storm_hammer1"));
                    pTooltipComponents.add(Component.translatable("tooltip.testermod.storm_hammer2"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    public static final DeferredItem<EnchantableArmorItem> STORM_HELMET = ITEMS.register("storm_helmet",
            () -> new EnchantableArmorItem(ModArmorMaterials.STORM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(30))));
    public static final DeferredItem<EnchantableArmorItem> STORM_CHESTPLATE = ITEMS.register("storm_chestplate",
            () -> new EnchantableArmorItem(ModArmorMaterials.STORM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(30))));
    public static final DeferredItem<EnchantableArmorItem> STORM_LEGGINGS = ITEMS.register("storm_leggings",
            () -> new EnchantableArmorItem(ModArmorMaterials.STORM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(30))));
    public static final DeferredItem<EnchantableArmorItem> STORM_BOOTS = ITEMS.register("storm_boots",
            () -> new EnchantableArmorItem(ModArmorMaterials.STORM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(30))));


    public static final DeferredItem<Item> DEVILS_BLADE = ITEMS.register("devils_blade",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DEVILS_SNATH = ITEMS.register("devils_snath",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<EnchantableAxeItem> DEVILSKNIFE = ITEMS.register("devilsknife",
            () -> new EnchantableAxeItem(ModToolTiers.DEVILSKNIFE, new Item.Properties()
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
                    .attributes(EnchantableSwordItem.createAttributes(ModToolTiers.KNIFE, 1, -1.0f))
                    .stacksTo(4)));

    public static final DeferredItem<Item> ENERGY_ORB = ITEMS.register("orb_of_energy",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> INDIGO_DUST = ITEMS.register("indigo_dust",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> INDIGO_BRICK = ITEMS.register("indigo_brick",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
