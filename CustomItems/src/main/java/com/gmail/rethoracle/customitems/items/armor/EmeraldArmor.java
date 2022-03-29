package com.gmail.rethoracle.customitems.items.armor;

import org.bukkit.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

public class EmeraldArmor {

    private static ItemStack createEmeraldArmor(Material fromMaterial, String name) {
        ItemStack tool = new ItemStack(fromMaterial);
        LeatherArmorMeta meta = (LeatherArmorMeta) tool.getItemMeta();
        assert meta != null;
        meta.setColor(Color.GREEN);
        meta.setDisplayName(ChatColor.GREEN + name);
        List<String> lore = new ArrayList<>();
        lore.add("+5 Jump");
        meta.setLore(lore);
        tool.setItemMeta(meta);
        return tool;
    }

    public static ItemStack createEmeraldHelmet() {
        ItemStack item = createEmeraldArmor(Material.LEATHER_HELMET, "Emerald Helmet");

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("emerald_helmet"), item);
        sr.shape("EEE", "E E", "   ");
        sr.setIngredient('E', Material.EMERALD);
        Bukkit.getServer().addRecipe(sr);

        return item;
    }

    public static ItemStack createEmeraldChestPlate() {
        ItemStack item = createEmeraldArmor(Material.LEATHER_CHESTPLATE, "Emerald Chest Plate");

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("emerald_chest_plate"), item);
        sr.shape("E E", "EEE", "EEE");
        sr.setIngredient('E', Material.EMERALD);
        Bukkit.getServer().addRecipe(sr);

        return item;
    }

    public static ItemStack createEmeraldLeggings() {
        ItemStack item = createEmeraldArmor(Material.LEATHER_LEGGINGS, "Emerald Leggings");

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("emerald_leggings"), item);
        sr.shape("EEE", "E E", "E E");
        sr.setIngredient('E', Material.EMERALD);
        Bukkit.getServer().addRecipe(sr);

        return item;
    }

    public static ItemStack createEmeraldBoots() {
        ItemStack item = createEmeraldArmor(Material.LEATHER_BOOTS, "Emerald Boots");

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("emerald_boots"), item);
        sr.shape("E E", "E E", "   ");
        sr.setIngredient('E', Material.EMERALD);
        Bukkit.getServer().addRecipe(sr);

        return item;
    }
}
