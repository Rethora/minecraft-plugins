package com.gmail.rethoracle.scorekeeper;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileOutputStream;

public final class ScoreKeeper extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        File playerStorage = new File("players-storage.json");
        getServer().getPluginManager().registerEvents(new Listeners(playerStorage), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
