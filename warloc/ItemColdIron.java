package warloc;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemColdIron extends Item{
	
	public ItemColdIron(int par1) {
		super(par1);
		this.maxStackSize = 64;
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setCreativeTab(mod_MainClass.warlocTab);
		setUnlocalizedName("ItemColdIron"); 
	}
	
	@SideOnly(Side.CLIENT)
    public void updateIcons(IconRegister par1IconRegister){
        this.iconIndex = par1IconRegister.registerIcon("warloc:ItemColdIron");
    }
}

