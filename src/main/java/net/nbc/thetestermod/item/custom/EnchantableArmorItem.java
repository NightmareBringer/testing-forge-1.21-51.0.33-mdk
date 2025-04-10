package net.nbc.thetestermod.item.custom;

import net.minecraft.core.Holder;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;

public class EnchantableArmorItem extends ArmorItem {

    public EnchantableArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return true;
    }

    @Override
    public boolean supportsEnchantment(ItemStack stack, Holder<Enchantment> enchantment) {
        return true;
    }
}
