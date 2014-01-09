package com.joetheperson.bananamod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BananaItem extends Item {
    public BananaItem(int id) {
        super(id);
        setMaxStackSize(64);
        setCreativeTab(CreativeTabs.tabFood);
        setUnlocalizedName("bananaItem");
        setTextureName("bananamod:bananaItem");
    }
}
