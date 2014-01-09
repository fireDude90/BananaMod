package com.joetheperson.bananamod;

import com.joetheperson.bananamod.BananaMod;
import com.joetheperson.bananamod.TeleporterBanana;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.src.ModLoader;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.server.MinecraftServer;

public class BlockPortalBanana extends BlockPortal {
    public BlockPortalBanana(int id) {
        super(id);
        setCreativeTab(CreativeTabs.tabBlock);
        setUnlocalizedName("blockPortalBanana");

    }

    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
        if ((par5Entity.ridingEntity == null) && (par5Entity.riddenByEntity == null) && ((par5Entity instanceof EntityPlayerMP))) {
            EntityPlayerMP player = (EntityPlayerMP) par5Entity;
            ModLoader.getMinecraftServerInstance();
            MinecraftServer mServer = MinecraftServer.getServer();

            if (player.timeUntilPortal > 0) {
                player.timeUntilPortal = 10;
            } else if (player.dimension != BananaMod.bananaDimensionID) {
                player.timeUntilPortal = 10;

                player.mcServer.getConfigurationManager().transferPlayerToDimension(player, BananaMod.bananaDimensionID, new TeleporterBanana(mServer.worldServerForDimension(BananaMod.bananaDimensionID)));
            } else {
                player.timeUntilPortal = 10;
                player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new TeleporterBanana(mServer.worldServerForDimension(1)));
            }
        }
    }

    public boolean tryToCreatePortal(World par1World, int par2, int par3, int par4)
    {
        byte b0 = 0;
        byte b1 = 0;

        if (par1World.getBlockId(par2 - 1, par3, par4) == Block.obsidian.blockID || par1World.getBlockId(par2 + 1, par3, par4) == Block.obsidian.blockID)
        {
            b0 = 1;
        }

        if (par1World.getBlockId(par2, par3, par4 - 1) == Block.obsidian.blockID || par1World.getBlockId(par2, par3, par4 + 1) == Block.obsidian.blockID)
        {
            b1 = 1;
        }

        if (b0 == b1)
        {
            return false;
        }
        else
        {
            if (par1World.isAirBlock(par2 - b0, par3, par4 - b1))
            {
                par2 -= b0;
                par4 -= b1;
            }

            int l;
            int i1;

            for (l = -1; l <= 2; ++l)
            {
                for (i1 = -1; i1 <= 3; ++i1)
                {
                    boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;

                    if (l != -1 && l != 2 || i1 != -1 && i1 != 3)
                    {
                        int j1 = par1World.getBlockId(par2 + b0 * l, par3 + i1, par4 + b1 * l);
                        boolean isAirBlock = par1World.isAirBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l);

                        if (flag)
                        {
                            if (j1 != Block.obsidian.blockID)
                            {
                                return false;
                            }
                        }
                        else if (!isAirBlock && j1 != Block.fire.blockID)
                        {
                            return false;
                        }
                    }
                }
            }

            for (l = 0; l < 2; ++l)
            {
                for (i1 = 0; i1 < 3; ++i1)
                {
                    par1World.setBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l, Block.portal.blockID, 0, 2);
                }
            }

            return true;
        }
    }

}
