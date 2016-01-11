package com.bluestreakgames.pandoramod.entity.monster;

import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderChicken;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.util.MathHelper;
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

    // Adapted from RenderCreeper
    protected void updateChickenScale(EntityChickenPrime cp, float p_180570_2_) {
        float f1 = cp.getChickenFlashIntensity(p_180570_2_);
        float f2 = 1.0F + MathHelper.sin(f1 * 100.0F) * f1 * 0.01F;
        f1 = MathHelper.clamp_float(f1, 0.0F, 1.0F);
        f1 *= f1;
        f1 *= f1;
        float f3 = (1.0F + f1 * 0.4F) * f2;
        float f4 = (1.0F + f1 * 0.1F) / f2;
        GlStateManager.scale(f3, f4, f3);
    }

    // Adapted from RenderCreeper
    protected int updateChickenColorMultiplier(EntityChickenPrime cp, float p_180571_2_, float p_180571_3_) {
        float f2 = cp.getChickenFlashIntensity(p_180571_3_);

        if ((int)(f2 * 10.0F) % 2 == 0) {
            return 0;
        }
        else {
            int i = (int)(f2 * 0.2F * 255.0F);
            i = MathHelper.clamp_int(i, 0, 255);
            return i << 24 | 16777215;
        }
    }

    @Override
    protected void preRenderCallback(EntityLivingBase cp, float p_77041_2_) {
        updateChickenScale((EntityChickenPrime)cp, p_77041_2_);
    }

    @Override
    protected int getColorMultiplier(EntityLivingBase cp, float p_77030_2_, float p_77030_3_) {
        return updateChickenColorMultiplier((EntityChickenPrime)cp, p_77030_2_, p_77030_3_);
    }
}
