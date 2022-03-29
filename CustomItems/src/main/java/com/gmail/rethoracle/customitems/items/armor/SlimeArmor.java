package com.gmail.rethoracle.customitems.items.armor;

import org.bukkit.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

public class SlimeArmor {

    private static ItemStack createSlimeArmor(Material fromMaterial, String name) {
        ItemStack tool = new ItemStack(fromMaterial);
        LeatherArmorMeta meta = (LeatherArmorMeta) tool.getItemMeta();
        assert meta != null;
        meta.setColor(Color.LIME);
        meta.setDisplayName(ChatColor.GREEN + name);
        List<String> lore = new ArrayList<>();
        lore.add("Fall Damage? lol");
        meta.setLore(lore);
        tool.setItemMeta(meta);
        return tool;
    }

    public static ItemStack createSlimeBoots() {
        ItemStack item = createSlimeArmor(Material.LEATHER_BOOTS, "Slime Boots");

        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("slime_boots"), item);
        sr.shape("S S", "S S", "   ");
        sr.setIngredient('S', Material.SLIME_BALL);
        Bukkit.getServer().addRecipe(sr);

        return item;
    }
}
