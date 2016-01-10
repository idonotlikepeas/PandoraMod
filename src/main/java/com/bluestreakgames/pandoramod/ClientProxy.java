package com.bluestreakgames.pandoramod;

import com.bluestreakgames.pandoramod.entity.monster.EntityCreeperPrime;
import com.bluestreakgames.pandoramod.entity.monster.RenderCreeperPrime;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by jkantzer on 1/9/16.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        RenderManager manager = Minecraft.getMinecraft().getRenderManager();
        RenderingRegistry.registerEntityRenderingHandler(EntityCreeperPrime.class, new RenderCreeperPrime(manager));
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}
