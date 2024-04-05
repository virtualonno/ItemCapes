package com.github.virtualonno.itemcapes;

import com.github.virtualonno.itemcapes.registries.ItemRegistry;
import net.minecraftforge.registries.ForgeRegistries;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import net.minecraft.world.item.ItemStack;
import java.util.function.Predicate;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.*;
import net.minecraft.client.renderer.texture.DynamicTexture;
import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraft.client.renderer.texture.AbstractTexture;
//import top.theillusivec4.curios.common.network.NetworkHandler;
import net.minecraft.server.packs.resources.Resource;
import net.minecraftforge.common.data.ExistingFileHelper.IResourceType;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.logging.log4j.LogManager;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.Logger;
import java.io.InputStream;


   public class CapeTextureRegistrar{
   public static final ResourceLocation DEFAULT_CAPE = new ResourceLocation(ItemCapes.MODID, "textures/capes/red.png");

   //private static final ResourceLocation DEFAULT_ELYTRA = new ResourceLocation("textures/entity/elytra.png");
   private static final ResourceLocation NOOP = new ResourceLocation(ItemCapes.MODID, "blank"); 
   private static final Map<String, ResourceLocation> TEXTURE_CACHE = new HashMap<>();
   public static final Logger LOG = LogManager.getLogger("itemcapes");

    public static void registerCapeTextures(FMLClientSetupEvent evt) {
      try {
            registerTextures("red_cape", ItemRegistry.RED_CAPE);
            registerTextures("mojang_cape", ItemRegistry.MOJANG_CAPE);
            registerTextures("remilia_black_ops_cape", ItemRegistry.REMILIA_BLACK_OPS_CAPE);
      } catch (Throwable var5) {
         LOG.error("Failed to load cape textures for ItemCapes. Report immediately to author with logs.", var5);
      }
   }

   private static void registerTextures(String name, RegistryObject<Item> item) {

      //String name = item.getKey().location().getPath();
      ResourceLocation id = new ResourceLocation(ItemCapes.MODID, locationString(name));
 
      LOG.info("Item loaded is:" + name);
      //ResourceManager resourceManager = Minecraft.getInstance().getResourceManager();
      //try{
      //Resource resource = resourceManager.getResourceStack(id).get(0);
      if (id != null) {
         // Get the input stream
         //InputStream inputStream = resource.open();
        // Minecraft.getInstance().getTextureManager().register(id, new DynamicTexture(NativeImage.read(inputStream)));
         LOG.info("New type registered: " + name);
         LOG.info("With id:  " + id);
         TEXTURE_CACHE.put(name, id);
     } else {
         // Resource not found
     }
//  } catch (IOException e) {
//      // Handle the IOException
//      e.printStackTrace();
//  }
   }

   private static String locationString(String name) {
      return ("textures/capes/" + name + ".png");
  }

   public static ResourceLocation get(String type) {
         return TEXTURE_CACHE.getOrDefault(type, NOOP);
   }

   private static String[] validTypes = {
      "mojang",
      "red"
   };


}

