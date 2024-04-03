// package com.github.kay9.itemcapes.recipe;

// import com.github.kay9.itemcapes.CapeItem;
// import com.github.kay9.itemcapes.ItemCapes;
// import com.google.gson.JsonObject;
// import net.minecraft.world.item.ItemStack;
// import net.minecraft.world.item.crafting.RecipeSerializer;
// import net.minecraft.world.item.crafting.Ingredient;
// import net.minecraft.world.item.crafting.ShapedRecipe;
// import net.minecraft.nbt.CompoundTag;
// import net.minecraft.network.FriendlyByteBuf;
// import net.minecraft.util.GsonHelper;
// import net.minecraft.core.NonNullList;
// import net.minecraft.resources.ResourceLocation;
// import net.minecraftforge.registries.RegistryObject;
// import net.minecraftforge.registries.ForgeRegistries;

// import javax.annotation.Nullable;

// public class ShapedCapeRecipe extends ShapedRecipe
// {
//     public ShapedCapeRecipe(ResourceLocation id, String group, int width, int height, NonNullList<Ingredient> ingredients, ItemStack result)
//     {
//         super(id, group, width, height, ingredients, result);
//     }

//     private static ShapedCapeRecipe wrap(ShapedRecipe recipe, JsonObject json)
//     {
//         ItemStack stack = recipe.getResultItem();
//         applyCapeType(stack, json);
//         return new ShapedCapeRecipe(recipe.getId(), recipe.getGroup(), recipe.getWidth(), recipe.getHeight(), recipe.getIngredients(), stack);
//     }

//     @Override
//     public RecipeSerializer<?> getSerializer()
//     {
//         return Serializer.SERIALIZER.get();
//     }

//     public static void applyCapeType(ItemStack stack, @Nullable JsonObject json)
//     {
//         if (json != null)
//         {
//             String type = GsonHelper.getAsString(GsonHelper.getAsJsonObject(json, "result"), "cape_type");
//             if (!type.equals("red"))
//             {
//                 CompoundTag tag = stack.getOrCreateTag();
//                 tag.putString(CapeItem.CAPE_TYPE_NBT, type);
//                 stack.setTag(tag);
//             }
//         }
//     }

//     public static class Serializer extends ShapedRecipe.Serializer
//     {
//         public static final RegistryObject<RecipeSerializer<ShapelessCapeRecipe>> SERIALIZER = RegistryObject.of(ItemCapes.id("crafting_cape_shaped"), ForgeRegistries.RECIPE_SERIALIZERS);

//         public Serializer()
//         {
//             setRegistryName(SERIALIZER.getId());
//         }

//         @Override
//         public ShapedCapeRecipe fromJson(ResourceLocation id, JsonObject json)
//         {
//             return wrap(super.fromJson(id, json), json);
//         }

//         @Override
//         public ShapedRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buffer)
//         {
//             return wrap(super.fromNetwork(id, buffer), null);
//         }
//     }
// }
