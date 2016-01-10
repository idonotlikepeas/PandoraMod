package com.bluestreakgames.pandoramod.entity.monster;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

/**
 * Created by jkantzer on 1/10/16.
 */
public class EntityGhastPrime extends EntityGhast {
    protected int maxFlyHeight = 96;

    public EntityGhastPrime(World worldIn) {
        super(worldIn);

        // We limit fly height because there's no ceiling in the overworld
        tasks.addTask(6, new EntityGhastPrime.AIFlyHeightLimiter());

        // It's a baby compared to Hell's Ghasts :)
        this.setSize(2.0F, 2.0F);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        // Set fire in daylight - basically ripped wholesale from EntitySkeleton
        if (this.worldObj.isDaytime() && !this.worldObj.isRemote)
        {
            float f = this.getBrightness(1.0F);
            BlockPos blockpos = new BlockPos(this.posX, (double)Math.round(this.posY), this.posZ);

            if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.worldObj.canSeeSky(blockpos))
            {
                this.isImmuneToFire = false;
                this.setFire(8);
            }
        }
    }

    @Override
    public boolean getCanSpawnHere() {
        // If a normal Ghast couldn't spawn here, this can't either
        boolean superCanSpawnHere = super.getCanSpawnHere();
        if (!superCanSpawnHere) {
            return false;
        }

        // Can't spawn this underground
        int x = MathHelper.floor_double(this.posX);
        int y = MathHelper.floor_double(this.posY);
        int z = MathHelper.floor_double(this.posZ);
        if (!worldObj.canSeeSky(new BlockPos(x, y, z))) {
            return false;
        }

        // Check for daylight
        if(!isValidLightLevel()) {
            return false;
        }

        return true;
    }

    /**
     * Checks to make sure the light is not too bright where the mob is spawning
     *
     * I'd happily use EntityMob's method, but it's protected and EntityGhast
     * doesn't inherit from EntityMob because it flies...
     */
    protected boolean isValidLightLevel()
    {
        BlockPos blockpos = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);

        if (this.worldObj.getLightFor(EnumSkyBlock.SKY, blockpos) > this.rand.nextInt(32))
        {
            return false;
        }
        else
        {
            int i = this.worldObj.getLightFromNeighbors(blockpos);

            if (this.worldObj.isThundering())
            {
                int j = this.worldObj.getSkylightSubtracted();
                this.worldObj.setSkylightSubtracted(10);
                i = this.worldObj.getLightFromNeighbors(blockpos);
                this.worldObj.setSkylightSubtracted(j);
            }

            return i <= this.rand.nextInt(8);
        }
    }

    class AIFlyHeightLimiter extends EntityAIBase {
        EntityMoveHelper entityMoveHelper;

        @Override
        public boolean shouldExecute() {
            entityMoveHelper = EntityGhastPrime.this.getMoveHelper();

            // We let the Ghast Prime go above max height if attacking someone
            return entityMoveHelper.func_179919_e() > maxFlyHeight && getAttackTarget() == null;
        }

        @Override
        public void startExecuting() {
            entityMoveHelper.setMoveTo(entityMoveHelper.func_179917_d(), maxFlyHeight, entityMoveHelper.func_179918_f(), entityMoveHelper.getSpeed());
        }
    }
}
