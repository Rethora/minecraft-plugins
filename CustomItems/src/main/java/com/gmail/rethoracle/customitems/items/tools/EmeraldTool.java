package com.gmail.rethoracle.customitems.items.tools;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class EmeraldTool {

    private static ItemStack createEmeraldTool(Material fromMaterial, String name) {
        ItemStack tool = new ItemStack(fromMaterial);
        ItemMeta meta = tool.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.GREEN + name);
        List<String> lore = new ArrayList<>();
        lore.add("Boom!");
        meta.setLore(lore);
        tool.setItemMeta(meta);
        return tool;
    }

    public static ItemStack createEmeraldPickaxe() {
        ItemStack tool = createEmeraldTool(Material.DIAMOND_PICKAXE, "Emerald Pickaxe");

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("emerald_pickaxe"), tool);
        sr.shape("EEE", " S ", " S ");
        sr.setIngredient('E', Material.EMERALD);
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);

        return tool;

        // Furnace Recipe
//        FurnaceRecipe smelt = new FurnaceRecipe(
//                NamespacedKey.minecraft("smelt"),
//                Material.IRON_ORE.,
//                Material.DIAMOND,
//                1.0f,
//                2 * 20
//        );
//        Bukkit.getServer().addRecipe(smelt);
    }

    public static ItemStack createEmeraldShovel() {
        ItemStack tool = createEmeraldTool(Material.DIAMOND_SHOVEL, "Emerald Shovel");

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("emerald_shovel"), tool);
        sr.shape(" E ", " S ", " S ");
        sr.setIngredient('E', Material.EMERALD);
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);

        return tool;
    }

    public static ItemStack createEmeraldAxe() {
        ItemStack tool = createEmeraldTool(Material.DIAMOND_AXE, "Emerald Axe");

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("emerald_axe"), tool);
        sr.shape(" EE", " SE", " S ");
        sr.setIngredient('E', Material.EMERALD);
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);

        return tool;
    }

    public static ItemStack createEmeraldSword() {
        ItemStack tool = createEmeraldTool(Material.DIAMOND_SWORD, "Emerald Sword");

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("emerald_sword"), tool);
        sr.shape(" E ", " E ", " S ");
        sr.setIngredient('E', Material.EMERALD);
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);

        return tool;
    }

    public static ItemStack createEmeraldHoe() {
        ItemStack tool = createEmeraldTool(Material.DIAMOND_HOE, "Emerald Hoe");

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("emerald_hoe"), tool);
        sr.shape(" EE", " S ", " S ");
        sr.setIngredient('E', Material.EMERALD);
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);

        return tool;
    }
}
