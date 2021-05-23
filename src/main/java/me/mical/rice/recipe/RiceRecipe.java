package me.mical.rice.recipe;

import me.mical.rice.items.Rice;
import me.mical.rice.items.RiceLi;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;
import org.serverct.parrot.parrotx.api.ParrotXAPI;

public class RiceRecipe {

    public static void initialize() {
        final ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(ParrotXAPI.getPlugin(me.mical.rice.Rice.class), "rice"), Rice.to());
        recipe.shape("aaa", "aaa", "aaa").setIngredient('a', RiceLi.to());
        Bukkit.addRecipe(recipe);
    }

}
