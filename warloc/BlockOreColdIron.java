package warloc;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOreColdIron extends Block{
	public BlockOreColdIron(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setCreativeTab(mod_MainClass.warlocTab);
		this.setUnlocalizedName("BlockOreColdIron"); 
		this.setHardness(5.0F); 
		this.setResistance(10.0F); 
	}
	
    @SideOnly(Side.CLIENT)

    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon("warloc:BlockOreColdIron");
    }
    
}
