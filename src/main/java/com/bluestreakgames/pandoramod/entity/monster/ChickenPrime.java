package com.bluestreakgames.pandoramod.entity.monster;

import com.bluestreakgames.pandoramod.entity.EntityManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.biome.BiomeGenBase;

/**
 * Created by jkantzer on 1/10/16.
 */
public class ChickenPrime implements IPandoraMob{
    @Override
    public Class<? extends EntityLiving> getEntityClass() {
        return EntityChickenPrime.class;
    }

    @Override
    public String getEntityName() {
        return "ChickenPrime";
    }

    @Override
    public int getTrackingRange() {
        return 64;
    }

    @Override
    public int getUpdateFrequency() {
        return 3;
    }

    @Override
    public boolean getSendsVelocityUpdates() {
        return true;
    }

    @Override
    public int getEggPrimary() {
        return 0;
    }

    @Override
    public int getEggSecondary() {
        return 16711680;
    }

    @Override
    public BiomeGenBase[] getBiomesForSpawn() {
        return EntityManager.getStandardBiomes();
    }

    @Override
    public int getSpawnWeightedProb() {
        return 10;
    }

    @Override
    public int getSpawnMin() {
        return 4;
    }

    @Override
    public int getSpawnMax() {
        return 4;
    }

    @Override
    public Render getEntityRenderer(RenderManager manager) {
        return new RenderChickenPrime(manager);
    }
}
