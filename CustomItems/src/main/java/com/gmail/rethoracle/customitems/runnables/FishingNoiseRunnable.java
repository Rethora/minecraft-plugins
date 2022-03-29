package com.gmail.rethoracle.customitems.runnables;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.FishHook;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class FishingNoiseRunnable{

    private static Plugin plugin;

    public static void init(Plugin plug) {
        plugin = plug;
    }

    public static BukkitTask start(FishHook hook, long delay) {

        return new BukkitRunnable() {
            @Override
            public void run() {
                hook.getWorld().playSound(
                        hook.getLocation(),
                        Sound.ENTITY_FISHING_BOBBER_SPLASH,
                        1.0F,
                        10.0F
                );

                Block prevBlock = hook.getWorld().getBlockAt(
                        hook.getLocation().getBlockX(),
                        hook.getLocation().getBlockY() - 1,
                        hook.getLocation().getBlockZ()
                );
                Material prevBlockMaterial = prevBlock.getType();
                prevBlock.setType(Material.AIR);
                new BukkitRunnable() {

                    @Override
                    public void run() {
                        prevBlock.setType(prevBlockMaterial);
                    }
                }.runTaskLater(plugin, 1);

                cancel();

            }
        }.runTaskLater(plugin, delay);
    }
}
