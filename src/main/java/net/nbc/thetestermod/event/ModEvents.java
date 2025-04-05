package net.nbc.thetestermod.event;

import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.brewing.BrewingRecipeRegisterEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.block.ModBlocks;
import net.nbc.thetestermod.item.ModItems;
import net.nbc.thetestermod.item.custom.HammerItem;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.nbc.thetestermod.potion.ModPotions;
import net.nbc.thetestermod.villager.ModVillagers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = TesterMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if(mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for(BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }

    @SubscribeEvent
    public static void onBrewingRecipeRegister(BrewingRecipeRegisterEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, ModItems.PURE_EYE.get(), ModPotions.PURIFICATION_POTION.getHolder().get());
        builder.addMix(Potions.THICK, ModItems.IMPURE_EYE.get(), ModPotions.IMPURIFICATION_POTION.getHolder().get());
    }

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.FARMER) {
            var trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.CARROT, 5),
                    new ItemStack(ModItems.WHITE_CARROT.get(), 8), 6, 4, 0.05f));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.NETHERITE_INGOT, 34),
                    new ItemStack(ModItems.GLISTERING_CARROT.get(), 1), 1, 99, 0.35f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.FLOWER_POT, 1),
                    new ItemStack(ModItems.STRANGE_STICK.get(), 2), 4, 2, 0.01f));

        }
        if(event.getType() == VillagerProfession.LIBRARIAN) {
            var trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.BOOK, 12),
                    new ItemStack(ModItems.MYSTERIOUS_DUST.get(), 3), 3, 3, 0.25f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.LAPIS_BLOCK, 5),
                    new ItemStack(ModBlocks.CORRUPTED_OAK_SAPLING.get(), 1), 2, 10, 0.15f));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 18),
                    new ItemStack(ModItems.ENERGY_ORB.get(), 1), 6, 15, 0.05f));

        }
        if(event.getType() == ModVillagers.GAMING_VILLAGER_N.get()) {
            var trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 18),
                    new ItemStack(ModItems.MYSTERIOUS_DUST.get(), 2), 5, 2, 0.15f));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 15),
                    new ItemStack(ModItems.STRANGE_STICK.get(), 2), 2, 2, 0.15f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 22),
                    new ItemStack(ModItems.MYSTERIOUS_STRING.get(), 2), 1, 3, 0.25f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 25),
                    new ItemStack(ModItems.THROWING_KNIFE.get(), 1), 4, 3, 0.15f));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 28),
                    new ItemStack(ModItems.CHISEL.get(), 1), 4, 4, 0.75f));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 44),
                    new ItemStack(ModItems.NIGHTMARE_NUGGET.get(), 2), 2, 4, 0.65f));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 35),
                    new ItemStack(ModBlocks.CORRUPTED_OAK_WOOD.get(), 4), 3, 5, 0.55f));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 25),
                    new ItemStack(ModBlocks.NIGHTMARE_LAMP.get(), 1), 5, 5, 0.7f));

        }
        if(event.getType() == ModVillagers.GAMING_VILLAGER_S.get()) {
            var trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 18),
                    new ItemStack(ModItems.MYSTERIOUS_DUST.get(), 2), 5, 2, 0.65f));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 15),
                    new ItemStack(ModItems.STRANGE_STICK.get(), 2), 2, 2, 0.75f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 22),
                    new ItemStack(ModItems.MYSTERIOUS_STRING.get(), 2), 1, 3, 0.55f));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 29),
                    new ItemStack(ModItems.THROWING_KNIFE.get(), 1), 4, 3, 0.7f));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 28),
                    new ItemStack(ModItems.CHISEL.get(), 1), 4, 4, 0.95f));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 44),
                    new ItemStack(ModItems.STORM_NUGGET.get(), 2), 2, 4, 0.75f));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 55),
                    new ItemStack(ModBlocks.STORMITE_ORE.get(), 2), 1, 5, 0.85f));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 24),
                    new ItemStack(ModBlocks.STORM_LAMP.get(), 1), 5, 5, 0.85f));

        }
    }

    public static void addWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 5),
                new ItemStack(ModBlocks.CORRUPTED_OAK_PLANKS.get(), 4), 1, 8, 0.15f));

        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.NETHERITE_INGOT, 11),
                new ItemStack(ModItems.STORM_INGOT.get(), 2), 2, 35, 0.25f));

        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.NETHERITE_INGOT, 11),
                new ItemStack(ModItems.NIGHTMARE_INGOT.get(), 2), 2, 35, 0.25f));
    }
}
