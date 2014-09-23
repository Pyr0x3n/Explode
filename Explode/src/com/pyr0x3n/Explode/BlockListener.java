package com.pyr0x3n.Explode;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.util.Vector;

/**
 * Part of this code is gathered from diferent sources across forums
 * Credit to whom ever deserve it. If you reconise part of your code let me know...
 *
 */
public class BlockListener implements Listener {
	
	Main plugin;

	public BlockListener(Main plugin) {
		this.plugin=plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	@SuppressWarnings("deprecation")	
	public void onEntityExplode(EntityExplodeEvent event){
		if (event.isCancelled()){
			return;
		}
		if (event.blockList().isEmpty()){
			return;
		}
		for(Block b : event.blockList() ){
			if (plugin.disallowedBlocks.contains(b.getType())){
				continue;
			}
			float x = -2.0F + (float) (Math.random() * 6.0D);
			float y = -2.5F + (float) (Math.random() * 7.5D);
			float z = -2.0F + (float) (Math.random() * 6.0D);

			FallingBlock fallingBlock = b.getWorld().spawnFallingBlock(b.getLocation(), Material.LAVA, (byte) 9);
			fallingBlock.setDropItem(false);
			fallingBlock.setVelocity(new Vector(x, y, z));	
	
			b.setType(Material.AIR);
		}
	}
	
	/**
	 * make cracking sounds
	 * 
	@EventHandler
	public void onBlockChange(final EntityChangeBlockEvent e){
		e.setCancelled(true);
		if (e.getEntity() instanceof FallingBlock){
			FallingBlock fb = (FallingBlock) e.getEntity();
			fb.getWorld().playEffect(fb.getLocation(), Effect.STEP_SOUND, fb.getMaterial());
			//fb.remove();
		}
	}**/
}
