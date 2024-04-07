package com.github.virtualonno.miladycapes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;

import com.github.virtualonno.miladycapes.registries.ItemRegistry;
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

@Mod(MiladyCapes.MODID)
public class MiladyCapes
{
    public static final String MODID = "miladycapes";

    public static final Logger LOG = LogManager.getLogger(MODID);

    public MiladyCapes()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemRegistry.register(modEventBus);

        //bus.addGenericListener(Item.class, (RegisterEvent e) -> e.register(new CapeItem()));
        // bus.addGenericListener(IRecipeSerializer.class, (RegistryEvent.Register<IRecipeSerializer<?>> e) -> e.getRegistry().register(new ShapelessCapeRecipe.Serializer()));
        // bus.addGenericListener(IRecipeSerializer.class, (RegistryEvent.Register<IRecipeSerializer<?>> e) -> e.getRegistry().register(new ShapedCapeRecipe.Serializer()));

        if (FMLLoader.getDist().isClient()) {
            modEventBus.addListener(CapeTextureRegistrar::registerCapeTextures);
        }

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.SPEC);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
    }



    // public static ResourceLocation id(String path)
    // {
    //     return new ResourceLocation(MODID, path);
    // }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        Curios.registerCurioSlot(Curios.CAPE_SLOT, 1, false, null);
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
