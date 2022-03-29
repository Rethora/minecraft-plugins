package com.gmail.rethoracle.customitems.items.tools;

import org.bukkit.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class BoneSword {

    private static ItemStack createBoneTool(Material fromMaterial, String name) {
        ItemStack tool = new ItemStack(fromMaterial);
        ItemMeta meta = tool.getItemMeta();
        assert meta != null;
        meta.setDisplayName(ChatColor.GRAY + name);
        List<String> lore = new ArrayList<>();
        lore.add("Bitch give me head");
        meta.setLore(lore);
        tool.setItemMeta(meta);
        return tool;
    }

    public static ItemStack createBoneSword() {
        ItemStack item = createBoneTool(Material.IRON_SWORD, "Bone Sword");

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("bone_sword"), item);
        sr.shape(" B ", " B ", " S ");
        sr.setIngredient('B', Material.BONE_BLOCK);
        sr.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(sr);

        return item;
    }
}
