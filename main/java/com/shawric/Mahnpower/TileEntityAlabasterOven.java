package com.shawric.Mahnpower;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAlabasterOven extends TileEntity implements ISidedInventory{

	
	private String localizedName;
	
	private ItemStack [] slots = new ItemStack [3];
	
	
	//hopper automation, setting the slots
	private static final int[] slots_top = new int[]{0};
	private static final int[] slots_bottom = new int[]{2, 1};
	private static final int[] slots_side = new int[]{1};
	
	public int furnaceSpeed;
	
	//the number of ticks that the furnace will keep burning
	public int burnTime;
	
	//the number of ticks that a fresh copy of the currently burning item would keep the furance burning for
	public int currentItemBurnTime;
	
	//the number of ticks that hte current item has been cooking for
	public int cookTime;
 	
	public void setGuiDisplayName(String displayName) {

		this.localizedName = displayName;
	}


	public boolean hasCustomInventoryName() {
		
		return this.localizedName != null && this.localizedName.length()>0;
	}
	
	
	public String getInventoryName()
	{
		return this.hasCustomInventoryName() ? this.localizedName : "contianer.alabasterOven";
	}
	
	public int getSizeInventory()
	{
		return this.slots.length;
	}


	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		// TODO Auto-generated method stub
		return false;
	}


	
	public void openInventory() {}
	public void closeInventory() {}


	@Override
	public boolean isItemValidForSlot(int i, ItemStack var2) {
		
		return i == 2 ? false : (i==1 ? isItemFuel(var2) : true);
	}


	private static boolean isItemFuel(ItemStack var2) {
		
		return getItemBurnTime(var2) > 0;
	}


	private static int getItemBurnTime(ItemStack var2) {
		
		if(var2 == null)
		{
		return 0;
		}else {
			Item itm = var2.getItem();
			
			if(itm instanceof ItemBlock && Block.getBlockFromItem(itm) != Blocks.air)
			{
				Block blk = Block.getBlockFromItem(itm);
				
				//define fuel burn times
				
				if(itm == Mahnpower.woodenMahnkenism) return 800;
				if(itm == Items.coal) return 1600;
				if(itm == Items.stick) return 100;
				if(itm == Items.lava_bucket) return 20000;
				if(blk == Blocks.coal_block) return 15000;
				
				return GameRegistry.getFuelValue(var2);
			}
		
		}
		return 0;
	}


	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		
		return var1 == 0 ? slots_bottom : (var1== 1 ? slots_top : slots_side);
	}


	//for hopper automation, inserting items into slots
	@Override
	public boolean canInsertItem(int i, ItemStack var2, int j) {
		
		return this.isItemValidForSlot(i, var2);
	}

	//for hopper automation - only extract from thirds slot - output slot
	@Override
	public boolean canExtractItem(int i, ItemStack var2, int j) {
		
		return j != 0 || i != 1 || var2.getItem() == Items.bucket;
	}
	
	
	

}
