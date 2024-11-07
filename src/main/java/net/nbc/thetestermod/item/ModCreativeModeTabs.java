


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
import net.nbc.thetestermod.block.ModBlocks;

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
                        output.accept(ModItems.PURE_EYE.get());
                        output.accept(ModItems.NIGHTMARITE.get());
                        output.accept(ModItems.PURE_NIGHTMARITE.get());
                        output.accept(ModBlocks.NIGHTMARITE_BLOCK.get());
                        output.accept(ModBlocks.PURE_NIGHTMARITE_BLOCK.get());
                        output.accept(ModBlocks.NIGHTMARITE_ORE.get());
                        output.accept(ModBlocks.NIGHTMARITE_DEEPSLATE_ORE.get());
                        output.accept(ModItems.NIGHTMARE_INGOT.get());
                        output.accept(ModItems.NIGHTMARE_NUGGET.get());
                        output.accept(ModBlocks.NIGHTMARE_BLOCK.get());
                        output.accept(ModBlocks.NIGHTMARE_WALL.get());
                        output.accept(ModBlocks.NIGHTMARE_STAIRS.get());
                        output.accept(ModBlocks.NIGHTMARE_SlAB.get());
                        output.accept(ModBlocks.NIGHTMARE_FENCE.get());
                        output.accept(ModBlocks.NIGHTMARE_FENCE_GATE.get());
                        output.accept(ModBlocks.NIGHTMARE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.NIGHTMARE_BUTTON.get());
                        output.accept(ModBlocks.NIGHTMARE_DOOR.get());
                        output.accept(ModBlocks.NIGHTMARE_TRAPDOOR.get());
                        output.accept(ModItems.NIGHTMARE_SWORD.get());
                        output.accept(ModItems.NIGHTMARE_PICKAXE.get());
                        output.accept(ModItems.NIGHTMARE_AXE.get());
                        output.accept(ModItems.NIGHTMARE_SHOVEL.get());
                        output.accept(ModItems.NIGHTMARE_HOE.get());
                        output.accept(ModItems.NIGHTMARE_HAMMER.get());
                        output.accept(ModItems.NIGHTMARE_HELMET.get());
                        output.accept(ModItems.NIGHTMARE_CHESTPLATE.get());
                        output.accept(ModItems.NIGHTMARE_LEGGINGS.get());
                        output.accept(ModItems.NIGHTMARE_BOOTS.get());
                        output.accept(ModItems.CHISEL.get());
                        output.accept(ModItems.KRABS.get());

                    }).build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register((eventBus));
    }

}
