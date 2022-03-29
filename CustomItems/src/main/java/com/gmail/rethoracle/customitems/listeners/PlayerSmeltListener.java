package com.gmail.rethoracle.customitems.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.FurnaceStartSmeltEvent;

public class PlayerSmeltListener implements Listener {

    @EventHandler
    public void onPlayerSmelt(FurnaceStartSmeltEvent event) {
        int cookTime = event.getTotalCookTime();
        event.setTotalCookTime(cookTime / 2);
    }
}
