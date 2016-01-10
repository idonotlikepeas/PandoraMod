package com.bluestreakgames.pandoramod.entity.monster;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;

/**
 * Created by jkantzer on 1/9/16.
 */
public class CreeperPrime implements IPandoraMob {
    @Override
    public Class<? extends Entity> getEntityClass() {
        return EntityCreeperPrime.class;
    }

    @Override
    public Render getEntityRenderer(RenderManager manager) {
        return new RenderCreeperPrime(manager);
    }

    @Override
    public String getEntityName() {
        return "CreeperPrime";
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
        return 26112;
    }
}
