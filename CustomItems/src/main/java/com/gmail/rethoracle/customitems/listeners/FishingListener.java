package com.gmail.rethoracle.customitems.listeners;

import com.gmail.rethoracle.customitems.runnables.FishingNoiseRunnable;
import org.bukkit.Material;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitTask;

import java.util.*;

public class FishingListener implements Listener {

    private final ArrayList<Material> possibleFishingItems;
    private final HashMap<Player, BukkitTask> fishingTasks;
    private final Random random;

    public FishingListener() {
        possibleFishingItems = makeFishingList();
        fishingTasks = new HashMap<>();
        random = new Random();
    }

    @EventHandler void onInvSlotChange(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();
        if (fishingTasks.containsKey(player)) {
            if (!fishingTasks.get(player).isCancelled()) fishingTasks.get(player).cancel();
        }
    }

    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent event) {
        if (event.getItem().getType() == Material.FISHING_ROD) {
            int chance = random.nextInt(10);
            if (chance >= 1) event.setCancelled(true);
        }
    }

    @EventHandler
    public void onFishingRodToss(PlayerFishEvent event) {
        Player player = event.getPlayer();
        FishHook hook = event.getHook();

        if (event.getState() == PlayerFishEvent.State.FISHING) {
            int randomSec = random.nextInt(20) + 1;
            long randomTick = randomSec * 20;

            BukkitTask task = FishingNoiseRunnable.start(hook, randomTick);
            if (fishingTasks.containsKey(player)) {
                fishingTasks.replace(player, task);
            } else {
                fishingTasks.put(player, task);
            }
        }
        else if (event.getState() ==  PlayerFishEvent.State.IN_GROUND) {
            BukkitTask task = fishingTasks.get(player);
            if (task.isCancelled()) {
                int randomItemIdx = random.nextInt(possibleFishingItems.size());
                Material randomItem = possibleFishingItems.get(randomItemIdx);
                ItemStack item = new ItemStack(randomItem);

                event.getHook().getWorld().dropItem(event.getPlayer().getLocation(), item);

                int maxXp = 6;
                int minXp = 1;
                int xp = (int) ((Math.random() * (maxXp - minXp)) + minXp);
                event.getHook().getWorld().spawn(player.getLocation(), ExperienceOrb.class).setExperience(xp);
            }
            task.cancel();
        }
        else {
            BukkitTask task = fishingTasks.get(player);
            if (!task.isCancelled()) task.cancel();
        }
    }

    private static ArrayList<Material> makeFishingList() {
        Material[] allItems = Material.values();
        ArrayList<Material> fishingItems = new ArrayList<>();
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
        return fishingItems;
    }
}
