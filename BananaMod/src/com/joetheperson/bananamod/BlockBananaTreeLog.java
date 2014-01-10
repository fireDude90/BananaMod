package com.joetheperson.bananamod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Ishan on 1/9/14.
 */
public class BlockBananaTreeLog extends Block {
    public static final String[] woodType = new String[] { "treeBanana" };

    @SideOnly(Side.CLIENT)
    private Icon logTop;

    public BlockBananaTreeLog(int id) {
        super(id, Material.wood);
        setCreativeTab(CreativeTabs.tabBlock);
        setStepSound(soundWoodFootstep);
        setHardness(2);
        setUnlocalizedName("blockBananaTreeLog");
    }

    @Override
    // World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int data) {
        int j1 = data & 3;
        byte b0 = 0;
        switch (side) {
            case 0:
            case 1:
                b0 = 0; break;
            case 2:
            case 3:
                b0 = 8; break;
            case 4:
            case 5:
                b0 = 4; break;
        }

        return j1 | b0;
    }

    @Override
    public int idDropped(int par1, Random par2Random, int par3) {
        return this.blockID;
    }

    @Override
    public int quantityDropped(int meta, int fortune, Random random) {
        return 1;
    }

    @Override
    public Icon getIcon(int side, int data) {
        return side == 1 ? logTop : (side == 0 ? logTop : blockIcon);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IconRegister iconRegister) {
        String base = BananaMod.modID + ":" + getUnlocalizedName().substring(5);
        blockIcon = iconRegister.registerIcon(base + "Side");
        logTop = iconRegister.registerIcon(base + "Top");
    }
}
