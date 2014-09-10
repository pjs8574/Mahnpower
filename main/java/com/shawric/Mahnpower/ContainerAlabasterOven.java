package com.shawric.Mahnpower;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerAlabasterOven extends Container{

	private TileEntityAlabasterOven alabasterOven;
	
	public ContainerAlabasterOven(InventoryPlayer inventory, TileEntityAlabasterOven tileEntity) {
		
		this.alabasterOven = tileEntity;
	
	}
	
	
	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		// TODO Auto-generated method stub
		return false;
	}

}
