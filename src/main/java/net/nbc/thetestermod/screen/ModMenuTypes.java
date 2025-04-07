package net.nbc.thetestermod.screen;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.nbc.thetestermod.TesterMod;
import net.nbc.thetestermod.screen.custom.ImpurifierBlockMenu;
import net.nbc.thetestermod.screen.custom.PurifierBlockMenu;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, TesterMod.MOD_ID);

    public static final RegistryObject<MenuType<PurifierBlockMenu>> PURIFIER_BLOCK_MENU =
            MENUS.register("purifier_block_menu", () -> IForgeMenuType.create(PurifierBlockMenu::new));

    public static final RegistryObject<MenuType<ImpurifierBlockMenu>> IMPURIFIER_BLOCK_MENU =
            MENUS.register("impurifier_block_menu", () -> IForgeMenuType.create(ImpurifierBlockMenu::new));


    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
