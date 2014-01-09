package com.joetheperson.bananamod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = BananaMod.modID, name = "BananaMod", version = "1.0.0")
@NetworkMod(clientSideRequired = true)
public class BananaMod {
    // Item
    public static final BananaItem bananaItem = new BananaItem(5000);
    // Init
    public static final String modID = "BananaMod";
    @Instance(value = "BananaModID")
    public static BananaMod instance;

    @SidedProxy(clientSide = "com.joetheperson.bananamod.client.ClientProxy", serverSide = "com.joetheperson.bananamod.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // stub
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {
        proxy.registerRenderers();

        LanguageRegistry.addName(bananaItem, "Banana");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        // stub
    }
}
