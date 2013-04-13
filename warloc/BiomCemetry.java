package warloc;

import java.util.Random;

import warloc.mod_MainClass;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenDesertWells;

public class BiomCemetry extends BiomeGenBase
{
    private static int par1;
	public BiomCemetry() {
		super(par1);
		this.topBlock = (byte) mod_MainClass.BlockDirtDead.blockID;
		 this.fillerBlock = (byte) mod_MainClass.BlockStoneDirty.blockID;
		this.theBiomeDecorator.treesPerChunk = -999 ;
        this.theBiomeDecorator.deadBushPerChunk = 2;
        this.theBiomeDecorator.reedsPerChunk = 50;
        this.theBiomeDecorator.cactiPerChunk = 10;
    }
    public void decorate(World par1World, Random par2Random, int par3, int par4)
    {
        super.decorate(par1World, par2Random, par3, par4);

        if (par2Random.nextInt(1000) == 0)
        {
            int k = par3 + par2Random.nextInt(16) + 8;
            int l = par4 + par2Random.nextInt(16) + 8;
            WorldGenDesertWells worldgendesertwells = new WorldGenDesertWells();
            worldgendesertwells.generate(par1World, par2Random, k, par1World.getHeightValue(k, l) + 1, l);
        }
    }
	
}
