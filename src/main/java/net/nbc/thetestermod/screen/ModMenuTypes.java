package net.nbc.thetestermod.screen;

import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.screen.custom.ImpurifierBlockMenu;
import net.nbc.thetestermod.screen.custom.PurifierBlockMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, TesterMod.MOD_ID);

    // Registering MenuTypes using the NF approach with DeferredHolder
    public static final DeferredHolder<MenuType<?>, MenuType<PurifierBlockMenu>> PURIFIER_BLOCK_MENU =
            registerMenuType("purifier_block_menu", PurifierBlockMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<ImpurifierBlockMenu>> IMPURIFIER_BLOCK_MENU =
            registerMenuType("impurifier_block_menu", ImpurifierBlockMenu::new);

    // Helper method to register MenuTypes using NF's DeferredHolder and IMenuTypeExtension
    private static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(
            String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IMenuTypeExtension.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
