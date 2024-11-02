


package net.nbc.thetestermod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nbc.thetestermod.TesterMod;

import java.awt.*;
import java.util.Comparator;

public class ModCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TesterMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> THE_TESTER_ZONE_TAB = CREATIVE_MODE_TABS.register("the_tester_zone_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PURE_NIGHTMARITE.get()))
                    .title(Component.translatable("creativetab.testermod.the_tester_zone"))
                    .displayItems((itemDisplayParameters, output) -> {
                        //output.accept(ModItems.NIGHTMARITE.get());
                        // Add all items associated with the mod first
                        ForgeRegistries.ITEMS.getValues().stream()
                                .filter(item -> ForgeRegistries.ITEMS.getKey(item).getNamespace().equals(TesterMod.MOD_ID))
                                .forEach(output::accept);

                        // Add all block items associated with the mod after items
                        ForgeRegistries.BLOCKS.getValues().stream()
                                .filter(block -> ForgeRegistries.BLOCKS.getKey(block).getNamespace().equals(TesterMod.MOD_ID))
                                .map(block -> new ItemStack(block.asItem()))
                                .forEach(output::accept);

                    }).build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register((eventBus));
    }

}
