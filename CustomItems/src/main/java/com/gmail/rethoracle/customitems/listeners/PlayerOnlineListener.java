package com.gmail.rethoracle.customitems.listeners;

import com.gmail.rethoracle.customitems.runnables.ArmorCheckerRunnable;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.List;

public class PlayerOnlineListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        restartEmeraldArmorRunnable();
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        restartEmeraldArmorRunnable();
    }

    public void restartEmeraldArmorRunnable() {
        // defaults list size to 10, if more players on the server than that this needs to be changed.
        List<String> onlinePlayers = new ArrayList<>();

        for (Player player : Bukkit.getOnlinePlayers()) {
            onlinePlayers.add(player.getName());
        }

        ArmorCheckerRunnable.restart(onlinePlayers);
    }
}
