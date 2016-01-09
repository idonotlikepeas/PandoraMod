package com.bluestreakgames.pandoramod.entity;

import com.bluestreakgames.pandoramod.entity.monster.AbstractPandoraMob;
import com.bluestreakgames.pandoramod.entity.monster.CreeperPrime;

import java.util.ArrayList;

/**
 * Created by jkantzer on 1/9/16.
 */
public class EntityManager {
    public static void initMonsters() {
        ArrayList<AbstractPandoraMob> monsters = new ArrayList<AbstractPandoraMob>();
        int idCounter = 0;

        CreeperPrime cp = new CreeperPrime();
        monsters.add(cp);

        for(AbstractPandoraMob monster : monsters) {
            monster.registerMob(++idCounter);
        }
    }
}
