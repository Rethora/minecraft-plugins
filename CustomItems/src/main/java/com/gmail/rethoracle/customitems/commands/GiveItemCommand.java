package com.gmail.rethoracle.customitems.commands;

import com.gmail.rethoracle.customitems.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveItemCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {

        if (command.getName().equalsIgnoreCase("givecustomitem")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "Only players can use that command.");
                return false;
            }
            Player target = Bukkit.getPlayer(args[0]);
            assert target != null;
            if (!target.isOp()) {
                sender.sendMessage(ChatColor.RED + "You have to be an operator to this command.");
                return false;
            }
            if (Bukkit.getPlayer(args[0]) == null) {
                sender.sendMessage(ChatColor.RED + "Invalid Player.");
                return false;
            }
            if (args[1] == null) {
                sender.sendMessage(ChatColor.RED + "Missing item.");
                return false;
            }
            ItemStack item = ItemManager.getItemByName(args[1]);
            if (item.getType() == Material.AIR) {
                sender.sendMessage(ChatColor.RED + "Invalid Item.");
                return false;
            }
            target.getInventory().addItem(item);
        }
        return true;
    }
}
