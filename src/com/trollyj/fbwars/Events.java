package com.trollyj.fbwars;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class Events implements Listener {
    
    private static Main main;
    
    public Events (Main main) {
        this.main = main;
    }
    
    @EventHandler
    public void onBlockExplodeEvent (EntityExplodeEvent e) {
         
        
        
    }
    
}