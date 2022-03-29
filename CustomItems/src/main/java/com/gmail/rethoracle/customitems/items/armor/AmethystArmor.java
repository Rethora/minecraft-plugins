package com.gmail.rethoracle.customitems.items.armor;

import org.bukkit.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

public class AmethystArmor {

    private static ItemStack createAmethystArmor(Material fromMaterial, String name) {
        ItemStack tool = new ItemStack(fromMaterial);
        LeatherArmorMeta meta = (LeatherArmorMeta) tool.getItemMeta();
        assert meta != null;
        meta.setColor(Color.PURPLE);
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + name);
        List<String> lore = new ArrayList<>();
        lore.add("+2 Speed");
        meta.setLore(lore);
        tool.setItemMeta(meta);
        return tool;
    }

    public static ItemStack createAmethystHelmet() {
        ItemStack item = createAmethystArmor(Material.LEATHER_HELMET, "Amethyst Helmet");

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("amethyst_helmet"), item);
        sr.shape("AAA", "A A", "   ");
        sr.setIngredient('A', Material.AMETHYST_SHARD);
        Bukkit.getServer().addRecipe(sr);

        return item;
    }

    public static ItemStack createAmethystChestPlate() {
        ItemStack item = createAmethystArmor(Material.LEATHER_CHESTPLATE, "Amethyst Chest Plate");

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("amethyst_chest_plate"), item);
        sr.shape("A A", "AAA", "AAA");
        sr.setIngredient('A', Material.AMETHYST_SHARD);
        Bukkit.getServer().addRecipe(sr);

        return item;
    }

    public static ItemStack createAmethystLeggings() {
        ItemStack item = createAmethystArmor(Material.LEATHER_LEGGINGS, "Amethyst Leggings");

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("amethyst_leggings"), item);
        sr.shape("AAA", "A A", "A A");
        sr.setIngredient('A', Material.AMETHYST_SHARD);
        Bukkit.getServer().addRecipe(sr);

        return item;
    }

    public static ItemStack createAmethystBoots() {
        ItemStack item = createAmethystArmor(Material.LEATHER_BOOTS, "Amethyst Boots");

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("amethyst_boots"), item);
        sr.shape("A A", "A A", "   ");
        sr.setIngredient('A', Material.AMETHYST_SHARD);
        Bukkit.getServer().addRecipe(sr);

        return item;
    }
}
