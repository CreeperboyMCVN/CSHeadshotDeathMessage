package com.CreeperboyMCVN.csheadshotdeathmsg;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CSDMSCommand implements CommandExecutor {
    public CSDMSCommand() {}
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Main.inst.reloadConfig();
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&cCS-HDMS&7] Configuration Reloaded!"));
        return true;
    }
}
