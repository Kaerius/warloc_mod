package warloc;

import net.minecraft.src.*;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;
import cpw.mods.fml.common.IWorldGenerator; 

public class OreColdIron implements IWorldGenerator
{
	public void generate(Random random, int posX, int posZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.dimensionId) 
		{
		case -1:
			generateNether(world, random, posX*16, posZ*16);
		case 0:
			generateSurface(world, random, posX*16, posZ*16);
		}
	}
	
	public void generateSurface(World world, Random random, int posX, int posZ) 
	{
		int posX1 = posX + random.nextInt(16);
		int posY1 = random.nextInt(63);
		int posZ1 = posZ + random.nextInt(16);
		for(int i=0; i<64; i++)
			(new WorldGenMinable(mod_MainClass.BlockOreColdIron.blockID, 64)).generate(world, random, posX1, posY1, posZ1);
	}
	
	public void generateNether(World world, Random random, int posX, int posZ) 
	{
		
	}
}