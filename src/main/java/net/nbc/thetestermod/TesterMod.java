package net.nbc.thetestermod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.component.ModDataComponentTypes;
import net.nbc.thetestermod.effect.ModEffects;
import net.nbc.thetestermod.enchantment.ModEnchantmentEffects;
import net.nbc.thetestermod.entity.ModEntities;
import net.nbc.thetestermod.entity.client.ChairEntRenderer;
import net.nbc.thetestermod.entity.client.TesterRenderer;
import net.nbc.thetestermod.entity.client.ThrowingKnifeProjectileRenderer;
import net.nbc.thetestermod.item.ModItems;
import net.nbc.thetestermod.item.ModCreativeModeTabs;
import net.nbc.thetestermod.loot.ModLootModifiers;
import net.nbc.thetestermod.particle.ModParticles;
import net.nbc.thetestermod.particle.ShineParticles;
import net.nbc.thetestermod.potion.ModPotions;
import net.nbc.thetestermod.sound.ModSounds;
import net.nbc.thetestermod.util.ModItemProperties;
import net.nbc.thetestermod.villager.ModVillagers;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@SuppressWarnings("removal")
@Mod(TesterMod.MOD_ID)
public class TesterMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "testermod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();


    public TesterMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus(); //FIX THIS LINE IF YOU WANT TO UPDATE PAST 1.21.1

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModDataComponentTypes.register(modEventBus);
        ModSounds.register(modEventBus);

        ModEffects.register((modEventBus));
        ModPotions.register((modEventBus));

        ModEnchantmentEffects.register((modEventBus));
        ModEntities.register(modEventBus);

        ModVillagers.register(modEventBus);
        ModParticles.register(modEventBus);
        ModLootModifiers.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);  //FIX THIS LINE IF YOU WANT TO UPDATE PAST 1.21.1
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->{
            ComposterBlock.COMPOSTABLES.put(ModItems.WHITE_CARROT.get(), 0.4f);
            ComposterBlock.COMPOSTABLES.put(ModItems.GLISTERING_CARROT.get(), 1.0f);
        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS)
        {
            event.accept(ModItems.NIGHTMARITE);
            event.accept(ModItems.PURE_NIGHTMARITE);
        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
        {
            event.accept(ModBlocks.PURE_NIGHTMARITE_BLOCK);
            event.accept(ModBlocks.NIGHTMARITE_BLOCK);
            event.accept(ModBlocks.NIGHTMARITE_ORE);
            event.accept(ModBlocks.NIGHTMARITE_DEEPSLATE_ORE);
      ;  }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ModItemProperties.addCustomItemProperties();
            EntityRenderers.register(ModEntities.TESTER_MOB.get(), TesterRenderer::new);
            EntityRenderers.register(ModEntities.THROWING_KNIFE.get(), ThrowingKnifeProjectileRenderer::new);
            EntityRenderers.register(ModEntities.CHAIR_ENT.get(), ChairEntRenderer::new);
        }

        @SubscribeEvent
        public static void registerParticleProvider(RegisterParticleProvidersEvent event) {
            event.registerSpriteSet(ModParticles.SHINE_PARTICLES.get(), ShineParticles.Provider::new);
        }
    }
}
