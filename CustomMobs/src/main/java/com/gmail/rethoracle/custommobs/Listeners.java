package com.gmail.rethoracle.custommobs;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Listeners implements Listener {

    @EventHandler
    public void onCreeperExplosion(EntityExplodeEvent event) {
        if (event.getEntityType() == EntityType.CREEPER) {
            Creeper creeper = (Creeper) event.getEntity();
            event.setCancelled(true);
            List<Block> blockList = event.blockList();
            int yield = Math.round(blockList.size() * 0.33f);

            for (int i = 0; i < blockList.size(); i++) {
                Block block = blockList.get(i);
                if (i != 0 && i <= yield) {
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(block.getType()));
                }
                block.setType(Material.AIR);
            }

            creeper.getWorld().playSound(
                    creeper.getLocation(),
                    Sound.ENTITY_VILLAGER_AMBIENT,
                    1.0F,
                    1.0F
            );
        }
    }
}
