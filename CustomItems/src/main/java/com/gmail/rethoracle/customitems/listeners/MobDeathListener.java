package com.gmail.rethoracle.customitems.listeners;

import com.gmail.rethoracle.customitems.items.ItemManager;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MobDeathListener implements Listener {

    private boolean dropItem() {
        return Math.round(Math.random()) == 0;
    }

    @EventHandler
    public void onMobDeath(EntityDeathEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity.getKiller() != null) {
            Player player = event.getEntity().getKiller();
            if (player != null) {
                ItemStack item = player.getInventory().getItemInMainHand();
                ItemMeta meta = item.getItemMeta();
                if (meta != null) {
                    if (ItemManager.isBoneSword(meta.getDisplayName())) {
                        boolean dropHead = dropItem();
                        if (dropHead) {
                            if (entity.getType() == EntityType.PLAYER) {
                                entity.getWorld().dropItem(entity.getLocation(), new ItemStack(Material.PLAYER_HEAD));
                            }
                            if (entity.getType() == EntityType.CREEPER) {
                                entity.getWorld().dropItem(entity.getLocation(), new ItemStack(Material.CREEPER_HEAD));
                            }
                            if (entity.getType() == EntityType.ZOMBIE) {
                                entity.getWorld().dropItem(entity.getLocation(), new ItemStack(Material.ZOMBIE_HEAD));
                            }
                            if (entity.getType() == EntityType.SKELETON) {
                                entity.getWorld().dropItem(entity.getLocation(), new ItemStack(Material.SKELETON_SKULL));
                            }
                            if (entity.getType() == EntityType.WITHER_SKELETON) {
                                entity.getWorld().dropItem(
                                        entity.getLocation(), new ItemStack(Material.WITHER_SKELETON_SKULL)
                                );
                            }
                        }
                    }
                }
            }
        }
    }
}
