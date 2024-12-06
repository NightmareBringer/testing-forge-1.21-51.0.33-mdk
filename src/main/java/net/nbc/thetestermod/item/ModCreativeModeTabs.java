


package net.nbc.thetestermod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.ModBlocks;

public class ModCreativeModeTabs
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TesterMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> THE_TESTER_ZONE_TAB = CREATIVE_MODE_TABS.register("the_tester_zone_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PURE_NIGHTMARITE.get()))
                    .title(Component.translatable("creativetab.testermod.the_tester_zone"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.NIGHTMARITE.get());
                        output.accept(ModItems.PURE_NIGHTMARITE.get());
                        output.accept(ModBlocks.NIGHTMARITE_BLOCK.get());
                        output.accept(ModBlocks.PURE_NIGHTMARITE_BLOCK.get());
                        output.accept(ModBlocks.NIGHTMARITE_ORE.get());
                        output.accept(ModBlocks.NIGHTMARITE_DEEPSLATE_ORE.get());
                        output.accept(ModBlocks.NIGHTMARITE_NETHER_ORE.get());
                        output.accept(ModBlocks.NIGHTMARITE_END_ORE.get());
                        output.accept(ModItems.PURE_EYE.get());
                        output.accept(ModBlocks.MAGIC_BLOCK.get());
                        output.accept(ModItems.IMPURE_EYE.get());
                        output.accept(ModBlocks.ANTI_MAGIC_BLOCK.get());
                        output.accept(ModItems.IMPURE_STICK.get());
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
                        output.accept(ModBlocks.REFINED_NIGHTMARE_BLOCK.get());
                        output.accept(ModBlocks.REFINED_NIGHTMARE_WALL.get());
                        output.accept(ModBlocks.REFINED_NIGHTMARE_STAIRS.get());
                        output.accept(ModBlocks.REFINED_NIGHTMARE_SlAB.get());
                        output.accept(ModBlocks.REFINED_NIGHTMARE_FENCE.get());
                        output.accept(ModBlocks.REFINED_NIGHTMARE_FENCE_GATE.get());
                        output.accept(ModBlocks.REFINED_NIGHTMARE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.REFINED_NIGHTMARE_BUTTON.get());
                        output.accept(ModBlocks.NIGHTMARE_LAMP.get());
                        output.accept(ModItems.NIGHTMARE_BOW.get());
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
                        output.accept(ModItems.NIGHTEN_SMITHING_TEMPLATE.get());
                        output.accept(ModItems.NIGHTMARE_HORSE_ARMOR.get());
                        output.accept(ModItems.STORMITE.get());
                        output.accept(ModItems.IMPURE_STORMITE.get());
                        output.accept(ModBlocks.STORMITE_ORE.get());
                        output.accept(ModBlocks.STORMITE_DEEPSLATE_ORE.get());
                        output.accept(ModBlocks.STORM_NETHER_ORE.get());
                        output.accept(ModBlocks.STORM_END_ORE.get());
                        output.accept(ModItems.STORM_INGOT.get());
                        output.accept(ModItems.STORM_NUGGET.get());
                        output.accept(ModBlocks.STORM_BLOCK.get());
                        output.accept(ModBlocks.STORM_WALL.get());
                        output.accept(ModBlocks.STORM_STAIRS.get());
                        output.accept(ModBlocks.STORM_SlAB.get());
                        output.accept(ModBlocks.STORM_FENCE.get());
                        output.accept(ModBlocks.STORM_FENCE_GATE.get());
                        output.accept(ModBlocks.STORM_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.STORM_BUTTON.get());
                        output.accept(ModBlocks.STORM_DOOR.get());
                        output.accept(ModBlocks.STORM_TRAPDOOR.get());
                        output.accept(ModBlocks.STORM_LAMP.get());
                        output.accept(ModItems.STORM_BOW.get());
                        output.accept(ModItems.STORM_SWORD.get());
                        output.accept(ModItems.STORM_PICKAXE.get());
                        output.accept(ModItems.STORM_AXE.get());
                        output.accept(ModItems.STORM_SHOVEL.get());
                        output.accept(ModItems.STORM_HOE.get());
                        output.accept(ModItems.STORM_HAMMER.get());
                        output.accept(ModItems.STORM_HELMET.get());
                        output.accept(ModItems.STORM_CHESTPLATE.get());
                        output.accept(ModItems.STORM_LEGGINGS.get());
                        output.accept(ModItems.STORM_BOOTS.get());
                        output.accept(ModItems.STORMEN_SMITHING_TEMPLATE.get());
                        output.accept(ModItems.STORM_HORSE_ARMOR.get());
                        output.accept((ModItems.WHITE_CARROT.get()));
                        output.accept((ModItems.GLISTERING_CARROT.get()));
                        output.accept((ModItems.CRIMSON_BLUE_BERRIES.get()));


                        output.accept(ModItems.DEVILS_SNATH.get());
                        output.accept(ModItems.DEVILS_BLADE.get());
                        output.accept(ModItems.DEVILSKNIFE.get());
                        output.accept(ModItems.CHISEL.get());
                        output.accept(ModItems.KRABS.get());
                        output.accept(ModItems.HAIL_SQUIDWARD_MUSIC_DISC.get());

                    }).build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register((eventBus));
    }

}
