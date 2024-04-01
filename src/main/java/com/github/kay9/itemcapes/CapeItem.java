package com.github.kay9.itemcapes;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
//import net.minecraftforge.registries.RegistryObject;
//import net.minecraftforge.registries.ForgeRegistries;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.type.capability.ICurio.SoundInfo;
import net.minecraft.world.level.Level;
//import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
//import javax.annotation.Nullable;
import java.util.List;



public class CapeItem extends Item implements ICurioItem
{


    public static final String CAPE_TYPE_NBT = "CapeType"; // Key for ResourceLocation
    public static final ResourceLocation DEFAULT_CAPE = ItemCapes.id("textures/red.png");

    public CapeItem()
    {
        super(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS));
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

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> desc, TooltipFlag flags)
    {
        String type = "red";
        CompoundTag tag = stack.getTag();
        if (tag != null)
        {
            String string = tag.getString(CAPE_TYPE_NBT);
            if (!string.isEmpty()) type = string;
        }
        desc.add(Component.translatable("item.itemcapes.cape.desc").withStyle(ChatFormatting.GOLD)
                .append(Component.literal(": ").withStyle(ChatFormatting.AQUA))
                .append(Component.literal(type.replace('_', ' ')).withStyle(ChatFormatting.YELLOW)));
    }
}
