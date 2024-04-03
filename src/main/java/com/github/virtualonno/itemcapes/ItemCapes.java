package com.github.virtualonno.itemcapes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;

import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.world.item.Item;
//import net.minecraft.world.item.crafting.RecipeSerializer;
//import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
//import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.theillusivec4.curios.api.SlotTypeMessage;
import net.minecraft.server.packs.resources.ReloadableResourceManager; 

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Mod(ItemCapes.MODID)
public class ItemCapes
{
    public static final String MODID = "itemcapes";
    public static final String CURIOS_MODID = "curios";

    public static final Logger LOG = LogManager.getLogger(MODID);

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final RegistryObject<Item> CAPE_ITEM = ITEMS.register("cape", () -> new CapeItem());

    public ItemCapes()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        //bus.addGenericListener(Item.class, (RegisterEvent e) -> e.register(new CapeItem()));
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        // bus.addGenericListener(IRecipeSerializer.class, (RegistryEvent.Register<IRecipeSerializer<?>> e) -> e.getRegistry().register(new ShapelessCapeRecipe.Serializer()));
        // bus.addGenericListener(IRecipeSerializer.class, (RegistryEvent.Register<IRecipeSerializer<?>> e) -> e.getRegistry().register(new ShapedCapeRecipe.Serializer()));
        bus.addListener((InterModEnqueueEvent e) -> InterModComms.sendTo(CURIOS_MODID, SlotTypeMessage.REGISTER_TYPE, () ->
                new SlotTypeMessage.Builder("cape").build()));
        if (FMLLoader.getDist().isClient()) {
            bus.addListener(CapeTextureRegistrar::registerCapeTextures);
        }

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.SPEC);
    }



    public static ResourceLocation id(String path)
    {
        return new ResourceLocation(MODID, path);
    }

    public static class Config {
        private static final ForgeConfigSpec SPEC;
        public static final ForgeConfigSpec.BooleanValue ELYTRAS;
  
        static {
           net.minecraftforge.common.ForgeConfigSpec.Builder builder = new net.minecraftforge.common.ForgeConfigSpec.Builder();
           ELYTRAS = builder.comment("Whether or not to allow the cape design to also reflect on elytras.").define("showOnElytras", true);
           SPEC = builder.build();
        }
     }
}
