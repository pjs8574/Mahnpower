package com.shawric.Mahnpower;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class GuiAlabasterOven extends GuiContainer{

	
	public TileEntityAlabasterOven alabasterOven;
	

	public GuiAlabasterOven(InventoryPlayer inventoryPlayer,  TileEntityAlabasterOven entity) {
		super(new ContainerAlabasterOven(inventoryPlayer, entity));
		this.alabasterOven = entity;
	}


	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
			int p_146976_2_, int p_146976_3_) {
		// TODO Auto-generated method stub
		
	}

}
