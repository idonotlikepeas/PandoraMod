package com.bluestreakgames.pandoramod.entity.monster;

import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.renderer.entity.RenderChicken;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.util.ResourceLocation;

/**
 * Created by jkantzer on 1/10/16.
 */
public class RenderChickenPrime extends RenderChicken {
    private static final ResourceLocation chickenPrimeTextures = new ResourceLocation("pandoramod:textures/entity/chickenprime/chickenprime.png");

    public RenderChickenPrime(RenderManager manager) {
        super(manager, new ModelChicken(), 0.3F);
    }

    // Not sure why this is obfuscated, but it gets the chicken's texture location
    @Override
    protected ResourceLocation func_180568_a(EntityChicken p_180568_1_) {
        return chickenPrimeTextures;
    }
}
