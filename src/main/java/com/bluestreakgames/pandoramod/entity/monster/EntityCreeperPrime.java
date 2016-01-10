package com.bluestreakgames.pandoramod.entity.monster;

import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.lang.reflect.Field;

/**
 * Created by jkantzer on 1/9/16.
 */
public class EntityCreeperPrime extends EntityCreeper {
    private int fuseTime = 30;
    private int explosionRadius = 30;

    public EntityCreeperPrime(World worldIn) {
        super(worldIn);
        setFuseTimeAndExplosionRadius();

        this.isImmuneToFire = true;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if(!this.isRiding() && !this.worldObj.isRemote && this.isEntityAlive()) {
            // Leave trail of fire
            int i = MathHelper.floor_double(this.posX);
            int j = MathHelper.floor_double(this.posY);
            int k = MathHelper.floor_double(this.posZ);

            Material blockMaterial = this.worldObj.getBlockState(new BlockPos(i, j, k)).getBlock().getMaterial();
            if (blockMaterial == Material.air) {
                this.worldObj.setBlockState(new BlockPos(i, j, k), Blocks.fire.getDefaultState());
            } else if (blockMaterial == Material.snow) {
                this.worldObj.setBlockState(new BlockPos(i, j, k), Blocks.air.getDefaultState());
            }
        }
    }

    private void setFuseTimeAndExplosionRadius() {
        try {
            Field explosionRadius = this.getClass().getSuperclass().getDeclaredField("explosionRadius");
            explosionRadius.setAccessible(true);
            explosionRadius.setInt(this, this.explosionRadius);

            Field fuseTime = this.getClass().getSuperclass().getDeclaredField("fuseTime");
            fuseTime.setAccessible(true);
            fuseTime.setInt(this, this.fuseTime);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
