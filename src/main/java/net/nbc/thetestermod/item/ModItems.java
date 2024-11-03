package net.nbc.thetestermod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.item.custom.ChiselItem;
import net.nbc.thetestermod.item.custom.FuelItem;

import java.util.List;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TesterMod.MOD_ID);

    public static final RegistryObject<Item> NIGHTMARITE = ITEMS.register("nightmarite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PURE_NIGHTMARITE = ITEMS.register("pure_nightmarite",
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
            ;

    public static final RegistryObject<Item> PURE_EYE= ITEMS.register("pure_eye",
            () -> new FuelItem(new Item.Properties(), 10000));


    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
