package com.github.virtualonno.miladycapes.registries;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;


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

