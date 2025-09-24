package net.nbc.thetestermod;

import io.netty.util.Attribute;
import net.minecraft.client.gui.screens.MenuScreens;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.block.entity.ModBlockEntities;
import net.nbc.thetestermod.block.entity.renderer.PedestalBlockEntityRenderer;
import net.nbc.thetestermod.component.ModDataComponentTypes;
import net.nbc.thetestermod.effect.ModEffects;
import net.nbc.thetestermod.enchantment.ModEnchantmentEffects;
import net.nbc.thetestermod.entity.ModEntities;
import net.nbc.thetestermod.entity.client.*;
import net.nbc.thetestermod.item.ModCreativeModeTabs;
import net.nbc.thetestermod.item.ModItems;
import net.nbc.thetestermod.loot.ModLootConditions;
import net.nbc.thetestermod.loot.ModLootModifiers;
import net.nbc.thetestermod.particle.ShineParticles;
import net.nbc.thetestermod.particle.ModParticles;
import net.nbc.thetestermod.potion.ModPotions;
import net.nbc.thetestermod.recipe.ModRecipes;
import net.nbc.thetestermod.screen.ModMenuTypes;
import net.nbc.thetestermod.screen.custom.ImpurifierBlockScreen;
import net.nbc.thetestermod.screen.custom.PurifierBlockScreen;
import net.nbc.thetestermod.sound.ModSounds;
import net.nbc.thetestermod.util.ModItemProperties;
import net.nbc.thetestermod.villager.ModVillagers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/mods.toml file
@SuppressWarnings("removal")
@Mod(TesterMod.MOD_ID)
public class TesterMod
{
    public static final String MOD_ID = "testermod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public TesterMod(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModDataComponentTypes.register(modEventBus);
        ModSounds.register(modEventBus);

        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);

        ModEnchantmentEffects.register(modEventBus);
        ModEntities.register(modEventBus);

        ModVillagers.register(modEventBus);
        ModParticles.register(modEventBus);

        ModLootModifiers.register(modEventBus);
        ModLootConditions.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModMenuTypes.register(modEventBus);
        ModRecipes.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ModItemProperties.addCustomItemProperties();

            EntityRenderers.register(ModEntities.TESTER_MOB.get(), TesterRenderer::new);
            EntityRenderers.register(ModEntities.ALIEN_MOB.get(), AlienRenderer::new);
            EntityRenderers.register(ModEntities.ARMORED_ALIEN_MOB.get(), ArmoredAlienRenderer::new);
            EntityRenderers.register(ModEntities.THROWING_KNIFE.get(), ThrowingKnifeProjectileRenderer::new);
            EntityRenderers.register(ModEntities.CHAIR_ENT.get(), ChairEntRenderer::new);
        }

        @SubscribeEvent
        public static void registerParticleProvider(RegisterParticleProvidersEvent event) {
            event.registerSpriteSet(ModParticles.SHINE_PARTICLES.get(), ShineParticles.Provider::new);
        }

        @SubscribeEvent
        public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.PEDESTAL_BE.get(), PedestalBlockEntityRenderer::new);
        }

        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(ModMenuTypes.PURIFIER_BLOCK_MENU.get(), PurifierBlockScreen::new);
            event.register(ModMenuTypes.IMPURIFIER_BLOCK_MENU.get(), ImpurifierBlockScreen::new);
        }
    }
}
