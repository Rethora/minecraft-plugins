package com.gmail.rethoracle.customitems.items.armor;

import org.bukkit.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

public class GlowStoneArmor {

    private static ItemStack createGlowStoneArmor(Material fromMaterial, String name) {
        ItemStack tool = new ItemStack(fromMaterial);
        LeatherArmorMeta meta = (LeatherArmorMeta) tool.getItemMeta();
        assert meta != null;
        meta.setColor(Color.ORANGE);
        meta.setDisplayName(ChatColor.GOLD + name);
        List<String> lore = new ArrayList<>();
        lore.add("Lava/Fire Resistance");
        meta.setLore(lore);
        tool.setItemMeta(meta);
        return tool;
    }

    public static ItemStack createGlowStoneBoots() {
        ItemStack item = createGlowStoneArmor(Material.LEATHER_BOOTS, "Glow Stone Boots");

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("glow_stone_boots"), item);
        sr.shape("G G", "G G", "   ");
        sr.setIngredient('G', Material.GLOWSTONE);
        Bukkit.getServer().addRecipe(sr);

        return item;
    }
}
