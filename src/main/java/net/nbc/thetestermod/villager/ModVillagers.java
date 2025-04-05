package net.nbc.thetestermod.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.sound.ModSounds;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, TesterMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, TesterMod.MOD_ID);

    public static final RegistryObject<PoiType> GAMING_VILLAGER_N_POI = POI_TYPES.register("gaming_villager_n_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.RED_GAMING_CHAIR.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> GAMING_VILLAGER_N = VILLAGER_PROFESSIONS.register("gaming_villager_n",
            () -> new VillagerProfession("gaming_villager_n", holder -> holder.value() == GAMING_VILLAGER_N_POI.get(),
                    holder -> holder.value() == GAMING_VILLAGER_N_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    ModSounds.MAGIC_BLOCK_FALL.get()));

    public static final RegistryObject<PoiType> GAMING_VILLAGER_S_POI = POI_TYPES.register("gaming_villager_s_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.BLUE_GAMING_CHAIR.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> GAMING_VILLAGER_S = VILLAGER_PROFESSIONS.register("gaming_villager_s",
            () -> new VillagerProfession("gaming_villager_s", holder -> holder.value() == GAMING_VILLAGER_S_POI.get(),
                    holder -> holder.value() == GAMING_VILLAGER_S_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    ModSounds.MAGIC_BLOCK_FALL.get()));



    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }

}
