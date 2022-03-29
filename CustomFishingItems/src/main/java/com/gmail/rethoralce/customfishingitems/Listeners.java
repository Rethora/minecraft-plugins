package com.gmail.rethoralce.customfishingitems;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.time.LocalDateTime;
import java.util.*;

public class Listeners implements Listener {

    // TODO: task is being overwritten not added when two players are fishing!

    private final Plugin plugin;
    private final List<Material> possibleFishingItems;

    private LocalDateTime biteTime;
    private BukkitRunnable task;
    private HashMap<Player, BukkitRunnable> fishingTasks;
    private final Random random = new Random();

    public Listeners(Plugin p, List<Material> fishingItemsList) {
        plugin = p;
        possibleFishingItems = fishingItemsList;
    }

    @EventHandler
    public void onItemDamage(PlayerItemDamageEvent event) {
        if (event.getItem().getType() == Material.FISHING_ROD) {
            int chance = random.nextInt(10);
            if (chance >= 1) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onFishingRodToss(PlayerFishEvent event) {
        FishHook hook = event.getHook();

        // when player casts line, create a random bite time and animation on timer and store globally
        if (event.getState() == PlayerFishEvent.State.FISHING) {
            int randomSec = random.nextInt(20) + 1;
            int tickDelay = 20 * randomSec;
            LocalDateTime currTime = LocalDateTime.now();
            biteTime = currTime.plusSeconds(randomSec);
            task = new BukkitRunnable() {
                @Override
                public void run() {
                    hook.getWorld().playSound(
                            hook.getLocation(),
                            Sound.ENTITY_FISHING_BOBBER_SPLASH,
                            1.0F,
                            10.0F
                    );
                }
            };
            task.runTaskLater(plugin, tickDelay);
        }
        // if player reels in line from ground with bite
        else if (event.getState() == PlayerFishEvent.State.IN_GROUND && LocalDateTime.now().isAfter(biteTime)) {
            Block block = hook.getLocation().getBlock();

            int randomItemIdx = random.nextInt(possibleFishingItems.size());
            Material randomItem = possibleFishingItems.get(randomItemIdx);
            ItemStack item = new ItemStack(randomItem);

            Location pLoc = event.getPlayer().getLocation();
            Location bLoc = block.getLocation();
            double motX = pLoc.getX() - bLoc.getX();
            double motY = pLoc.getY() - bLoc.getY();
            double motZ = pLoc.getZ() - bLoc.getZ();

            event.getHook().getWorld().dropItem(event.getPlayer().getLocation(), item);

//            event.getHook().getWorld().dropItem(
//                    event.getPlayer().getLocation(), item
//            ).setVelocity(new Vector(motX * 0.02D, motY * 0.02D, motZ * 0.02D));

//            event.getHook().getWorld().dropItem(event.getHook().getLocation(), item).setVelocity(
//                    new Vector(motX * .5D, motY * .5D, motZ * .5D)
//            );

            int maxXp = 6;
            int minXp = 1;
            int xp = (int) ((Math.random() * (maxXp - minXp)) + minXp);
            event.getHook().getWorld().spawn(pLoc, ExperienceOrb.class).setExperience(xp);
        }
        // if player reels with all the other cases (including in ground with no bite)
        else {
            task.cancel();
        }
    }
}
