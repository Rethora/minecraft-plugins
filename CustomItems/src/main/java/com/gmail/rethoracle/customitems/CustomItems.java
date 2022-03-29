package com.gmail.rethoracle.customitems;

import com.gmail.rethoracle.customitems.commands.GiveItemCommand;
import com.gmail.rethoracle.customitems.commands.UpdatesCommand;
import com.gmail.rethoracle.customitems.listeners.*;
import com.gmail.rethoracle.customitems.items.ItemManager;
import com.gmail.rethoracle.customitems.runnables.ArmorCheckerRunnable;
import com.gmail.rethoracle.customitems.runnables.FishingNoiseRunnable;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class CustomItems extends JavaPlugin {

    @Override
    public void onEnable() {
        // runnable
        List<String> onlinePlayers = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers()) {
            onlinePlayers.add(player.getName());
        }
        ArmorCheckerRunnable.init(this);
        ArmorCheckerRunnable.start(onlinePlayers);

        FishingNoiseRunnable.init(this);

        // items
        ItemManager.init();

        // listeners
        getServer().getPluginManager().registerEvents(new EmeraldItemListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerOnlineListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerSmeltListener(), this);
        getServer().getPluginManager().registerEvents(new MobDeathListener(), this);
        getServer().getPluginManager().registerEvents(new FishingListener(), this);

        // commands
        Objects.requireNonNull(getCommand("givecustomitem")).setExecutor(new GiveItemCommand());
        Objects.requireNonNull(getCommand("updates")).setExecutor(new UpdatesCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
