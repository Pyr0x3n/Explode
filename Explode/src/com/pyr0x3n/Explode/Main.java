package com.pyr0x3n.Explode;

import java.util.ArrayList;
import java.util.logging.Level;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	public ArrayList<Material> disallowedBlocks = new ArrayList<Material>();
	
	@Override
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		new BlockListener(this);
		fillDisallowedBlocks();
		this.log("is now enabled" , Level.INFO);		
	}
	
	@Override
	public void onDisable() {
		this.log("is finaly disabled..." , Level.INFO);
	}

	public void log(String s, Level l){
		getLogger().log(l, s);
	}
	
	
	public void fillDisallowedBlocks(){
		disallowedBlocks.clear();
		disallowedBlocks.add(Material.TNT);
		disallowedBlocks.add(Material.OBSIDIAN);
	}




}
