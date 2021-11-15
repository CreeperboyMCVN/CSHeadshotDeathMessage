package com.CreeperboyMCVN.csheadshotdeathmsg.listeners;

import com.CreeperboyMCVN.csheadshotdeathmsg.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener {
    
    public DeathEvent() {};
    
    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player killer = e.getEntity().getKiller();
        if (killer == null) return;
        FileConfiguration fc = Main.inst.getConfig();
        if (Main.inst.getCSHitEvent().getLastHeadshot(killer)) {
            String weapon = Main.inst.getCSHitEvent().getWeaponName(killer);
            String deathmsg = fc.getString("deathmsg."+weapon);
            if (deathmsg == null) return;
            e.setDeathMessage(ChatColor.translateAlternateColorCodes('&', deathmsg.replace("<killer>", killer.getName())
                .replace("<victim>", e.getEntity().getName())));
        }
    }

}
