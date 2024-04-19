package com.github.virtualonno.miladycapes;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.resources.ResourceLocation;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


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
         for(String name : capeTextureList){
            registerTextures(name);
         }
      } catch (Throwable var5) {
         LOG.error("Failed to load cape textures for MiladyCapes. Report immediately to author with logs.", var5);
      }
   }

   private static void registerTextures(String name) {

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

   private static String[] capeTextureList = {
      "copyright_holder_cape",
      "copyright_holder_cape_old",
      "copyright_holder_cape_new",
      "convention_2011_cape",
      "convention_2012_cape",
      "convention_2013_cape",
      "convention_2015_cape",
      "convention_2016_cape",
      "bacon_cape",
      "millionaire_cape",
      "spades_cape",
      "prismarine_cape",
      "turtle_cape",
      "party_cape",
      "valentine_cape",
      "snowman_cape",
      "db_cape",
      "scrolls_cape",
      "cobalt_cape",
      "bugtracker_cape",
      "mapmaker_cape",
      "migrator_cape",
      "awesom_cape",
      "blonk_cape",
      "no_circle_cape",
      "nyan_cape",
      "squid_cape",
      "vet_cape",
      "vagrant_cape",
      "convention_2019_cape",
      "pan_cape",
      "vanilla_cape",
      "cherry_blossom_cape",
      "console_cape",
      "birthday_cape",
      "convention_cape_green",
      "convention_cape_blue",
      "convention_cape_brown",
      "remilia_black_ops_cape",
      "christmas_2010_cape",
      "new_years_2011_cape",
      "tattered_oldfriend_cape",
      "translator_cape_japan",
      "translator_cape_china",
      "translator_cape"
      };

}

