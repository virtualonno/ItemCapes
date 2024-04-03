package com.github.virtualonno.itemcapes;

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
import java.util.function.Predicate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import org.jetbrains.annotations.NotNull;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.loading.FMLPaths;
//import top.theillusivec4.curios.common.network.NetworkHandler;
import net.minecraftforge.common.data.ExistingFileHelper.IResourceType;
import net.minecraft.server.packs.resources.PreparableReloadListener;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

   public class CapeTextureRegistrar{
   public static final ResourceLocation DEFAULT_CAPE = ItemCapes.id("textures/red.png");
   private static final ResourceLocation DEFAULT_ELYTRA = new ResourceLocation("textures/entity/elytra.png");
   private static final ResourceLocation NOOP = ItemCapes.id("noop");
   private static final Map<String, ResourceLocation> TEXTURE_CACHE = new HashMap<>();
   public static final Logger LOG = LogManager.getLogger("itemcapes");

    public static void registerCapeTextures(FMLClientSetupEvent evt) {
      try {
         Path dir = FMLPaths.GAMEDIR.get();
         Path var6;
         int i = registerTexturesIn(var6 = dir.resolve("capes"), false);
         i += registerTexturesIn(var6.resolve("elytras"), true);
         LOG.info("Loaded {} cape textures.", i);
      } catch (Throwable var5) {
         LOG.error("Failed to load cape textures for ItemCapes. Report immediately to author with logs.", var5);
      }
   }

   private static int registerTexturesIn(Path dir, boolean elytra) throws IOException {
      FileFilter fileFilter = new WildcardFileFilter("*.png");
      Files.createDirectories(dir);
      File[] found = dir.toFile().listFiles(fileFilter);

      for (File file : found) {
         String name = file.getName();
         if (elytra) {
            name = "elytra_" + name;
         }

         ResourceLocation id = ItemCapes.id(com.google.common.io.Files.getNameWithoutExtension(name));
         Minecraft.getInstance().getTextureManager().register(id, new DynamicTexture(NativeImage.read(new FileInputStream(file))));
         TEXTURE_CACHE.put(id.getPath(), id);
      }

      return found.length;
   }

   public static ResourceLocation get(String type, boolean elytra) {
      if (elytra) {
         return !ItemCapes.Config.ELYTRAS.get() ? DEFAULT_ELYTRA : TEXTURE_CACHE.getOrDefault("elytra_" + type, DEFAULT_ELYTRA);
      } else {
         return TEXTURE_CACHE.getOrDefault(type, NOOP);
      }
   }


}
