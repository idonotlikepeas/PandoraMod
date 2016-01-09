package com.bluestreakgames.pandoramod.item.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by jkantzer on 1/9/16.
 */
public class PandoraRecipes {
    public static void addRecipes() {
        // Friendly rotten flesh -> leather recipe because getting leather is hard
        GameRegistry.addRecipe(new ItemStack(Items.leather), "###", "###", "###", '#', Items.rotten_flesh);
    }
}
