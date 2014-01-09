package com.joetheperson.bananamod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBanana extends ItemFood {
    public ItemBanana(int id, int healAmount, float saturationModifier) {
        super(id, healAmount, saturationModifier, false);
        setMaxStackSize(64);
        setCreativeTab(CreativeTabs.tabFood);
        setUnlocalizedName("banana");
        setTextureName(BananaMod.modID + ":" + getUnlocalizedName().substring(5));
    }
}
