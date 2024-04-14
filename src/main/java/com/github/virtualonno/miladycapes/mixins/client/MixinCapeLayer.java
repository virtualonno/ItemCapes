// util.Mth might need future refactoring into mojang.math

package com.github.virtualonno.miladycapes.mixins.client;

import com.github.virtualonno.miladycapes.CapeTextureRegistrar;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.CapeLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin({CapeLayer.class})
public abstract class MixinCapeLayer extends RenderLayer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {
   public MixinCapeLayer(RenderLayerParent<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> renderLayerParent) {
      super(renderLayerParent);
   }

   @Inject(
      method = {"render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/client/player/AbstractClientPlayer;FFFFFF)V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void render(
      PoseStack poseStack,
      MultiBufferSource bufferIn,
      int packedLightIn,
      AbstractClientPlayer player,
      float limbSwing,
      float limbSwingAmount,
      float partialTicks,
      float ageInTicks,
      float netHeadYaw,
      float headPitch,
      CallbackInfo ci
   ) {
        ci.cancel();
        if(player.getCloakTextureLocation() != null && !player.isInvisible()){
            ItemStack itemStack = player.getItemBySlot(EquipmentSlot.CHEST);
            if (itemStack.getItem() != Items.ELYTRA){ 
                poseStack.pushPose();
                poseStack.translate(0.0D, 0.0D, 0.125D);
                double d1 = Mth.lerp((double)partialTicks, player.xCloakO, player.xCloak) - Mth.lerp((double)partialTicks, player.xo, player.getX());
                double d2 = Mth.lerp((double)partialTicks, player.yCloakO, player.yCloak) - Mth.lerp((double)partialTicks, player.yo, player.getY());
                double d3 = Mth.lerp((double)partialTicks, player.zCloakO, player.zCloak) - Mth.lerp((double)partialTicks, player.zo, player.getZ());
                float f1 = Mth.rotLerp(partialTicks, player.yBodyRotO, player.yBodyRot);
                double d4 = (double)Mth.sin(f1 * 0.017453292F); //pi/180
                double d5 = (double)(-Mth.cos(f1 * 0.017453292F));
                float f2 = (float)d2 * 10.0F;
                f2 = Mth.clamp(f2, -6.0F, 32.0F);
                float f3 = (float)(d1 * d4 + d3 * d5) * 100.0F;
                f3 = Mth.clamp(f3, 0.0F, 150.0F);
                float f4 = (float)(d1 * d5 - d3 * d4) * 100.0F;
                f4 = Mth.clamp(f4, -20.0F, 20.0F);
                if (f3 < 0.0F) {
                    f3 = 0.0F;
                }

                float f5 = Mth.lerp(partialTicks, player.oBob, player.bob);
                f2 += Mth.sin(Mth.lerp(partialTicks, player.walkDistO, player.walkDist) * 6.0F) * 32.0F * f5;
                if (player.isCrouching()) {
                    f2 += 25.0F;
                }

                poseStack.mulPose(Vector3f.XP.rotationDegrees(6.0F + f3 / 2.0F + f2));
                poseStack.mulPose(Vector3f.ZP.rotationDegrees(f4 / 2.0F));
                poseStack.mulPose(Vector3f.YP.rotationDegrees(180.0F - f4 / 2.0F));

                VertexConsumer vertexConsumer;

                if(player.getCloakTextureLocation() != null){
                    vertexConsumer = ItemRenderer.getArmorFoilBuffer(
                        bufferIn, RenderType.armorCutoutNoCull(player.getCloakTextureLocation()), false, false
                    );
                }
                else { //shouldn't happen but you never know
                    vertexConsumer = bufferIn.getBuffer(RenderType.entityTranslucentCull(CapeTextureRegistrar.NO_CAPE));
                }

                ((PlayerModel<AbstractClientPlayer>)this.getParentModel()).renderCloak(poseStack, vertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY);
                poseStack.popPose();
            }
        }
    }
}
