package com.gmail.rethoracle.customitems.items;

import com.gmail.rethoracle.customitems.items.armor.AmethystArmor;
import com.gmail.rethoracle.customitems.items.armor.EmeraldArmor;
import com.gmail.rethoracle.customitems.items.armor.GlowStoneArmor;
import com.gmail.rethoracle.customitems.items.armor.SlimeArmor;
import com.gmail.rethoracle.customitems.items.tools.BoneSword;
import com.gmail.rethoracle.customitems.items.tools.EmeraldTool;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    // tools
    public static ItemStack EMERALD_PICKAXE;
    public static ItemStack EMERALD_SHOVEL;
    public static ItemStack EMERALD_AXE;
    public static ItemStack EMERALD_SWORD;
    public static ItemStack EMERALD_HOE;

    // armor
    public static ItemStack EMERALD_HELMET;
    public static ItemStack EMERALD_CHEST_PLATE;
    public static ItemStack EMERALD_LEGGINGS;
    public static ItemStack EMERALD_BOOTS;

    public static ItemStack AMETHYST_HELMET;
    public static ItemStack AMETHYST_CHEST_PLATE;
    public static ItemStack AMETHYST_LEGGINGS;
    public static ItemStack AMETHYST_BOOTS;

    public static ItemStack GLOW_STONE_BOOTS;

    public static ItemStack SLIME_BOOTS;

    public static ItemStack BONE_SWORD;

    // lists for checks
    public static List<ItemStack> allEmeraldTools = new ArrayList<>();
    public static List<ItemStack> allEmeraldArmor = new ArrayList<>();
    public static List<ItemStack> allAmethystArmor = new ArrayList<>();

    public static void init() {
        createItems();
        addAllItems();
    }

    private static void createItems() {
        // initialize all items on plugin enable
        EMERALD_PICKAXE = EmeraldTool.createEmeraldPickaxe();
        EMERALD_SHOVEL = EmeraldTool.createEmeraldShovel();
        EMERALD_AXE = EmeraldTool.createEmeraldAxe();
        EMERALD_SWORD = EmeraldTool.createEmeraldSword();
        EMERALD_HOE = EmeraldTool.createEmeraldHoe();

        EMERALD_HELMET = EmeraldArmor.createEmeraldHelmet();
        EMERALD_CHEST_PLATE = EmeraldArmor.createEmeraldChestPlate();
        EMERALD_LEGGINGS = EmeraldArmor.createEmeraldLeggings();
        EMERALD_BOOTS = EmeraldArmor.createEmeraldBoots();

        AMETHYST_HELMET = AmethystArmor.createAmethystHelmet();
        AMETHYST_CHEST_PLATE = AmethystArmor.createAmethystChestPlate();
        AMETHYST_LEGGINGS = AmethystArmor.createAmethystLeggings();
        AMETHYST_BOOTS = AmethystArmor.createAmethystBoots();

        GLOW_STONE_BOOTS = GlowStoneArmor.createGlowStoneBoots();

        SLIME_BOOTS = SlimeArmor.createSlimeBoots();

        BONE_SWORD = BoneSword.createBoneSword();
    }

    private static void addAllItems() {
        // add all items to the current class
        allEmeraldTools.add(EMERALD_PICKAXE);
        allEmeraldTools.add(EMERALD_SHOVEL);
        allEmeraldTools.add(EMERALD_AXE);
        allEmeraldTools.add(EMERALD_SWORD);
        allEmeraldTools.add(EMERALD_HOE);

        allEmeraldArmor.add(EMERALD_HELMET);
        allEmeraldArmor.add(EMERALD_CHEST_PLATE);
        allEmeraldArmor.add(EMERALD_LEGGINGS);
        allEmeraldArmor.add(EMERALD_BOOTS);

        allAmethystArmor.add(AMETHYST_HELMET);
        allAmethystArmor.add(AMETHYST_CHEST_PLATE);
        allAmethystArmor.add(AMETHYST_LEGGINGS);
        allAmethystArmor.add(AMETHYST_BOOTS);
    }

    public static ItemStack getItemByName(String name) {
        // used for commands
        if (name.equalsIgnoreCase("emerald_pickaxe")) return EMERALD_PICKAXE;
        if (name.equalsIgnoreCase("emerald_shovel")) return EMERALD_SHOVEL;
        if (name.equalsIgnoreCase("emerald_axe")) return EMERALD_AXE;
        if (name.equalsIgnoreCase("emerald_sword")) return EMERALD_SWORD;
        if (name.equalsIgnoreCase("emerald_hoe")) return EMERALD_HOE;
        if (name.equalsIgnoreCase("emerald_helmet")) return EMERALD_HELMET;
        if (name.equalsIgnoreCase("emerald_chest_plate")) return EMERALD_CHEST_PLATE;
        if (name.equalsIgnoreCase("emerald_leggings")) return EMERALD_LEGGINGS;
        if (name.equalsIgnoreCase("emerald_boots")) return EMERALD_BOOTS;
        if (name.equalsIgnoreCase("amethyst_helmet")) return AMETHYST_HELMET;
        if (name.equalsIgnoreCase("amethyst_chest_plate")) return AMETHYST_CHEST_PLATE;
        if (name.equalsIgnoreCase("amethyst_leggings")) return AMETHYST_LEGGINGS;
        if (name.equalsIgnoreCase("amethyst_boots")) return AMETHYST_BOOTS;
        if (name.equalsIgnoreCase("glow_stone_boots")) return GLOW_STONE_BOOTS;
        if (name.equalsIgnoreCase("slime_boots")) return SLIME_BOOTS;
        if (name.equalsIgnoreCase("bone_sword")) return BONE_SWORD;
        return new ItemStack(Material.AIR);
    }

    public static boolean isEmeraldTool(String name) {
        for (ItemStack item : allEmeraldTools) {
            ItemMeta meta = item.getItemMeta();
            assert meta != null;
            String metaName = meta.getDisplayName();
            if (name.equals(metaName)) return true;
        }
        return false;
    }

    public static boolean isEmeraldArmor(String name) {
        for (ItemStack item: allEmeraldArmor) {
            ItemMeta meta = item.getItemMeta();
            assert meta != null;
            String metaName = meta.getDisplayName();
            if (name.equals(metaName)) return true;
        }
        return false;
    }

    public static boolean isAmethystArmor(String name) {
        for (ItemStack item: allAmethystArmor) {
            ItemMeta meta = item.getItemMeta();
            assert meta != null;
            String metaName = meta.getDisplayName();
            if (name.equals(metaName)) return true;
        }
        return false;
    }

    public static boolean isGlowStoneBoots(String name) {
        ItemMeta meta = GLOW_STONE_BOOTS.getItemMeta();
        assert meta != null;
        String metaName = meta.getDisplayName();
        return name.equals(metaName);
    }

    public static boolean isSlimeBoots(String name) {
        ItemMeta meta = SLIME_BOOTS.getItemMeta();
        assert meta != null;
        String metaName = meta.getDisplayName();
        return name.equals(metaName);
    }

    public static boolean isBoneSword(String name) {
        ItemMeta meta = BONE_SWORD.getItemMeta();
        assert meta != null;
        String metaName = meta.getDisplayName();
        return name.equals(metaName);
    }
}
