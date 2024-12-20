package net.nbc.thetestermod.sound;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nbc.thetestermod.TesterMod;

public class ModSounds
{
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TesterMod.MOD_ID);

    public static final RegistryObject<SoundEvent> CHISEL_USE = registerSoundEvent("chisel_use");

    public static final RegistryObject<SoundEvent> MAGIC_BLOCK_BREAK = registerSoundEvent("magic_block_break");
    public static final RegistryObject<SoundEvent> MAGIC_BLOCK_STEP = registerSoundEvent("magic_block_step");
    public static final RegistryObject<SoundEvent> MAGIC_BLOCK_PLACE = registerSoundEvent("magic_block_place");
    public static final RegistryObject<SoundEvent> MAGIC_BLOCK_HIT = registerSoundEvent("magic_block_hit");
    public static final RegistryObject<SoundEvent> MAGIC_BLOCK_FALL = registerSoundEvent("magic_block_fall");

    public static final ForgeSoundType MAGIC_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.MAGIC_BLOCK_BREAK, ModSounds.MAGIC_BLOCK_STEP, ModSounds.MAGIC_BLOCK_PLACE, ModSounds.MAGIC_BLOCK_HIT, ModSounds.MAGIC_BLOCK_FALL);

    public static final ForgeSoundType ANTI_MAGIC_BLOCK_SOUNDS = new ForgeSoundType(1f, 0.75f,
            ModSounds.MAGIC_BLOCK_BREAK, ModSounds.MAGIC_BLOCK_STEP, ModSounds.MAGIC_BLOCK_PLACE, ModSounds.MAGIC_BLOCK_HIT, ModSounds.MAGIC_BLOCK_FALL);

    public static final RegistryObject<SoundEvent> HAIL_SQUIDWARD = registerSoundEvent("all_hail_squidward");
    public static final ResourceKey<JukeboxSong> HAIL_SQUIDWARD_KEY = ResourceKey.create(Registries.JUKEBOX_SONG,
            ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, "all_hail_squidward"));




    private static RegistryObject<SoundEvent> registerSoundEvent(String name)
    {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TesterMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus)
    {
        SOUND_EVENTS.register(eventBus);
    }
}
