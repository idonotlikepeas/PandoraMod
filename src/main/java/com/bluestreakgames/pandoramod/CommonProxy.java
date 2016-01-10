package com.bluestreakgames.pandoramod;

import com.bluestreakgames.pandoramod.entity.EntityManager;
import com.bluestreakgames.pandoramod.item.crafting.PandoraRecipes;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

/**
 * Created by jkantzer on 1/9/16.
 */
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
    }

    public void init(FMLInitializationEvent event) {
        PandoraRecipes.addRecipes();
        EntityManager.initMonsters();
    }

    public void postInit(FMLPostInitializationEvent event) {
    }
}
