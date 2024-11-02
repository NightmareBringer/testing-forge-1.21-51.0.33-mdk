package net.nbc.thetestermod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nbc.thetestermod.TesterMod;

public class Moditems
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TesterMod.MOD_ID);

    public static final RegistryObject<Item> NIGHTMARITE = ITEMS.register("nightmarite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PURE_NIGHTMARITE = ITEMS.register("pure_nightmarite",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
