package com.shawric.Mahnpower;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
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
		//return meta == 0 && side == 3 ? this.iconFront : (side == 0 || side == 1 ? this.iconTop : this.blockIcon);
		
		return meta == 0 && side == 3 ? this.iconFront : side == 1 ? this.iconTop : (side == 0 ? this.iconTop : (side == meta ? this.iconFront : this.blockIcon));
		
	}
	
	
	public Item getItemDropped(World wrld1, int x, int y , int z)
	{
		return Item.getItemFromBlock(Mahnpower.blockAlabastertOvenIdle);
	}
	
	public void onBlockAdded(World wrld1, int x, int y , int z)
	{
		super.onBlockAdded(wrld1, x, y, z);
		this.setDefaultDirection(wrld1, x, y, z);
	}
	
	
	private void setDefaultDirection(World wrld1, int x, int y, int z) {
		if(!wrld1.isRemote)
		{
			Block b1 = wrld1.getBlock(x, y, (z-1));
			Block b2 = wrld1.getBlock(x, y, (z+1));
			Block b3 = wrld1.getBlock((x-1), y, z);
			Block b4 = wrld1.getBlock((x+1), y, z);
		
		
		byte b0 = 3;
		
		if(b1.func_149730_j() && !b2.func_149730_j() )
		{
			b0 = 3;
		}
		
		if(b2.func_149730_j() && !b1.func_149730_j() )
		{
			b0 = 2;
		}
		
		if(b3.func_149730_j() && !b4.func_149730_j() )
		{
			b0 = 5;
		}
		
		if(b4.func_149730_j() && !b3.func_149730_j() )
		{
			b0 = 4;
		}
		
		wrld1.setBlockMetadataWithNotify(x, y, z, b0, 2);
		
		}
	}

	
	//ToDo onBlockAvtivated
	
	
	
	
	@Override
	public TileEntity createNewTileEntity(World qorld1, int var1) {
		
		return new TileEntityAlabasterOven();
	}


	
	//todo random display tick
	
	
	public void onBlockPlacedBy(World wrld1, int x, int y, int z, EntityLivingBase entPlayer , ItemStack istk)
	{
		int i = MathHelper.floor_double((double)(entPlayer.rotationYaw * 4.0 / 360.F) + 0.05D) & 3;
		
		if(i == 0)
		{
			wrld1.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		if(i == 1)
		{
			wrld1.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
		if(i == 2)
		{
			wrld1.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		if(i == 3)
		{
			wrld1.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
		
		if(istk.hasDisplayName())
		{
			((TileEntityAlabasterOven)wrld1.getTileEntity(x,y,z)).setGuiDisplayName(istk.getDisplayName());
		}
		
	}
	
	
	public boolean onBlockActivated(World wrld1, int x, int y, int z, EntityPlayer player, int side, float hitx, float hity, float hitz)
	{
		if(!wrld1.isRemote){
			FMLNetworkHandler.openGui(player, Mahnpower.instance, Mahnpower.guiIDAlabasterOven, wrld1, x, y, z);
			}
		
		return true;
	}
	
}
