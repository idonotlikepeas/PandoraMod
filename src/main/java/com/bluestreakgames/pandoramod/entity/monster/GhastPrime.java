package com.bluestreakgames.pandoramod.entity.monster;

import com.bluestreakgames.pandoramod.entity.EntityManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

/**
 * Created by jkantzer on 1/10/16.
 */
public class GhastPrime implements IPandoraMob {
    @Override
    public Class<? extends EntityLiving> getEntityClass() {
        return EntityGhastPrime.class;
    }

    @Override
    public String getEntityName() {
        return "GhastPrime";
    }

    @Override
    public int getTrackingRange() {
        return 80;
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
        return 11184810;
    }

    @Override
    public EnumCreatureType getCreatureType() {
        return EnumCreatureType.MONSTER;
    }

    @Override
    public BiomeGenBase[] getBiomesForSpawn() {
        return EntityManager.getStandardBiomes();
    }

    @Override
    public int getSpawnWeightedProb() {
        return 50;
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
        return new RenderGhastPrime(manager);
    }
}
