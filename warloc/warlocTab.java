package warloc;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.*;
import warloc.mod_MainClass;;

public class warlocTab extends CreativeTabs {
public warlocTab(int position, String tabID) {
	super(position, tabID);
}
@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex(){

	return mod_MainClass.ItemDirtyShard.itemID;
}
	public String getTranslatedTabLabel(){

	return "W.A.R.L.O.C."; 
}
}