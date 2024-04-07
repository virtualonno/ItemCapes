package com.github.virtualonno.miladycapes.registries;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

import com.github.virtualonno.miladycapes.CapeItem;
import com.github.virtualonno.miladycapes.MiladyCapes;
import com.google.common.collect.ImmutableMultimap;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class ElytraHelper {
    public Set<String> hasElytra = new HashSet<>();
    private static String[] elytraCapes = {
    "mojang_cape",
    "remilia_black_ops_cape"
 };
 public ElytraHelper() {
    hasElytra.addAll(Arrays.asList(elytraCapes));
}

}

