package com.aaomidi.reloadpermissions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Level;


public class ReloadPermissions extends JavaPlugin implements CommandExecutor {
    @Override
    public final void onLoad() {

    }

    @Override
    public final void onEnable() {
        this.getCommand("reloadperms").setExecutor(this);
    }

    @Override
    public final void onDisable() {
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("reloadperms")) {
            if (commandSender.isOp()) {
                String reloaded = this.reloadPerms();
                reloaded = this.colorize(reloaded);
                commandSender.sendMessage(reloaded);
                return true;
            }
        }
        return false;
    }

    private String reloadPerms() {
        try {
            Field f = Bukkit.getServer().getPluginManager().getClass().getDeclaredField("permissions");
            f.setAccessible(true);
            f.set(this.getServer().getPluginManager(), new HashMap<String, Permission>());
            Method meth = Bukkit.getServer().getClass().getDeclaredMethod("loadCustomPermissions");
            meth.setAccessible(true);
            meth.invoke(Bukkit.getServer(), null);
            for (Plugin plugin : this.getServer().getPluginManager().getPlugins()) {
                for (Permission permission : plugin.getDescription().getPermissions()) {
                    try {
                        this.getServer().getPluginManager().addPermission(permission);
                    } catch (IllegalArgumentException ex) {
                        this.getLogger().log(Level.SEVERE, ex.getMessage());
                    }
                }
            }
            return "&bReloaded Perms";
        } catch (Exception ex) {
            this.getLogger().log(Level.SEVERE, ex.getMessage());
            return "&cUnable to reload perms";
        }
    }

    private String colorize(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}