package com.bluestreakgames.pandoramod.entity.monster;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;

/**
 * Created by jkantzer on 1/9/16.
 */
public interface IPandoraMob {
    Class<? extends Entity> getEntityClass();
    Render getEntityRenderer(RenderManager manager);
    String getEntityName();
    int getTrackingRange();
    int getUpdateFrequency();
    boolean getSendsVelocityUpdates();
    int getEggPrimary();
    int getEggSecondary();
}