package com.joetheperson.bananamod;

import net.minecraft.world.biome.BiomeGenBase;

/**
 * Created by Ishan on 1/8/14.
 */
public class BiomeGenBanana extends BiomeGenBase {
    public BiomeGenBanana(int id) {
        super(id);

        spawnableCreatureList.clear();
        topBlock = (byte)BananaMod.blockBanana.blockID;
        fillerBlock = (byte)BananaMod.blockBanana.blockID;

    }
}
