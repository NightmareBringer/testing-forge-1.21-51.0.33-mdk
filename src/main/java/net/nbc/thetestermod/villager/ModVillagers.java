package net.nbc.thetestermod.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.sound.ModSounds;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, TesterMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(BuiltInRegistries.VILLAGER_PROFESSION, TesterMod.MOD_ID);

    public static final Holder<PoiType> GAMING_VILLAGER_N_POI = POI_TYPES.register("gaming_villager_n_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.RED_GAMING_CHAIR.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final Holder<VillagerProfession> GAMING_VILLAGER_N = VILLAGER_PROFESSIONS.register("gaming_villager_n",
            () -> new VillagerProfession("gaming_villager_n", holder -> holder.value() == GAMING_VILLAGER_N_POI.value(),
                    holder -> holder.value() == GAMING_VILLAGER_N_POI.value(), ImmutableSet.of(), ImmutableSet.of(),
                    ModSounds.MAGIC_BLOCK_FALL.get()));

    public static final Holder<PoiType> GAMING_VILLAGER_S_POI = POI_TYPES.register("gaming_villager_s_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.BLUE_GAMING_CHAIR.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final Holder<VillagerProfession> GAMING_VILLAGER_S = VILLAGER_PROFESSIONS.register("gaming_villager_s",
            () -> new VillagerProfession("gaming_villager_s", holder -> holder.value() == GAMING_VILLAGER_S_POI.value(),
                    holder -> holder.value() == GAMING_VILLAGER_S_POI.value(), ImmutableSet.of(), ImmutableSet.of(),
                    ModSounds.MAGIC_BLOCK_FALL.get()));

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
