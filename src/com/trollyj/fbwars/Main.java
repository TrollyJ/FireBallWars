package com.trollyj.fbwars;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
    
    static Plugin plugin;
    static final Logger LOG = Logger.getLogger("Minecraft");
    FileConfiguration config;
    public static FileConfiguration arenas = new YamlConfiguration();
    
    
    @Override
    public void onEnable() {
        
        plugin = this;
        LOG.info("Loading config...");
        config = getConfig();
        
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }
        
        File config = new File(getDataFolder(), "config.yml");
        
        if (!this.config.contains("wall.X")) {
            this.config.set("wall.X", 10);
        }
        if (!this.config.contains("wall.Y")) {
            this.config.set("wall.Y", 5);
        }
        
        if (!config.exists()) {
	    getLogger().warning("The config.yml file was not found. Creating new one...");
	    saveConfig();
        }
        
        File arenas = new File(getDataFolder(), "arenas.yml");
	try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }
	if (!arenas.exists()) {
            LOG.info("info");
	    getLogger().warning("The arenas.yml file was not found. We are creating it...");
            arenas.createNewFile();
            plugin.saveResource("arenas.yml", true);
                    
	}
	} catch (Exception e) {
            e.printStackTrace();
	}
	try {
            this.arenas.load(arenas);
	} catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
	}
        this.arenas.set("arena.ahoj", "cusbus");
        Bukkit.getPluginCommand("cfb").setExecutor(new Commands(this));
        Bukkit.getPluginCommand("createwall").setExecutor(new Commands(this));
        Bukkit.getPluginCommand("createfloor").setExecutor(new Commands(this));
        Bukkit.getPluginManager().registerEvents(new Events(this), this);
        
    }
    
    @Override
    public void onDisable() {
        
        LOG.info("Plugin has been disabled!");
        LOG.info("FireBallWars by TrollyJ!");
        
    }
    
    public FileConfiguration getArenas () {
        
        return this.arenas;
        
    }
    
    public void saveArenas () {
        
        File file = new File(getDataFolder(), "arenas.yml");
        
        try {
            arenas.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}