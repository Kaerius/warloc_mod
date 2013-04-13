package warloc;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockDirtDead extends Block{
	
	public BlockDirtDead(int par1) {
		super(par1, Material.ground);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setCreativeTab(mod_MainClass.warlocTab);
		this.setUnlocalizedName("BlockDirtDead"); 
		this.setHardness(5.0F); 
		this.setResistance(10.0F); 
		this.setStepSound(super.soundGravelFootstep);
		//public static final StepSound soundGravelFootstep = new StepSound("gravel", 1.0F, 1.0F);
	}
	
    //@SideOnly(Side.CLIENT)

    public void registerIcons(IconRegister par1IconRegister) {
    	
        this.blockIcon = par1IconRegister.registerIcon("warloc:BlockDirtDead");
    }
    
}
