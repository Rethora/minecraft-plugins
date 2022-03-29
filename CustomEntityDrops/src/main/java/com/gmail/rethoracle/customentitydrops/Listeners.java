package com.gmail.rethoracle.customentitydrops;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;


public class Listeners implements Listener {

    @EventHandler
    public void onEntityDrop(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        if (entity.getType() == EntityType.BAT) {
            ItemStack book = new ItemStack(Material.ENCHANTED_BOOK);
            EnchantmentStorageMeta bookMeta = (EnchantmentStorageMeta) book.getItemMeta();
            assert bookMeta != null;
            List<Enchantment> allEnchantments = Arrays.asList(Enchantment.values());
            Random random = new Random();
            int randomIdx = random.nextInt(allEnchantments.size());
            Enchantment randomEnchantment = allEnchantments.get(randomIdx);
            bookMeta.addStoredEnchant(randomEnchantment, randomEnchantment.getMaxLevel(), true);
            book.setItemMeta(bookMeta);
            event.getDrops().clear();
            event.getDrops().add(book);
        }
    }
}
