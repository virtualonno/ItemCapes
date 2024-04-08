package com.github.virtualonno.miladycapes.mixins.client;

import com.github.virtualonno.miladycapes.CapeItem;
import com.github.virtualonno.miladycapes.CapeTextureRegistrar;
import com.github.virtualonno.miladycapes.registries.ElytraHelper;

import com.mojang.authlib.GameProfile;

import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.ProfilePublicKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;

import net.minecraftforge.registries.ForgeRegistries;

import org.jetbrains.annotations.Nullable;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import top.theillusivec4.curios.api.CuriosApi;


@Mixin(value = AbstractClientPlayer.class)
public abstract class AbstractClientPlayerEntityMixin extends Player
{
    ElytraHelper elytraHelper = new ElytraHelper();
    
public AbstractClientPlayerEntityMixin(Level level, BlockPos blockPos, float f, GameProfile gameProfile, @Nullable ProfilePublicKey profilePublicKey) {
        super(level, blockPos, f, gameProfile, profilePublicKey);
    }

    // private static final Map<String, ResourceLocation> TEXTURE_CACHE = new HashMap<>();

    @Inject(method = "getCloakTextureLocation", at = @At("HEAD"), cancellable = true)
    private void redirectCapeTexture(CallbackInfoReturnable<ResourceLocation> cir)
    {
        this.findCurio(cir, false);
    }

    @Inject(method = "getElytraTextureLocation", at = @At("HEAD"), cancellable = true)
    private void redirectElytraTexture(CallbackInfoReturnable<ResourceLocation> cir) {

        this.findCurio(cir, true);
     }
  
     private void findCurio(CallbackInfoReturnable<ResourceLocation> cir, boolean isElytra) {
      //deprecated method, use getCuriosInventory for 1.20+ instead
      //item -> ForgeRegistries.ITEMS.getKey(item.getItem()).getNamespace().equals("itemcapes")
        CuriosApi.getCuriosHelper().findEquippedCurio(item -> item.getItem() instanceof CapeItem, (AbstractClientPlayer) (Object) this).ifPresent(t -> {
            ItemStack stack = (ItemStack)t.getRight();
            String name = ForgeRegistries.ITEMS.getKey(stack.getItem()).getPath();
            if(isElytra){
                if(!elytraHelper.hasNoElytra.contains(name)){
                    cir.setReturnValue(CapeTextureRegistrar.get(name));
                }
                else{
                    cir.setReturnValue(CapeTextureRegistrar.VANILLA_ELYTRA);
                };
            }
            else{
                cir.setReturnValue(CapeTextureRegistrar.get(name));
            };
        });
     }


}
