package warloc;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class BlockStoneDirty extends Block{
	
	public BlockStoneDirty(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setCreativeTab(mod_MainClass.warlocTab);
		this.setUnlocalizedName("BlockStoneDirty"); 
		this.setHardness(5.0F); 
		this.setResistance(10.0F); 
	}
	
    @SideOnly(Side.CLIENT)

    public void registerIcons(IconRegister par1IconRegister) {
    	
        this.blockIcon = par1IconRegister.registerIcon("warloc:BlockStoneDirty");
    }
    public int idDropped(int par1, Random random, int par2)
    {
       return mod_MainClass.ItemDirtyShard.itemID; 
    }
}