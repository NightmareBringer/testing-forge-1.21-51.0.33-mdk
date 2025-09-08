package net.nbc.thetestermod.loot.custom;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.nbc.thetestermod.loot.ModLootConditions;

public class ChargedCreeperCondition implements LootItemCondition {
    public static final MapCodec<ChargedCreeperCondition> CODEC =
            MapCodec.unit(new ChargedCreeperCondition());

    @Override
    public LootItemConditionType getType() {
        return ModLootConditions.CHARGED_CREEPER.get();
    }

    @Override
    public boolean test(LootContext lootContext) {
        Entity entity = lootContext.getParamOrNull(LootContextParams.THIS_ENTITY);
        return entity instanceof Creeper creeper && !creeper.isOnFire() && creeper.isPowered();
    }
}
