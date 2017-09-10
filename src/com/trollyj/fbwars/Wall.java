package com.trollyj.fbwars;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;

public class Wall {
    
    private static final Material WALLMAT = Material.IRON_BLOCK;
    private static int wallLength = 11;
    private static int wallMiddle;
    private static int nextToMid;
    private static int wallHight = 5;
    
    public Wall (int wallLength, int wallHight, CommandSender sender) {
        
        if (wallLength % 2 == 1) {
            
            this.wallLength = wallLength;
            this.wallHight = wallHight;
            this.wallMiddle = (int) (wallLength / 2 + 0.5);
            this.nextToMid = (int) (wallLength / 2 - 0.5);
            
        } else {
            sender.sendMessage(ChatColor.RED + "Wall lenght must be odd number!");
            Bukkit.getLogger().warning("Wall lenght must be odd number!");
            return;
        }
        
        this.wallLength = wallLength;
        this.wallHight = wallHight;
        
    }
    
    public void create (Location midOfWall) {
        
        double y = midOfWall.getY();
        double x = midOfWall.getX();
        Location start = midOfWall.add(-(this.nextToMid), 0, 0);
        Block block = start.getBlock();
        
        int X = 1;
        int Y = 1;
        
        while (Y <= this.wallHight) {
            
            while (X <= this.wallLength) {
            
                block.setType(this.WALLMAT);
            
                X++;
                start.add(1, 0, 0);
                block = start.getBlock();
                try {
                    this.wait(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            
            }
            
            Y++;
            X = 1;
            start.add(-(this.wallLength), 1, 0);
            block = start.getBlock();
            
        }
        
        
    }
    
}