package com.github.virtualonno.miladycapes.registries;

import com.github.virtualonno.miladycapes.CapeItem;
import com.github.virtualonno.miladycapes.MiladyCapes;

import net.minecraft.world.item.*;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ItemRegistry {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MiladyCapes.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    public static final RegistryObject<Item> RED_CAPE = ITEMS.register("red_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> MOJANG_CAPE = ITEMS.register("mojang_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> REMILIA_BLACK_OPS_CAPE = ITEMS.register("remilia_black_ops_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));

    

}

