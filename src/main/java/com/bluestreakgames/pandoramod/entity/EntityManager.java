package com.bluestreakgames.pandoramod.entity;

import com.bluestreakgames.pandoramod.PandoraMod;
import com.bluestreakgames.pandoramod.entity.monster.IPandoraMob;
import com.bluestreakgames.pandoramod.entity.monster.CreeperPrime;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.util.ArrayList;

/**
 * Created by jkantzer on 1/9/16.
 */
public class EntityManager {
    static ArrayList<IPandoraMob> monsters;

    public static void initMonsters() {
        monsters = new ArrayList<IPandoraMob>();
        int idCounter = 0;

        CreeperPrime cp = new CreeperPrime();
        monsters.add(cp);

        for(IPandoraMob monster : monsters) {
            EntityRegistry.registerModEntity(monster.getEntityClass(), monster.getEntityName(), ++idCounter, PandoraMod.instance, monster.getTrackingRange(), monster.getUpdateFrequency(), monster.getSendsVelocityUpdates(), monster.getEggPrimary(), monster.getEggSecondary());
        }
    }

    public static void registerMonsterRenderers() {
        for(IPandoraMob monster : monsters) {
            RenderManager manager = Minecraft.getMinecraft().getRenderManager();
            RenderingRegistry.registerEntityRenderingHandler(monster.getEntityClass(), monster.getEntityRenderer(manager));
        }
    }
}
