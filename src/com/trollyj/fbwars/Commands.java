package com.trollyj.fbwars;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Commands implements CommandExecutor {
    
    private Main main;
    
    public Commands (Main main) {
        this.main = main;
    }
    
    

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        
        Player p = (Player) cs;
        Location loc = p.getLocation();
        Vector v = new Vector(0, 0, 0);
        Location loc2 = loc.add(0, 5, 0);
        Block b = loc2.getBlock();
        
        if (cmnd.getName().equalsIgnoreCase("cfb")) {
            Fireball fb = p.getWorld().spawn(loc, Fireball.class);
            fb.setCustomName("ObsidianDestroyer");
            fb.setYield(10);
            fb.setDirection(v);
            b.setType(Material.OBSIDIAN);
            return true;
            
        }
        if (cmnd.getName().equalsIgnoreCase("createwall")) {
            
            Wall wall = new Wall(11, 5, cs);
            wall.create(p.getLocation());
            return true;
        }
        if (cmnd.getName().equalsIgnoreCase("createfloor")) {
            
            Floor floor = new Floor(11, 5);
            floor.create(p.getLocation());
            return true;
            
        }
        
        return false;
    }
    
}
