package com.gmail.rethoracle.customitems.listeners;

import com.gmail.rethoracle.customitems.items.ItemManager;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class EmeraldItemListener implements Listener {

    private ArrayList<Block> getBlocks(Block start, int radius){
        ArrayList<Block> blocks = new ArrayList<>();
        Location blockLoc = start.getLocation();
        for(double x = blockLoc.getX() - radius; x <= blockLoc.getX() + radius; x++){
            for(double y = blockLoc.getY() - radius; y <= blockLoc.getY() + radius + 20; y++){
                for(double z = blockLoc.getZ() - radius; z <= blockLoc.getZ() + radius; z++){
                    Location loc = new Location(start.getWorld(), x, y, z);
                    blocks.add(loc.getBlock());
                }
            }
        }
        return blocks;
    }

    @EventHandler
    public void onEmeraldTool(BlockBreakEvent event) {
        ItemStack tool = event.getPlayer().getInventory().getItemInMainHand();
        ItemMeta toolMeta = tool.getItemMeta();

        if (toolMeta != null) {
            if (ItemManager.isEmeraldTool(toolMeta.getDisplayName())) {
                Damageable damageable = (Damageable) toolMeta;
                damageable.setDamage(damageable.getDamage() + 1);
                tool.setItemMeta(damageable);

                ItemMeta emeraldAxeMeta = ItemManager.EMERALD_AXE.getItemMeta();

                // for emerald axe
                if (emeraldAxeMeta != null) {
                    if (toolMeta.getDisplayName().equals(emeraldAxeMeta.getDisplayName())) {
                        if (event.getBlock().getType().isFlammable()) {
                            event.getBlock().getWorld().createExplosion(
                                event.getBlock().getLocation(),
                                0,
                                false,
                                false,
                                event.getPlayer()
                            );
                            ArrayList<Block> nearbyBlocks = getBlocks(event.getBlock(), 8);
                            for (Block block : nearbyBlocks) {
                                if (block.getType().isFlammable()) block.breakNaturally();
                            }
                        }
                    }
                    // for every other emerald tool
                    else {
                        event.getBlock().getWorld().createExplosion(
                                event.getBlock().getLocation(),
                                4,
                                false,
                                true,
                                event.getPlayer()
                        );
                    }
                }
            }
        }
    }

    @EventHandler
    public void onEmeraldSword(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof LivingEntity) {
            LivingEntity entity = (LivingEntity) event.getEntity();
            if (event.getDamager() instanceof Player) {
                Player player = ((Player) event.getDamager()).getPlayer();
                assert player != null;
                if (event.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
                    ItemMeta itemMeta = player.getInventory().getItemInMainHand().getItemMeta();
                    if (itemMeta != null) {
                        ItemMeta emeraldSwordMeta = ItemManager.EMERALD_SWORD.getItemMeta();
                        assert emeraldSwordMeta != null;
                        if (itemMeta.getDisplayName().equals(emeraldSwordMeta.getDisplayName())) {
                            entity.getWorld().createExplosion(
                                    entity.getLocation(),
                                    4,
                                    false,
                                    false,
                                    player
                            );
                        }
                    }
                }
            }
        }
    }
}
