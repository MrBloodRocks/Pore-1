package net.amigocraft.pore.implementation.entity;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;

public class PoreIronGolem extends PoreGolem implements IronGolem {

	//TODO: bridge

	//TODO: make constructor as specific as possible
	protected PoreIronGolem(org.spongepowered.api.entity.LivingEntity handle){
		super(handle);
	}

	public static PoreIronGolem of(org.spongepowered.api.entity.Entity handle){
		return (PoreIronGolem)PoreGolem.of(handle);
	}

	@Override
	public EntityType getType(){
		return EntityType.IRON_GOLEM;
	}

	@Override
	public boolean isPlayerCreated() {
		return false;
	}

	@Override
	public void setPlayerCreated(boolean playerCreated) {
		throw new NotImplementedException();
	}
}
