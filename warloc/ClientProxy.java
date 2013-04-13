package warloc;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import cpw.mods.fml.client.registry.RenderingRegistry;
public class ClientProxy extends ServerPorxy{
	@Override
	public void registerRenderThings(){
		RenderingRegistry.registerEntityRenderingHandler(EntityCreeperMan.class, new RenderCreeperMan(new ModelBiped(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityFlamingo.class, new RenderFlamingo(new ModelFlamingo(), 0.4F));
	}
}