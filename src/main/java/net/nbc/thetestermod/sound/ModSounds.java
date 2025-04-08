package net.nbc.thetestermod.sound;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.nbc.thetestermod.TesterMod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, TesterMod.MOD_ID);

    public static final Supplier<SoundEvent> CHISEL_USE = registerSoundEvent("chisel_use");

    public static final Supplier<SoundEvent> MAGIC_BLOCK_BREAK = registerSoundEvent("magic_block_break");
    public static final Supplier<SoundEvent> MAGIC_BLOCK_STEP = registerSoundEvent("magic_block_step");
    public static final Supplier<SoundEvent> MAGIC_BLOCK_PLACE = registerSoundEvent("magic_block_place");
    public static final Supplier<SoundEvent> MAGIC_BLOCK_HIT = registerSoundEvent("magic_block_hit");
    public static final Supplier<SoundEvent> MAGIC_BLOCK_FALL = registerSoundEvent("magic_block_fall");

    public static final Supplier<SoundEvent> TESTER_AMBIENT_1 = registerSoundEvent("tester_idle_1");
    public static final Supplier<SoundEvent> TESTER_AMBIENT_2 = registerSoundEvent("tester_idle_2");
    public static final Supplier<SoundEvent> TESTER_HURT_1 = registerSoundEvent("tester_hurt_1");
    public static final Supplier<SoundEvent> TESTER_HURT_2 = registerSoundEvent("tester_hurt_2");
    public static final Supplier<SoundEvent> TESTER_DEATH_1 = registerSoundEvent("tester_death_1");

    public static final DeferredSoundType MAGIC_BLOCK_SOUNDS = new DeferredSoundType(1f, 1f,
            MAGIC_BLOCK_BREAK, MAGIC_BLOCK_STEP, MAGIC_BLOCK_PLACE, MAGIC_BLOCK_HIT, MAGIC_BLOCK_FALL);

    public static final DeferredSoundType ANTI_MAGIC_BLOCK_SOUNDS = new DeferredSoundType(1f, 0.75f,
            MAGIC_BLOCK_BREAK, MAGIC_BLOCK_STEP, MAGIC_BLOCK_PLACE, MAGIC_BLOCK_HIT, MAGIC_BLOCK_FALL);

    // Optional: Combine ambient sounds into a custom type later if needed

    public static final Supplier<SoundEvent> HAIL_SQUIDWARD = registerSoundEvent("all_hail_squidward");
    public static final ResourceKey<JukeboxSong> HAIL_SQUIDWARD_KEY = ResourceKey.create(
            Registries.JUKEBOX_SONG,
            ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "all_hail_squidward")
    );

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
