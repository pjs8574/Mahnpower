package com.shawric.Mahnpower;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiAlabasterOven extends GuiContainer{

	
	public static final ResourceLocation bground = new ResourceLocation(Mahnpower.modid,"textures/gui/AlabasterOvenGui.png");
	
	public TileEntityAlabasterOven alabasterOven;
	

	public GuiAlabasterOven(InventoryPlayer inventoryPlayer,  TileEntityAlabasterOven entity) {
		super(new ContainerAlabasterOven(inventoryPlayer, entity));
		this.alabasterOven = entity;
		
		this.xSize = 176;
		this.ySize = 166;
	}

	
	
	public void drawGuiContainerForegroundLayer(int var1, int var2)
	{
		String name = this.alabasterOven.hasCustomInventoryName() ? this.alabasterOven.getInventoryName() : I18n.format(this.alabasterOven.getInventoryName(), new Object[0]);
		
		//writing the name "Alabaster Oven" on top of the GUI
		this.fontRendererObj.drawString(name,this.xSize/2-this.fontRendererObj.getStringWidth(name)/2, 6, 4210752);
		
		//write "Inventory" at the bottom to indicate player inventory
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 128, this.ySize - 96 + 2, 4210752);
	}
	

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		// TODO Auto-generated method stub
		
	}

}
