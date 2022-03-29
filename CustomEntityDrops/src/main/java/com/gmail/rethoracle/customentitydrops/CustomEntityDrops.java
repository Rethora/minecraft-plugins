package com.gmail.rethoracle.customentitydrops;

import org.bukkit.plugin.java.JavaPlugin;

public final class CustomEntityDrops extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("CustomEntityDrops Plugin Enabled!");
        getServer().getPluginManager().registerEvents(new Listeners(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
