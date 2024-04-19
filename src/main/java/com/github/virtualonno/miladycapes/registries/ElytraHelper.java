package com.github.virtualonno.miladycapes.registries;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;


public class ElytraHelper {
    public Set<String> hasNoElytra = new HashSet<>();
    private static String[] elytraLessCapes = {
    "tattered_oldfriend_cape"
 };
 public ElytraHelper() {
    hasNoElytra.addAll(Arrays.asList(elytraLessCapes));
}

}

