package com.gmail.rethoracle.customitems.runnables;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class SlimeBootsRunnable extends BukkitRunnable {

    private static Plugin plugin;
    private static Player player;

    public SlimeBootsRunnable(Plugin plug, Player p) {
        player = p;
        plugin = plug;
    }
    private ArrayList<Block> getBlocks(Block start, int radius){
        ArrayList<Block> blocks = new ArrayList<>();
        Location blockLoc = start.getLocation();
        for(double x = blockLoc.getX() - radius; x <= blockLoc.getX() + radius; x++){
            for(double y = blockLoc.getY() - radius; y <= blockLoc.getY() + radius; y++) {
                for(double z = blockLoc.getZ() - radius; z <= blockLoc.getZ() + radius; z++){
                    Location loc = new Location(start.getWorld(), x, y, z);
                    blocks.add(loc.getBlock());
                }
            }
        }
        return blocks;
    }


    @Override
    public void run() {
        int highestY = player.getWorld().getHighestBlockYAt(player.getLocation());

        Location playerLoc = player.getLocation();

        if (playerLoc.getY() > highestY + 5) {
            if (playerLoc.getY() <= highestY + 12) {
                Location slimeBlockLoc = new Location(player.getWorld(), playerLoc.getX(), highestY, playerLoc.getZ());
                Block targetBlock = player.getWorld().getBlockAt(slimeBlockLoc);
                ArrayList<Block> nearbyBlocks = getBlocks(targetBlock, 1);

                for (Block block : nearbyBlocks) {
                    Material oldBlockMaterial = block.getType();
                    if (oldBlockMaterial != Material.SLIME_BLOCK) {
                        block.setType(Material.SLIME_BLOCK);
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                block.setType(oldBlockMaterial);
                            }
                        }.runTaskLater(plugin, 20L);
                    }
                }
            }
        }
    }
}
