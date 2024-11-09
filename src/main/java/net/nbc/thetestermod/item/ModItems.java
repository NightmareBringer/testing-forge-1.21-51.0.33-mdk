package net.nbc.thetestermod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.item.custom.ChiselItem;
import net.nbc.thetestermod.item.custom.FuelItem;
import net.nbc.thetestermod.item.custom.HammerItem;

import java.util.List;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TesterMod.MOD_ID);

    public static final RegistryObject<Item> NIGHTMARITE = ITEMS.register("nightmarite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PURE_NIGHTMARITE = ITEMS.register("pure_nightmarite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NIGHTMARE_INGOT = ITEMS.register("nightmare_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NIGHTMARE_NUGGET = ITEMS.register("nightmare_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(64)));

    public static final RegistryObject<Item> KRABS = ITEMS.register("krabs",
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

    public static final RegistryObject<Item> IMPURE_STICK = ITEMS.register("impure_stick",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PURE_EYE= ITEMS.register("pure_eye",
            () -> new FuelItem(new Item.Properties(), 10525));
    public static final RegistryObject<Item> IMPURE_EYE= ITEMS.register("impure_eye",
            () -> new FuelItem(new Item.Properties(), 7600));

    public static final RegistryObject<Item> NIGHTMARE_SWORD = ITEMS.register("nightmare_sword",
            () -> new SwordItem(ModToolTiers.NIGHTMARE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.NIGHTMARE, 1, -1.65f))));
    public static final RegistryObject<Item> NIGHTMARE_PICKAXE = ITEMS.register("nightmare_pickaxe",
            () -> new PickaxeItem(ModToolTiers.NIGHTMARE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.NIGHTMARE, -1, -2.5f))));
    public static final RegistryObject<Item> NIGHTMARE_SHOVEL = ITEMS.register("nightmare_shovel",
            () -> new ShovelItem(ModToolTiers.NIGHTMARE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.NIGHTMARE, -2, -3.0f))));
    public static final RegistryObject<Item> NIGHTMARE_AXE = ITEMS.register("nightmare_axe",
            () -> new AxeItem(ModToolTiers.NIGHTMARE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.NIGHTMARE, 3.25f, -2.3f))));
    public static final RegistryObject<Item> NIGHTMARE_HOE = ITEMS.register("nightmare_hoe",
            () -> new HoeItem(ModToolTiers.NIGHTMARE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.NIGHTMARE, -7, 0f))));

    public static final RegistryObject<Item> NIGHTMARE_HAMMER = ITEMS.register("nightmare_hammer",
            () -> new HammerItem(ModToolTiers.NIGHTMARE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.NIGHTMARE, 8f, -3.5f))) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.testermod.nightmare_hammer1"));
                    pTooltipComponents.add(Component.translatable("tooltip.testermod.nightmare_hammer2"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    public static final RegistryObject<Item> NIGHTMARE_HELMET = ITEMS.register("nightmare_helmet",
            () -> new ArmorItem(ModArmorMaterials.NIGHTMARE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(50))));
    public static final RegistryObject<Item> NIGHTMARE_CHESTPLATE = ITEMS.register("nightmare_chestplate",
            () -> new ArmorItem(ModArmorMaterials.NIGHTMARE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(50))));
    public static final RegistryObject<Item> NIGHTMARE_LEGGINGS = ITEMS.register("nightmare_leggings",
            () -> new ArmorItem(ModArmorMaterials.NIGHTMARE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(50))));
    public static final RegistryObject<Item> NIGHTMARE_BOOTS = ITEMS.register("nightmare_boots",
            () -> new ArmorItem(ModArmorMaterials.NIGHTMARE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(50))));

    public static final RegistryObject<Item> STORM_INGOT = ITEMS.register("storm_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STORM_NUGGET = ITEMS.register("storm_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STORM_SWORD = ITEMS.register("storm_sword",
            () -> new SwordItem(ModToolTiers.STORM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.STORM, 2, -1.85f))));
    public static final RegistryObject<Item> STORM_PICKAXE = ITEMS.register("storm_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STORM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.STORM, 1, -2.7f))));
    public static final RegistryObject<Item> STORM_SHOVEL = ITEMS.register("storm_shovel",
            () -> new ShovelItem(ModToolTiers.STORM, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.STORM, 2, -3.2f))));
    public static final RegistryObject<Item> STORM_AXE = ITEMS.register("storm_axe",
            () -> new AxeItem(ModToolTiers.STORM, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.STORM, 4f, -2.5f))));
    public static final RegistryObject<Item> STORM_HOE = ITEMS.register("storm_hoe",
            () -> new HoeItem(ModToolTiers.STORM, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.STORM, -7, 0f))));

    public static final RegistryObject<Item> STORM_HAMMER = ITEMS.register("storm_hammer",
            () -> new HammerItem(ModToolTiers.STORM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.STORM, 10f, -3.5f))) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.testermod.storm_hammer1"));
                    pTooltipComponents.add(Component.translatable("tooltip.testermod.storm_hammer2"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    public static final RegistryObject<Item> STORM_HELMET = ITEMS.register("storm_helmet",
            () -> new ArmorItem(ModArmorMaterials.STORM_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(30))));
    public static final RegistryObject<Item> STORM_CHESTPLATE = ITEMS.register("storm_chestplate",
            () -> new ArmorItem(ModArmorMaterials.STORM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(30))));
    public static final RegistryObject<Item> STORM_LEGGINGS = ITEMS.register("storm_leggings",
            () -> new ArmorItem(ModArmorMaterials.STORM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(30))));
    public static final RegistryObject<Item> STORM_BOOTS = ITEMS.register("storm_boots",
            () -> new ArmorItem(ModArmorMaterials.STORM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(30))));


    public static final RegistryObject<Item> DEVILS_BLADE = ITEMS.register("devils_blade",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DEVILS_SNATH = ITEMS.register("devils_snath",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DEVILSKNIFE = ITEMS.register("devilsknife",
            () -> new AxeItem(ModToolTiers.DEVILSKNIFE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.DEVILSKNIFE, 7.66f, -2.9f))));


    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
