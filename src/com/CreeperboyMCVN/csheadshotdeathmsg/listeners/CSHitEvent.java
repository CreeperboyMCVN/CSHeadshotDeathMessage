package com.CreeperboyMCVN.csheadshotdeathmsg.listeners;

import com.shampaggon.crackshot.events.WeaponDamageEntityEvent;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class CSHitEvent implements Listener {
    
    public CSHitEvent() {};
    
    public Map<Player, Boolean> lastHeadshotDamage = new HashMap<>();
    public Map<Player, String> weaponName = new HashMap<>();
    
    @EventHandler
    public void onHit(WeaponDamageEntityEvent e) {
        if (e.isHeadshot()) {
            lastHeadshotDamage.put(e.getPlayer(), Boolean.TRUE);
        } else {
            lastHeadshotDamage.put(e.getPlayer(), Boolean.FALSE);
        }
        weaponName.put(e.getPlayer(), e.getWeaponTitle());
    }
    
    public boolean getLastHeadshot(Player p) {
        return lastHeadshotDamage.get(p);
    }
    
    public String getWeaponName(Player p) {
        return weaponName.get(p);
    }
    
}
