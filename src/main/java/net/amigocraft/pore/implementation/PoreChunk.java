package net.amigocraft.pore.implementation;

import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;

public class PoreChunk implements Chunk {

	//TODO: reference Sponge's chunk pore

	@Override
	public int getX(){
		return 0; //TODO: bridge
	}

	@Override
	public int getZ(){
		return 0; //TODO: bridge
	}

	@Override
	public World getWorld(){
		return null; //TODO: bridge
	}

	@Override
	public Block getBlock(int x, int y, int z){
		return null; //TODO: bridge
	}

	@Override
	public ChunkSnapshot getChunkSnapshot(){
		return null; //TODO: bridge
	}

	@Override
	public ChunkSnapshot getChunkSnapshot(boolean includeMaxblocky, boolean includeBiome, boolean includeBiomeTempRain){
		return null; //TODO: bridge
	}

	@Override
	public Entity[] getEntities(){
		return new Entity[0]; //TODO: bridge
	}

	@Override
	public BlockState[] getTileEntities(){
		return new BlockState[0]; //TODO: bridge
	}

	@Override
	public boolean isLoaded(){
		return false; //TODO: bridge
	}

	@Override
	public boolean load(boolean generate){
		return false; //TODO: bridge
	}

	@Override
	public boolean load(){
		return false; //TODO: bridge
	}

	@Override
	public boolean unload(boolean save, boolean safe){
		return false; //TODO: bridge
	}

	@Override
	public boolean unload(boolean save){
		return false; //TODO: bridge
	}

	@Override
	public boolean unload(){
		return false; //TODO: bridge
	}
}