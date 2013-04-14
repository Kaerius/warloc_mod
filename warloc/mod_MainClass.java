package warloc;

import net.minecraft.block.*; 
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraftforge.common.Configuration;
import net.minecraft.item.*;
import net.minecraft.potion.Potion;
import net.minecraft.src.ModLoader;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod; 
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "warloc", name = "Warloc", version = "0.0.0.02")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)


public class mod_MainClass{
	@SidedProxy(clientSide = "warloc.ClientProxy", serverSide = "warloc.ServerProxy")
	public static ServerPorxy proxy;
	public static CreativeTabs warlocTab = new warlocTab(CreativeTabs.getNextID(),"warlocTab"); //Среатив таблица
	/*Идеи:
	 * Задавать ИД чере массив с файла конфигурации
	 * Задавать текстуры по имени блока или предмета
	 * Разобратся с биомом почему через файл конфигурации ИД при генерации null
	 * Все входные параметры обявлять в основном файле? Или создать отдельный файл для блоков и предметов.
	 * Обявлять свойства block(200, 2, 3, rock, material) - пример
	 * Почистить и оптимизировать код
	 * */
	static int EntityCreeperManId = 2000;
	static int EntityFlamingoId = 2001;
	
	
	public static Block BlockDirtDead;
	public static int BlockDirtDeadID = 160;
	
	public static Block BlockStoneDirty;
	public static int BlockStoneDirtyID = 161;
	
	public static Block BlockCobblestoneDirty;
	public static int BlockCobblestoneDirtyID = 162;
	
	public static Block BlockBrickDirty;
	public static int BlockBrickDirtyID = 163;
	
	public static Block BlockOreColdIron;
	public static int BlockOreColdIronID = 164;
	
	public static Item ItemColdIron;
	public static int ItemColdIronID = 165;
	
	public static Item ItemDirtyShard;
	public static int ItemDirtyShardID = 166;
	
    @Instance("warlocID")
    public static mod_MainClass instance;
    
	@PreInit        
	public void load(FMLPreInitializationEvent event) {
		proxy.registerRenderThings(); 
	}
			
	@Init
	public void load(FMLInitializationEvent Event) {
		BlockDirtDead = new BlockDirtDead(BlockDirtDeadID);
		BlockStoneDirty = new BlockStoneDirty(BlockStoneDirtyID);
		BlockCobblestoneDirty = new BlockCobblestoneDirty(BlockCobblestoneDirtyID);
		BlockBrickDirty = new BlockBrickDirty(BlockBrickDirtyID);
		BlockOreColdIron = new BlockOreColdIron(BlockOreColdIronID);
		ItemColdIron = new ItemColdIron(ItemColdIronID);
		ItemDirtyShard = new ItemDirtyShard(ItemDirtyShardID);
		
		//регистрация блоков
		GameRegistry.registerBlock(BlockDirtDead, "Warloc.BlockDirtDead");
		GameRegistry.registerBlock(BlockStoneDirty, "Warloc.BlockStoneDirty");
		GameRegistry.registerBlock(BlockCobblestoneDirty, "Warloc.BlockCobblestoneDirty");
		GameRegistry.registerBlock(BlockBrickDirty, "Warloc.BlockBrickDirty");
		GameRegistry.registerBlock(BlockOreColdIron, "Warloc.BlockOreColdIron");
	
		//Крепость блоков каким инструментом разбивать и какого качества, 3 - алмазный, 2 - железный
		MinecraftForge.setBlockHarvestLevel(BlockDirtDead, "shovel" , 0 ) ;
		MinecraftForge.setBlockHarvestLevel(BlockOreColdIron, "pickaxe" , 3 ) ;
		
		//Регистрация рецептов
		GameRegistry.addShapelessRecipe(new ItemStack(ItemColdIron, 1), new Object[] {BlockOreColdIron});
		GameRegistry.addRecipe(new ItemStack(BlockBrickDirty, 1), new Object[] { "##", "##", '#', ItemDirtyShard});
		GameRegistry.addSmelting(BlockOreColdIronID, new ItemStack(ItemColdIron, 1), 5F);
		GameRegistry.addSmelting(BlockCobblestoneDirtyID, new ItemStack(BlockStoneDirty, 1), 5F);
		 
	    //Локализации en
	    LanguageRegistry.addName(BlockBrickDirty, "Brick Dirty");
	    LanguageRegistry.addName(BlockDirtDead, "Dirt Dead");
	    LanguageRegistry.addName(BlockStoneDirty, "Stone Dirty");
	    LanguageRegistry.addName(BlockCobblestoneDirty, "Cobblestone Dirty");
	    LanguageRegistry.addName(BlockOreColdIron, "Iron Cold Ore");
	    LanguageRegistry.addName(ItemColdIron, "Iron Cold");
	    LanguageRegistry.addName(ItemDirtyShard, "Shar Dirty");
	    LanguageRegistry.instance().addStringLocalization("entity.warloc.CreeperMan.name", "Creeper Man");
	    LanguageRegistry.instance().addStringLocalization("entity.warloc.Flamingo.name", "Flamingo");
		
	    //Локализации ru
	    LanguageRegistry.instance().addNameForObject(BlockBrickDirty, "ru_RU", "Проклятый кирпич");
		LanguageRegistry.instance().addNameForObject(BlockDirtDead, "ru_RU", "Проклятая земля");
		LanguageRegistry.instance().addNameForObject(BlockStoneDirty, "ru_RU", "Проклятый камень");
		LanguageRegistry.instance().addNameForObject(BlockCobblestoneDirty, "ru_RU", "Проклятый булыжник");
		LanguageRegistry.instance().addNameForObject(BlockOreColdIron, "ru_RU", "Руда хладного железа");
		LanguageRegistry.instance().addNameForObject(ItemColdIron, "ru_RU", "Хладное железо");
		LanguageRegistry.instance().addNameForObject(ItemDirtyShard, "ru_RU", "Проклятый кирпич");
		LanguageRegistry.instance().addStringLocalization("entity.warloc.CreeperMan.name", "ru_RU", "Человека крипер");
		LanguageRegistry.instance().addStringLocalization("entity.warloc.Flamingo.name", "ru_RU", "Фламинго");

		//Тут наш моб, нужно сократить и разобратся
		proxy.registerRenderThings();

		//регистрируем моба
		EntityRegistry.registerModEntity(EntityCreeperMan.class, "CreeperMan", 1, this, 80, 3, true);
		EntityRegistry.registerModEntity(EntityFlamingo.class, "Flamingo", 2, this, 81, 4, true);
		
		//регистрируем спавн
		EntityRegistry.addSpawn(EntityCreeperMan.class, 10, 2, 4, EnumCreatureType.monster, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.forest);
		EntityRegistry.addSpawn(EntityFlamingo.class, 10, 2, 4, EnumCreatureType.monster, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.forest);
		
		//регистрируем яйцо
		registerEntityEggCreeperMan(EntityCreeperMan.class, 0xffff00, 0x00ffff);
		registerEntityEggFlamingo(EntityFlamingo.class, 0xffffff, 0x000000);
	}
	
	//CreeperMan
	public static void registerEntityEggCreeperMan(Class<? extends Entity> entity, int primaryColor, int secondaryColor){
		EntityList.IDtoClassMapping.put(EntityCreeperManId, entity);
		EntityList.entityEggs.put(EntityCreeperManId, new EntityEggInfo(EntityCreeperManId, primaryColor, secondaryColor));
	}
	
	//Flamingo
	public static void registerEntityEggFlamingo(Class<? extends Entity> entity, int primaryColor, int secondaryColor){
		EntityList.IDtoClassMapping.put(EntityFlamingoId, entity);
		EntityList.entityEggs.put(EntityFlamingoId, new EntityEggInfo(EntityFlamingoId, primaryColor, secondaryColor));
	}
	
	@PostInit
	public static void postInit(FMLPostInitializationEvent event){
		//Регистрация генерации биомов, руд, строений
		GameRegistry.addBiome(new BiomCemetry());
		GameRegistry.registerWorldGenerator(new OreColdIron());
	}
}
