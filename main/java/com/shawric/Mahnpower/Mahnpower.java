package com.shawric.Mahnpower;


import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "shawric_mahnpower", name = "Mahnpower Mod", version = "0.0.1 MC_1.7.10")

public class Mahnpower {

	
	@SidedProxy(clientSide = "com.shawric.Mahnpower.Client", serverSide = "com.shawric.Mahnpower.Common")
	public static Common proxy;
	
	int entIDCount = 100;
	
	public static final String modid = "shawric_mahnpower";
	public static CreativeTabs tabMyMod = new MahnpowerCreativeTab("tabMahnpower");
	
	
	public static Item woodenMahnkenism;
	
	public static Block blockAlabastertOvenIdle;
	public static Block blockAlabastertOvenActive;
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
	
		//Items
		
		//create the Mahnkenisms takes string - Name, Int Tier, string type
		woodenMahnkenism = new Mahnkenism("woodenMahnkenism", 1, "Precise");
		
		GameRegistry.registerItem(woodenMahnkenism, modid + (woodenMahnkenism.getUnlocalizedName().substring(5)));
		
		
		//Machines
		
		blockAlabastertOvenIdle = new AlabasterOven(false).setBlockName("AlabasterOvenIdle").setCreativeTab(tabMyMod);
		blockAlabastertOvenActive = new AlabasterOven(true).setBlockName("AlabasterOvenActive").setLightLevel(0.625F);
		
		GameRegistry.registerBlock(blockAlabastertOvenIdle, modid + (blockAlabastertOvenIdle.getUnlocalizedName().substring(5)));
		GameRegistry.registerBlock(blockAlabastertOvenActive, modid + (blockAlabastertOvenActive.getUnlocalizedName().substring(5)));
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event){
		
		//Creating item stacks for recipe creations
		ItemStack stickStack = new ItemStack(Items.stick);
		ItemStack planksStack = new ItemStack(Blocks.planks);
		ItemStack woodButtonStack = new ItemStack(Blocks.wooden_button);
		ItemStack woodPressurePlateStack = new ItemStack(Blocks.wooden_pressure_plate);
		
		/* RECIPES */
		
		//Mahnkenism recipes	
		GameRegistry.addShapedRecipe(new ItemStack(Mahnpower.woodenMahnkenism, 1), new Object[] {"PSP", "WBW", "PSP", 'S', stickStack, 'P', planksStack, 'B', woodButtonStack, 'W', woodPressurePlateStack});
		
		
		
	}
	
	
	
}
