package warloc;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBrickDirty extends Block{

	public BlockBrickDirty(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setCreativeTab(mod_MainClass.warlocTab); //The tab it appears in
		this.setUnlocalizedName("BlockBrickDirty"); //The incode name of the block
		this.setHardness(5.0F); //How hard the block is to break
		this.setResistance(10.0F); //How well the block resists explosions
		//setStepSound(super.soundMetalFootstep); //The sound the block makes when you walk on it as well as place or break it


	}
	
	
	//public Icon = setUnlocalizedName + ":";
    @SideOnly(Side.CLIENT)

    public void registerIcons(IconRegister par1IconRegister) {
    	
		this.blockIcon = par1IconRegister.registerIcon("warloc:BlockBrickDirty");
    }
    
    public int idDropped(int par1, Random random, int par2)
    {
       return mod_MainClass.ItemDirtyShard.itemID; 
    }
    public int quantityDropped(Random random)
    {
       return 3+random.nextInt(1);
    }
}


