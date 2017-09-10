package com.trollyj.fbwars;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class Floor {
    
    private static final Material FLOORMAT = Material.GRASS;
    private static int length = 11;
    private static int width = 5;
    private static int nextToMid = 5;
    
    public Floor (int length, int width) {
        
        this.length = length;
        this.width = width;
        
    }
    
    public void create (Location midOfFloor) {
        
        Location start = midOfFloor.add(-(this.nextToMid), 0, 0);
        Block block = start.getBlock();
        
        int X = 1;
        int Z = 1;
        
        while (Z <= this.width) {
            
            while (X <= this.length) {
            
                block.setType(this.FLOORMAT);
            
                X++;
                start.add(1, 0, 0);
                block = start.getBlock();
            
            }
            
            Z++;
            X = 1;
            start.add(-(this.length), 0, 1);
            block = start.getBlock();
            
        }
        
    }
    
}