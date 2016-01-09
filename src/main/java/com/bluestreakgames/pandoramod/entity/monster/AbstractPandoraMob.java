package com.bluestreakgames.pandoramod.entity.monster;

import com.bluestreakgames.pandoramod.PandoraMod;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.registry.EntityRegistry;

/**
 * Created by jkantzer on 1/9/16.
 */
public abstract class AbstractPandoraMob {
    abstract Class<? extends Entity> getEntityClass();
    abstract String getEntityName();
    abstract int getTrackingRange();
    abstract int getUpdateFrequency();
    abstract boolean getSendsVelocityUpdates();
    abstract int getEggPrimary();
    abstract int getEggSecondary();

    public void registerMob(int id) {
        EntityRegistry.registerModEntity(this.getEntityClass(), this.getEntityName(), id, PandoraMod.instance, this.getTrackingRange(), this.getUpdateFrequency(), this.getSendsVelocityUpdates(), this.getEggPrimary(), this.getEggSecondary());
    }
}