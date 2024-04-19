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
    public static final RegistryObject<Item> CONVENTION_2011_CAPE = ITEMS.register("convention_2011_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> CONVENTION_2012_CAPE = ITEMS.register("convention_2012_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> CONVENTION_2013_CAPE = ITEMS.register("convention_2013_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> CONVENTION_2015_CAPE = ITEMS.register("convention_2015_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> CONVENTION_2016_CAPE = ITEMS.register("convention_2016_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> BACON_CAPE = ITEMS.register("bacon_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.COMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> MILLIONAIRE_CAPE = ITEMS.register("millionaire_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> SPADES_CAPE = ITEMS.register("spades_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> PRISMARINE_CAPE = ITEMS.register("prismarine_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> TURTLE_CAPE = ITEMS.register("turtle_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> PARTY_CAPE = ITEMS.register("party_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> VALENTINE_CAPE = ITEMS.register("valentine_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> SNOWMAN_CAPE = ITEMS.register("snowman_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> DB_CAPE = ITEMS.register("db_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> SCROLLS_CAPE = ITEMS.register("scrolls_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> COBALT_CAPE = ITEMS.register("cobalt_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> BUGTRACKER_CAPE = ITEMS.register("bugtracker_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> MAPMAKER_CAPE = ITEMS.register("mapmaker_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> MIGRATOR_CAPE = ITEMS.register("migrator_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.COMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> AWESOM_CAPE = ITEMS.register("awesom_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.COMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> BLONK_CAPE = ITEMS.register("blonk_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.COMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> NO_CIRCLE_CAPE = ITEMS.register("no_circle_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.COMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> NYAN_CAPE = ITEMS.register("nyan_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> SQUID_CAPE = ITEMS.register("squid_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.COMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> VET_CAPE = ITEMS.register("vet_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> VAGRANT_CAPE = ITEMS.register("vagrant_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> CONVENTION_2019_CAPE = ITEMS.register("convention_2019_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> PAN_CAPE = ITEMS.register("pan_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> VANILLA_CAPE = ITEMS.register("vanilla_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> CHERRY_BLOSSOM_CAPE = ITEMS.register("cherry_blossom_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.COMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> CONSOLE_CAPE = ITEMS.register("console_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> BIRTHDAY_CAPE = ITEMS.register("birthday_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> CONVENTION_CAPE_GREEN = ITEMS.register("convention_cape_green", () -> new CapeItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> CONVENTION_CAPE_BLUE = ITEMS.register("convention_cape_blue", () -> new CapeItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> CONVENTION_CAPE_BROWN = ITEMS.register("convention_cape_brown", () -> new CapeItem(new Item.Properties().rarity(Rarity.RARE).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> CHRISTMAS_2010_CAPE = ITEMS.register("christmas_2010_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> NEW_YEARS_2011_CAPE = ITEMS.register("new_years_2011_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
  
    public static final RegistryObject<Item> TRANSLATOR_CAPE_JAPAN = ITEMS.register("translator_cape_japan", () -> new CapeItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> TRANSLATOR_CAPE_CHINA = ITEMS.register("translator_cape_china", () -> new CapeItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> TRANSLATOR_CAPE = ITEMS.register("translator_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.UNCOMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));


    public static final RegistryObject<Item> TATTERED_OLDFRIEND_CAPE = ITEMS.register("tattered_oldfriend_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.COMMON).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));


    public static final RegistryObject<Item> REMILIA_BLACK_OPS_CAPE = ITEMS.register("remilia_black_ops_cape", () -> new CapeItem(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1).tab(CreativeModeTab.TAB_TOOLS)));


}

