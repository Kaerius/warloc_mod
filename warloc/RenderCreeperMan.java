package warloc;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
public class RenderCreeperMan extends RenderLiving{
	protected ModelBiped model;
	public RenderCreeperMan (ModelBiped modelbase, float f){
		super(modelbase, f);
		model = ((ModelBiped)mainModel);
	}
	public void renderCreeperMan(EntityCreeperMan entity, double par2, double par4, double par6, float par8, float par9){
		super.doRenderLiving(entity, par2, par4, par6, par8, par9); 
	}
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9){
		renderCreeperMan((EntityCreeperMan)par1EntityLiving, par2, par4, par6, par8, par9); 
	}
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9){
		renderCreeperMan((EntityCreeperMan)par1Entity, par2, par4, par6, par8, par9);
	}
}