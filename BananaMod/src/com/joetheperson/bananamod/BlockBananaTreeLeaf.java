package com.joetheperson.bananamod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

import java.util.Random;

/**
 * Created by Ishan on 1/9/14.
 */
public class BlockBananaTreeLeaf extends Block {
    public BlockBananaTreeLeaf(int id) {
        super(id, Material.leaves);
        setUnlocalizedName("blockBananaTreeLeaf");
        setCreativeTab(CreativeTabs.tabBlock);
        setStepSound(soundGrassFootstep);
        setHardness(0.2f);
    }

    @Override
    public boolean isOpaqueCube() { return false; }

    @Override
    public int idDropped(int par1, Random par2Random, int par3) {
        return this.blockID;
    }

    @Override
    public int quantityDropped(Random par1Random) {
        return 1;
    }
}
