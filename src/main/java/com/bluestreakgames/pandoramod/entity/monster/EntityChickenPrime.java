package com.bluestreakgames.pandoramod.entity.monster;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by jkantzer on 1/10/16.
 */
public class EntityChickenPrime extends EntityChicken {
    // Fundamentally, Chicken Prime is a chicken that acts like a creeper
    private int lastActiveTime;
    private int timeSinceIgnited;
    private int fuseTime = 30;
    private int explosionRadius = 3;

    public EntityChickenPrime(World worldIn) {
        super(worldIn);
        this.tasks.addTask(2, new EntityAIChickenSwell(this));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        int i = this.getChickenState();

        if (i > 0 && this.timeSinceIgnited == 0)
        {
            this.playSound("creeper.primed", 1.0F, 0.5F);
        }

        this.timeSinceIgnited += i;

        if (this.timeSinceIgnited < 0) {
            this.timeSinceIgnited = 0;
        }

        if (this.timeSinceIgnited >= this.fuseTime) {
            this.timeSinceIgnited = this.fuseTime;
            this.explode();
        }
    }

    protected void explode() {
        if (!this.worldObj.isRemote) {
            boolean flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
            this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, this.explosionRadius, flag);
            this.setDead();
        }
    }

    // From EntityCreeper
    @SideOnly(Side.CLIENT)
    public float getChickenFlashIntensity(float p_70831_1_) {
        return ((float)this.lastActiveTime + (float)(this.timeSinceIgnited - this.lastActiveTime) * p_70831_1_) / (float)(this.fuseTime - 2);
    }

    // From EntityCreeper
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte) - 1));
    }

    // From EntityCreeper
    public int getChickenState() {
        return this.dataWatcher.getWatchableObjectByte(16);
    }

    // From EntityCreeper
    public void setChickenState(int state) {
        this.dataWatcher.updateObject(16, Byte.valueOf((byte)state));
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setShort("Fuse", (short)this.fuseTime);
        tagCompound.setByte("ExplosionRadius", (byte)this.explosionRadius);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        super.readEntityFromNBT(tagCompund);
        if (tagCompund.hasKey("Fuse", 99)) {
            this.fuseTime = tagCompund.getShort("Fuse");
        }
        if (tagCompund.hasKey("ExplosionRadius", 99)) {
            this.explosionRadius = tagCompund.getByte("ExplosionRadius");
        }
    }

    // Adapted from EntityAICreeperSwell
    class EntityAIChickenSwell extends EntityAIBase {
        EntityChickenPrime swellingChicken;
        EntityLivingBase chickenAttackTarget;

        public EntityAIChickenSwell(EntityChickenPrime ecp) {
            this.swellingChicken = ecp;
            this.setMutexBits(1);
        }

        @Override
        public boolean shouldExecute() {
            EntityLivingBase entitylivingbase = this.swellingChicken.getAttackTarget();
            return this.swellingChicken.getChickenState() > 0 || entitylivingbase != null && this.swellingChicken.getDistanceSqToEntity(entitylivingbase) < 9.0D;
        }

        public void startExecuting() {
            this.swellingChicken.getNavigator().clearPathEntity();
            this.chickenAttackTarget = this.swellingChicken.getAttackTarget();
        }

        public void resetTask()
        {
            this.chickenAttackTarget = null;
        }

        public void updateTask() {
            if (this.chickenAttackTarget == null)
            {
                this.swellingChicken.setChickenState(-1);
            }
            else if (this.swellingChicken.getDistanceSqToEntity(this.chickenAttackTarget) > 49.0D)
            {
                this.swellingChicken.setChickenState(-1);
            }
            else if (!this.swellingChicken.getEntitySenses().canSee(this.chickenAttackTarget))
            {
                this.swellingChicken.setChickenState(-1);
            }
            else
            {
                this.swellingChicken.setChickenState(1);
            }
        }
    }
}