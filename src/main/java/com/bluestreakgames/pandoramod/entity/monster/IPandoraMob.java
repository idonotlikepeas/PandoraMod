package com.bluestreakgames.pandoramod.entity.monster;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.biome.BiomeGenBase;

/**
 * Created by jkantzer on 1/9/16.
 */
public interface IPandoraMob {
    Class<? extends EntityLiving> getEntityClass();
    String getEntityName();
    int getTrackingRange();
    int getUpdateFrequency();
    boolean getSendsVelocityUpdates();
    int getEggPrimary();
    int getEggSecondary();

    BiomeGenBase[] getBiomesForSpawn();
    int getSpawnWeightedProb();
    int getSpawnMin();
    int getSpawnMax();

    Render getEntityRenderer(RenderManager manager);
}