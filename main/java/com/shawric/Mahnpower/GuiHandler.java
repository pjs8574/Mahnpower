package com.shawric.Mahnpower;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {


TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null)
		{
			switch(ID){
			case Mahnpower.guiIDAlabasterOven:
				if(entity instanceof TileEntityAlabasterOven)
					{
					return new ContainerAlabasterOven(player.inventory, (TileEntityAlabasterOven) entity);
					}
				return null;
				}
			}
			return null;

	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {


		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null)
		{
			switch(ID){
			case Mahnpower.guiIDAlabasterOven:
				if(entity instanceof TileEntityAlabasterOven){
					return new GuiAlabasterOven(player.inventory, (TileEntityAlabasterOven) entity);
					}
				return null;
				}
			}
			return null;

	}

}
