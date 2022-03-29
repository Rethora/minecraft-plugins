package com.gmail.rethoracle.customitems.runnables;

import com.gmail.rethoracle.customitems.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ArmorCheckerRunnable {

    private static Plugin plugin;
    private static BukkitTask task;

    private static HashMap<Player, BukkitTask> slimeBootsData;

    public static void init(Plugin p) {
        plugin = p;
        slimeBootsData = new HashMap<>();
    }

    public static void start(List<String> playerNames) {
        long delay = 20 * 5L;

        for (String playerName : playerNames) {
            Player player = Bukkit.getPlayer(playerName);
            slimeBootsData.put(player, null);
        }

        task = new BukkitRunnable() {
            @Override
            public void run() {
                for (String playerName : playerNames) {
                    int emeraldArmorCount = 0;
                    int amethystArmorCount = 0;
                    int glowStoneArmorCount = 0;
                    int slimeArmorCount = 0;

                    Player player = Bukkit.getPlayer(playerName);

                    if (player != null) {
                        ItemStack[] armor = Objects.requireNonNull(player.getEquipment()).getArmorContents();
                        for (ItemStack item : armor) {
                            if (item != null) {
                                ItemMeta meta = item.getItemMeta();
                                if (meta != null) {
                                    String name = meta.getDisplayName();

                                    if (ItemManager.isEmeraldArmor(name)) emeraldArmorCount++;
                                    if (ItemManager.isAmethystArmor(name)) amethystArmorCount++;
                                    if (ItemManager.isGlowStoneBoots(name)) glowStoneArmorCount++;
                                    if (ItemManager.isSlimeBoots(name)) slimeArmorCount++;
                                }
                            }
                        }

                        if (emeraldArmorCount > 0) {
                            PotionEffect jumpBoost = new PotionEffect(
                                    PotionEffectType.JUMP,
                                    (int) delay,
                                    (emeraldArmorCount * 4) - 1,
                                    false,
                                    false
                            );
                            player.addPotionEffect(jumpBoost);
                        }

                        if (amethystArmorCount > 0) {
                            PotionEffect speedBoost = new PotionEffect(
                                    PotionEffectType.SPEED,
                                    (int) delay,
                                    amethystArmorCount - 1,
                                    false,
                                    false
                            );
                            player.addPotionEffect(speedBoost);
                        }

                        if (glowStoneArmorCount > 0) {
                            PotionEffect fireResistance = new PotionEffect(
                                    PotionEffectType.FIRE_RESISTANCE,
                                    (int) delay,
                                    amethystArmorCount - 1,
                                    false,
                                    false
                            );
                            player.addPotionEffect(fireResistance);
                        }

                        if (slimeArmorCount > 0) {
                            if (slimeBootsData.get(player) == null ||slimeBootsData.get(player).isCancelled()) {
                                SlimeBootsRunnable runnable = new SlimeBootsRunnable(plugin, player);
                                BukkitTask runnableTask = runnable.runTaskTimer(plugin,
                                        0L,
                                        1L
                                );
                                slimeBootsData.replace(player, runnableTask);
                            }
                        }
                        else {
                            if (!slimeBootsData.get(player).isCancelled()) {
                                slimeBootsData.get(player).cancel();
                            }
                        }
                    }
                }
            }
        }.runTaskTimer(plugin, 0L, delay);
    }

    public static void restart(List<String> playerNames) {
        task.cancel();
        start(playerNames);
    }
}
