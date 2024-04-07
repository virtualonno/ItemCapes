package com.github.virtualonno.miladycapes;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundEvents;

import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.type.capability.ICurio.SoundInfo;

import javax.annotation.Nonnull;


public class CapeItem extends Item implements ICurioItem
{

    public CapeItem(Item.Properties Properties)
    {
        super(Properties);
    }

    @Nonnull
    @Override
    public SoundInfo getEquipSound(SlotContext slotContext, ItemStack stack)
    {
        return new SoundInfo(SoundEvents.ARMOR_EQUIP_ELYTRA, 1f, 1f);
    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack)
    {
        return true;
    }

}
