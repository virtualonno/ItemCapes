package com.github.virtualonno.miladycapes;

import com.github.virtualonno.miladycapes.registries.ItemRegistry;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.world.item.*;
import net.minecraft.resources.ResourceLocation;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


   public class CapeTextureRegistrar{
   public static final ResourceLocation DEFAULT_CAPE = new ResourceLocation(MiladyCapes.MODID, "textures/capes/red.png");

   //private static final ResourceLocation DEFAULT_ELYTRA = new ResourceLocation("textures/entity/elytra.png");
   public static final ResourceLocation NO_CAPE = new ResourceLocation(MiladyCapes.MODID, "blank");
   public static final ResourceLocation VANILLA_ELYTRA = new ResourceLocation("minecraft", "textures/entity/elytra.png"); 
   private static final Map<String, ResourceLocation> TEXTURE_CACHE = new HashMap<>();
   public static final Logger LOG = LogManager.getLogger("miladycapes");

    public static void registerCapeTextures(FMLClientSetupEvent evt) {
      try {
            registerTextures("red_cape", ItemRegistry.RED_CAPE);
            registerTextures("mojang_cape", ItemRegistry.MOJANG_CAPE);
            registerTextures("remilia_black_ops_cape", ItemRegistry.REMILIA_BLACK_OPS_CAPE);
      } catch (Throwable var5) {
         LOG.error("Failed to load cape textures for MiladyCapes. Report immediately to author with logs.", var5);
      }
   }

   private static void registerTextures(String name, RegistryObject<Item> item) {

      //String name = item.getKey().location().getPath();
      ResourceLocation id = new ResourceLocation(MiladyCapes.MODID, locationString(name));
         LOG.info("New cape type registered: " + name);
         LOG.info("With id:  " + id);
         TEXTURE_CACHE.put(name, id);
   }

   private static String locationString(String name) {
      return ("textures/capes/" + name + ".png");
  }

   public static ResourceLocation get(String type) {
         return TEXTURE_CACHE.getOrDefault(type, NO_CAPE);
   }



}

