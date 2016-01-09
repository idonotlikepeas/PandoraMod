package com.bluestreakgames.pandoramod.entity;

import com.bluestreakgames.pandoramod.PandoraMod;
import com.bluestreakgames.pandoramod.entity.monster.EntityCreeperPrime;
import net.minecraft.entity.EntityList;
import net.minecraftforge.fml.common.registry.EntityRegistry;

/**
 * Created by jkantzer on 1/9/16.
 */
public class EntityManager {
    public static void initMonsters() {
        int id = 1;
        EntityRegistry.registerModEntity(EntityCreeperPrime.class, "CreeperPrime", id, PandoraMod.instance, 64, 3, true, 0, 26112);
    }
}
