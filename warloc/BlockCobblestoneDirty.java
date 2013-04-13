package warloc;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCobblestoneDirty extends Block{
	public BlockCobblestoneDirty(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setCreativeTab(mod_MainClass.warlocTab);
		this.setUnlocalizedName("BlockCobblestoneDirty"); 
		this.setHardness(5.0F); 
		this.setResistance(10.0F); 
		//this.setStepSound(super.soundMetalFootstep);
	}
	
    //@SideOnly(Side.CLIENT)

    public void registerIcons(IconRegister par1IconRegister) {
    	
        this.blockIcon = par1IconRegister.registerIcon("warloc:BlockCobblestoneDirty");
    }
    
}

