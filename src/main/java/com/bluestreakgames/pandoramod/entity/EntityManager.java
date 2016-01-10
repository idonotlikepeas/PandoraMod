package com.bluestreakgames.pandoramod.entity;

import com.bluestreakgames.pandoramod.PandoraMod;
import com.bluestreakgames.pandoramod.entity.monster.ChickenPrime;
import com.bluestreakgames.pandoramod.entity.monster.CreeperPrime;
import com.bluestreakgames.pandoramod.entity.monster.GhastPrime;
import com.bluestreakgames.pandoramod.entity.monster.IPandoraMob;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DungeonHooks;
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
        GhastPrime gp = new GhastPrime();
        monsters.add(gp);
        ChickenPrime chp = new ChickenPrime();
        monsters.add(chp);

        for(IPandoraMob monster : monsters) {
            EntityRegistry.registerModEntity(monster.getEntityClass(), monster.getEntityName(), ++idCounter, PandoraMod.instance, monster.getTrackingRange(), monster.getUpdateFrequency(), monster.getSendsVelocityUpdates(), monster.getEggPrimary(), monster.getEggSecondary());
            EntityRegistry.addSpawn(monster.getEntityClass(), monster.getSpawnWeightedProb(), monster.getSpawnMin(), monster.getSpawnMax(), EnumCreatureType.MONSTER, monster.getBiomesForSpawn());
        }

        DungeonHooks.addDungeonMob("CreeperPrime", 100);
    }

    public static void registerMonsterRenderers() {
        for(IPandoraMob monster : monsters) {
            RenderManager manager = Minecraft.getMinecraft().getRenderManager();
            RenderingRegistry.registerEntityRenderingHandler(monster.getEntityClass(), monster.getEntityRenderer(manager));
        }
    }

    public static BiomeGenBase[] getStandardBiomes() {
        // There isn't a better way to get this list, AFAIK. Excludes The End and Hell
        BiomeGenBase[] standardBiomes = {
                BiomeGenBase.beach,
                BiomeGenBase.birchForest,
                BiomeGenBase.birchForestHills,
                BiomeGenBase.coldBeach,
                BiomeGenBase.coldTaiga,
                BiomeGenBase.coldTaigaHills,
                BiomeGenBase.deepOcean,
                BiomeGenBase.desert,
                BiomeGenBase.desertHills,
                BiomeGenBase.extremeHills,
                BiomeGenBase.extremeHillsEdge,
                BiomeGenBase.extremeHillsPlus,
                BiomeGenBase.field_180279_ad,
                BiomeGenBase.forest,
                BiomeGenBase.forestHills,
                BiomeGenBase.frozenOcean,
                BiomeGenBase.frozenRiver,
                BiomeGenBase.iceMountains,
                BiomeGenBase.icePlains,
                BiomeGenBase.jungle,
                BiomeGenBase.jungleEdge,
                BiomeGenBase.jungleHills,
                BiomeGenBase.megaTaiga,
                BiomeGenBase.megaTaigaHills,
                BiomeGenBase.mesa,
                BiomeGenBase.mesaPlateau,
                BiomeGenBase.mesaPlateau_F,
                BiomeGenBase.mushroomIsland,
                BiomeGenBase.mushroomIslandShore,
                BiomeGenBase.ocean,
                BiomeGenBase.plains,
                BiomeGenBase.river,
                BiomeGenBase.roofedForest,
                BiomeGenBase.savanna,
                BiomeGenBase.savannaPlateau,
                BiomeGenBase.sky,
                BiomeGenBase.stoneBeach,
                BiomeGenBase.swampland,
                BiomeGenBase.taiga,
                BiomeGenBase.taigaHills
        };
        return standardBiomes;
    }
}
