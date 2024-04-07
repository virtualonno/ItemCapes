package com.github.virtualonno.miladycapes.registries;

import java.util.Set;
import java.util.HashSet;

import com.github.virtualonno.miladycapes.CapeItem;
import com.github.virtualonno.miladycapes.MiladyCapes;
import com.google.common.collect.ImmutableMultimap;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class ItemRegistry {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MiladyCapes.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    public static final RegistryObject<Item> RED_CAPE = ITEMS.register("red_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> MOJANG_CAPE = ITEMS.register("mojang_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> REMILIA_BLACK_OPS_CAPE = ITEMS.register("remilia_black_ops_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));

    

}

