package com.shawric.Mahnpower;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Mahnkenism extends Item{
	
	private int itemTier;
	private String itemType;
	private int maxWinds;
	
	public Mahnkenism(String name, int tier, String itemTypePar) {
		
		this.setUnlocalizedName(name); //Sets the name of this item, Has to be unique!
		this.setCreativeTab(Mahnpower.tabMyMod);; //This Item will be in the Combat Creative Tab!
		this.setTextureName(Mahnpower.modid + ":" + this.getUnlocalizedName().substring(5)); //The texture for this item is the Grenade!

		this.setMaxStackSize(1);
		
		this.itemTier = tier;
		this.itemType = itemTypePar;
		
		if(itemType.equals("Precise"))
		{
		this.maxWinds = (this.itemTier*2);
		}else{
			if(itemType.equals("Tough"))
				{
				this.maxWinds = (this.itemTier*4);
				}
		}
		
		this.setMaxDamage(this.maxWinds);
	
		//this.damageItem((this.maxWinds-1));
		
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
	par3List.add("Tier: " + this.itemTier);
	par3List.add("Type: " + this.itemType);
	}
	
	@Override
	 public ItemStack onItemRightClick(ItemStack itemStk, World world1, EntityPlayer triggerPlayer)
	    {

		
		
		
		
	  	//
		itemStk.damageItem(1, triggerPlayer);
	  	
	  	return itemStk;
	    }
	
	
	
}
