package net.nbc.thetestermod.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.nbc.thetestermod.entity.ModEntities;
import net.nbc.thetestermod.entity.custom.ModBoatEntity;
import net.nbc.thetestermod.entity.custom.ModChestBoatEntity;

import java.util.List;
import java.util.function.Predicate;

public class ModBoatItem extends Item {
    private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);
    private final ModBoatEntity.Type type;
    private final boolean hasChest;

    public ModBoatItem(boolean hasChest, ModBoatEntity.Type type, Item.Properties properties) {
        super(properties);
        this.hasChest = hasChest;
        this.type = type;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        HitResult hitresult = getPlayerPOVHitResult(pLevel, pPlayer, ClipContext.Fluid.ANY);
        if (hitresult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(itemstack);
        } else {
            Vec3 vec3 = pPlayer.getViewVector(1.0F);
            List<Entity> list = pLevel.getEntities(pPlayer, pPlayer.getBoundingBox().expandTowards(vec3.scale(5.0D)).inflate(1.0D), ENTITY_PREDICATE);
            if (!list.isEmpty()) {
                Vec3 vec31 = pPlayer.getEyePosition();

                for(Entity entity : list) {
                    AABB aabb = entity.getBoundingBox().inflate((double)entity.getPickRadius());
                    if (aabb.contains(vec31)) {
                        return InteractionResultHolder.pass(itemstack);
                    }
                }
            }

            if (hitresult.getType() == HitResult.Type.BLOCK) {
                Boat boat = this.getBoat(pLevel, hitresult, itemstack, pPlayer);
                if(boat instanceof ModChestBoatEntity chestBoat) {
                    chestBoat.setVariant(this.type);
                } else if(boat instanceof ModBoatEntity) {
                    ((ModBoatEntity)boat).setVariant(this.type);
                }
                boat.setYRot(pPlayer.getYRot());
                if (!pLevel.noCollision(boat, boat.getBoundingBox())) {
                    return InteractionResultHolder.fail(itemstack);
                } else {
                    if (!pLevel.isClientSide) {
                        pLevel.addFreshEntity(boat);
                        pLevel.gameEvent(pPlayer, GameEvent.ENTITY_PLACE, hitresult.getLocation());
                        if (!pPlayer.getAbilities().instabuild) {
                            itemstack.shrink(1);
                        }
                    }

                    pPlayer.awardStat(Stats.ITEM_USED.get(this));
                    return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
                }
            } else {
                return InteractionResultHolder.pass(itemstack);
            }
        }
    }

    private Boat getBoat(Level level, HitResult hitResult, ItemStack stack, Player player) {
        Vec3 pos = hitResult.getLocation();

        Boat boat = this.hasChest
                ? ModEntities.MOD_CHEST_BOAT_ENT.get().create(level)
                : ModEntities.MOD_BOAT_ENT.get().create(level);

        if (boat == null)
            return null;

        boat.setPos(pos.x, pos.y, pos.z);
        boat.setYRot(player.getYRot());

        if (boat instanceof ModBoatEntity modBoat) {
            modBoat.setVariant(this.type);
        } else if (boat instanceof ModChestBoatEntity modChestBoat) {
            modChestBoat.setVariant(this.type);
        }

        if (level instanceof ServerLevel serverLevel) {
            EntityType.<Boat>createDefaultStackConfig(serverLevel, stack, player).accept(boat);
        }

        return boat;
    }
}
