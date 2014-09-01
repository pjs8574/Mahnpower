package com.shawric.Mahnpower;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = "shawric_mahnpower", name = "Mahnpower Mod", version = "0.0.1 MC_1.7.10")

public class Mahnpower {

	
	@SidedProxy(clientSide = "com.shawric.Mahnpower.Client", serverSide = "com.shawric.Mahnpower.Common")
	public static Common proxy;
	
	int entIDCount = 50;
	
	public static final String modid = "shawric_mahnpower";
	public static CreativeTabs tabMyMod = new MahnpowerCreativeTab("tabSiegeTech");
}
