package com.joetheperson.bananamod;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderBanana extends WorldProvider {
    private final String dimensionName = "Bananaland"; // this is used to create the folder

    @Override
    public String getDimensionName() {
        return dimensionName;
    }

    @Override
    protected void registerWorldChunkManager() {
        this.worldChunkMgr = new WorldChunkManagerHell(BananaMod.biomeGenBanana, 0, 0);
        this.dimensionId = BananaMod.bananaDimensionID;
    }

    @Override
    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderBanana(worldObj, worldObj.getSeed(), true);
    }
}
