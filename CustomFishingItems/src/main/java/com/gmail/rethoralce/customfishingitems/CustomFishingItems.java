package com.gmail.rethoralce.customfishingitems;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CustomFishingItems extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        // create a list of items that a player can fish from the ground
        Material[] allItems = Material.values();
        List<Material> fishingItems = new ArrayList<>();
        Material[] additionalItems = {
                Material.TURTLE_HELMET,
                Material.DIAMOND,
                Material.NETHERITE_SCRAP,
                Material.EMERALD,
                Material.SPONGE,
                Material.ENDER_PEARL,
                Material.OBSIDIAN,
                Material.CRYING_OBSIDIAN,
                Material.SLIME_BALL,
                Material.TNT,
                Material.GUNPOWDER,
                Material.STRING,
                Material.FEATHER,
                Material.FLINT,
                Material.LEATHER,
                Material.SADDLE,
                Material.PAPER,
                Material.BOOK,
                Material.FISHING_ROD,
                Material.BONE,
                Material.ITEM_FRAME,
                Material.NAME_TAG,
                Material.LEAD,
                Material.TOTEM_OF_UNDYING,
                Material.NAUTILUS_SHELL,
        };
        for (Material mat : allItems) {
            if (
                mat.isEdible() ||
                mat.isRecord() ||
                mat.name().toLowerCase().contains("log") ||
                mat.name().toLowerCase().contains("ingot") ||
                mat.name().toLowerCase().contains("plank") ||
                mat.name().toLowerCase().contains("wood") ||
                mat.name().toLowerCase().contains("leaves") ||
                mat.name().toLowerCase().contains("wool") ||
                mat.name().toLowerCase().contains("snow") ||
                mat.name().toLowerCase().contains("terracotta") ||
                mat.name().toLowerCase().contains("carpet") ||
                mat.name().toLowerCase().contains("glass") ||
                mat.name().toLowerCase().contains("concrete") ||
                mat.name().toLowerCase().contains("coral") ||
                mat.name().toLowerCase().contains("bucket") ||
                mat.name().toLowerCase().contains("dye") ||
                mat.name().toLowerCase().contains("candle")
            ) {
                fishingItems.add(mat);
            }
        }
        fishingItems.addAll(Arrays.asList(additionalItems));

        getLogger().info("Custom Fishing Plugin Enabled!");
        getServer().getPluginManager().registerEvents(new Listeners(this, fishingItems), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
