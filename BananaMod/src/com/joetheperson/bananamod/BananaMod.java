package com.joetheperson.bananamod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;

@Mod(modid = BananaMod.modID, name = "BananaMod", version = "1.0.0")
@NetworkMod(clientSideRequired = true)
public class BananaMod {
    // Item
    public static final ItemBanana itemBanana = new ItemBanana(5000, 1, 5.0f);

    // Block
    public static final Block blockBanana = new BlockBasic(200, Material.cloth)
            .setHardness(0.5f)
            .setCreativeTab(CreativeTabs.tabBlock)
            .setUnlocalizedName("blockBanana")
            .setTextureName(BananaMod.modID + ":blockBanana");
    public static final BlockPortalBanana blockPortalBanana = new BlockPortalBanana(201);

    // Dimension
    public static final int bananaDimensionID = 6;

    // Biome
    public static final BiomeGenBase biomeGenBanana = new BiomeGenBanana(25);

    // Init
    public static final String modID = "BananaMod";
    @Instance(value = "BananaMod")
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

        // Recipes
        ItemStack bananas = new ItemStack(itemBanana);
        GameRegistry.addShapelessRecipe(new ItemStack(blockBanana),
                bananas, bananas, bananas,
                bananas, bananas, bananas,
                bananas, bananas, bananas);

        // Game Registry - Block
        GameRegistry.registerBlock(blockBanana, BananaMod.modID + blockBanana.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(blockPortalBanana, BananaMod.modID + blockPortalBanana.getUnlocalizedName().substring(5));

        // Language Registry - Item
        LanguageRegistry.addName(itemBanana, "Banana");

        // Language Registry - Block
        LanguageRegistry.addName(blockBanana, "Banana Block");
        LanguageRegistry.addName(blockPortalBanana, "Banana Portal Block");

        // Dimension
        DimensionManager.registerProviderType(BananaMod.bananaDimensionID, WorldProviderBanana.class, false);
        DimensionManager.registerDimension(BananaMod.bananaDimensionID, BananaMod.bananaDimensionID);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        // stub
    }
}
