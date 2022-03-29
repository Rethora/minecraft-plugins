package com.gmail.rethoracle.custommobs;

import org.bukkit.plugin.java.JavaPlugin;

public final class CustomMobs extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Custom Mobs Plugin Enabled!");
        getServer().getPluginManager().registerEvents(new Listeners(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
