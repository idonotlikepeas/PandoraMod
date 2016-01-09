package com.bluestreakgames.pandoramod.entity.monster;

import net.minecraft.entity.Entity;

/**
 * Created by jkantzer on 1/9/16.
 */
public class CreeperPrime extends AbstractPandoraMob {
    @Override
    Class<? extends Entity> getEntityClass() {
        return EntityCreeperPrime.class;
    }

    @Override
    String getEntityName() {
        return "CreeperPrime";
    }

    @Override
    int getTrackingRange() {
        return 64;
    }

    @Override
    int getUpdateFrequency() {
        return 3;
    }

    @Override
    boolean getSendsVelocityUpdates() {
        return true;
    }

    @Override
    int getEggPrimary() {
        return 0;
    }

    @Override
    int getEggSecondary() {
        return 26112;
    }
}
