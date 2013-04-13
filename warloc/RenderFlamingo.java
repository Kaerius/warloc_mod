package warloc;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
public class RenderFlamingo extends RenderLiving{
	protected ModelFlamingo model;
	public RenderFlamingo (ModelFlamingo modelbase, float f){
		super(modelbase, f);
		model = ((ModelFlamingo)mainModel);
	}
	public void renderFlamingo(EntityFlamingo entity, double par2, double par4, double par6, float par8, float par9){
		super.doRenderLiving(entity, par2, par4, par6, par8, par9); 
	}
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9){
		renderFlamingo((EntityFlamingo)par1EntityLiving, par2, par4, par6, par8, par9); 
	}
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9){
		renderFlamingo((EntityFlamingo)par1Entity, par2, par4, par6, par8, par9);
	}
}