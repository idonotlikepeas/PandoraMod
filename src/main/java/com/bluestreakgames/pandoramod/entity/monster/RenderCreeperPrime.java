package com.bluestreakgames.pandoramod.entity.monster;

import net.minecraft.client.renderer.entity.RenderCreeper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.ResourceLocation;

/**
 * Created by jkantzer on 1/9/16.
 */
public class RenderCreeperPrime extends RenderCreeper {
    private static final ResourceLocation creeperPrimeTextures = new ResourceLocation("pandoramod:textures/entity/creeperprime/creeperprime.png");

    public RenderCreeperPrime(RenderManager manager) {
        super(manager);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityCreeper entity) {
        return creeperPrimeTextures;
    }
}
