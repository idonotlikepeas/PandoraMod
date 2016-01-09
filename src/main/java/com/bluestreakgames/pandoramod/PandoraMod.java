package com.bluestreakgames.pandoramod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

/**
 * Created by jkantzer on 1/9/16.
 */
@Mod(modid = PandoraMod.MODID, version = PandoraMod.VERSION)
public class PandoraMod {
    public static final String MODID = "pandoramod";
    public static final String VERSION = "0.1";

    @Instance
    public static PandoraMod instance = new PandoraMod();

    @SidedProxy(clientSide = "com.bluestreakgames.pandoramod.ClientProxy", serverSide = "com.bluestreakgames.pandoramod.ServerProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        this.proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        this.proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        this.proxy.postInit(event);
    }
}
