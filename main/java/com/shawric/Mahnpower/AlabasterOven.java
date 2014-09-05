package com.shawric.Mahnpower;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AlabasterOven extends BlockContainer{

	
	private final boolean isActive;
	
	@SideOnly(Side.CLIENT)
	private IIcon iconFront;
	
	@SideOnly(Side.CLIENT)
	private IIcon iconTop;
	
	public AlabasterOven(boolean isActive) {
		super(Material.iron);
		this.isActive = isActive;
		
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(Mahnpower.modid + ":" + "AlabasterOvenSide");
		
		
		//? is an if statement in line it seems with two results being seperated by the colon.
		
		this.iconFront = iconRegister.registerIcon(Mahnpower.modid + ":" + (this.isActive ? "AlabasterOvenFrontOn" : "AlabasterOvenFrontOff" ));
		this.iconTop = iconRegister.registerIcon(Mahnpower.modid + ":" + ("AlabasterOvenTop"));
		
	
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side , int meta)
	{
		
		// SIDE KEY : 0 bottom, 1 top , 2 North. 3 South, 4 West ,5 East
		return meta == 0 && side == 3 ? this.iconFront : (side == 0 || side == 1 ? this.iconTop : this.blockIcon);
		
	}
	
	
	
	
	
	
	@Override
	public TileEntity createNewTileEntity(World qorld1, int var1) {
		// TODO Auto-generated method stub
		return null;
	}

}
