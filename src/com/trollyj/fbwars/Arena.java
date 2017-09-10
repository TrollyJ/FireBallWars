package com.trollyj.fbwars;

import org.bukkit.Location;

public class Arena {
    
    private static String name;
    private static int distance = 10;
    private static int wallLenght = 11;
    private static int floorWidth = 5;
    
    public Arena (String name, int distance, int wallLength, int floorWidth) {
        
        this.name = name;
        this.distance = distance;
        this.wallLenght = wallLength;
        this.floorWidth = floorWidth;
        
    }
    
    public Arena (String name, int wallLength, int floorWidth) {
        
        this.name = name;
        this.wallLenght = wallLength;
        this.floorWidth = floorWidth;
        
    }
    
    public void create (Location middleOfArena) {
        
        
        
    }
    
}