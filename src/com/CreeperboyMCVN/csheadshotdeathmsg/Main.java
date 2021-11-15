/* Source code by CreeperboyMCVN, DO NOT RECODE OR RE-UP*/

package com.CreeperboyMCVN.csheadshotdeathmsg;

import com.CreeperboyMCVN.csheadshotdeathmsg.listeners.CSHitEvent;
import com.CreeperboyMCVN.csheadshotdeathmsg.listeners.DeathEvent;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    
    private CSHitEvent hitEvent;
    public static Main inst;

    @Override
    public void onEnable() {
        this.setInst(this);
        saveDefaultConfig();
        this.hitEvent = new CSHitEvent();
        this.getServer().getPluginManager().registerEvents(hitEvent, this);
        this.getServer().getPluginManager().registerEvents(new DeathEvent(), this);
        this.getCommand("cshsdms").setExecutor(new CSDMSCommand());
    }
    
    private void setInst(Main inst) {
        Main.inst = inst;
    }
    
    public CSHitEvent getCSHitEvent() {
        return hitEvent;
    }

}
