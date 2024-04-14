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
    public static final RegistryObject<Item> COPYRIGHT_HOLDER_CAPE = ITEMS.register("copyright_holder_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> COPYRIGHT_HOLDER_CAPE_OLD = ITEMS.register("copyright_holder_cape_old", () -> new CapeItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> COPYRIGHT_HOLDER_CAPE_NEW = ITEMS.register("copyright_holder_cape_new", () -> new CapeItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
   
    public static final RegistryObject<Item> CHRISTMAS_2010_CAPE = ITEMS.register("christmas_2010_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<Item> CONVENTION_2011_CAPE = ITEMS.register("convention_2011_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> CONVENTION_2012_CAPE = ITEMS.register("convention_2012_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> CONVENTION_2013_CAPE = ITEMS.register("convention_2013_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> CONVENTION_2015_CAPE = ITEMS.register("convention_2015_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> CONVENTION_2016_CAPE = ITEMS.register("convention_2016_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));

    public static final RegistryObject<Item> REMILIA_BLACK_OPS_CAPE = ITEMS.register("remilia_black_ops_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> TATTERED_OLDFRIEND_CAPE = ITEMS.register("tattered_oldfriend_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));

    

}

