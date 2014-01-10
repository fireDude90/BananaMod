package com.joetheperson.bananamod;

import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import java.util.Random;

/**
 * Created by Ishan on 1/8/14.
 */
public class BlockBanana extends Block {
    public BlockBanana(int id) {
        super(id, Material.grass);
        setHardness(0.5f);
        setCreativeTab(CreativeTabs.tabBlock);
        setUnlocalizedName("blockBanana");
        setTextureName(BananaMod.modID + ":blockBanana");
        setStepSound(soundSandFootstep);
    }

    @Override
    public int idDropped(int par1, Random par2Random, int par3) {
        return BananaMod.itemBanana.itemID;
    }
}
