package com.gmail.rethoracle.customitems.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class UpdatesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {

        if (command.getName().equalsIgnoreCase("updates")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "Only players can use that command.");
                return false;
            }

            HashMap<String, String> updateInfo = new HashMap<>();
            updateInfo.put(
                    "fishing",
                    "Players can now fish without water. Just cast your line on a block and wait for a bite. Loot" +
                            " is completely random. \"Lure\" and \"Luck of the Sea\" enchantments have no effect on loot. " +
                            "Fishing in water is the same as before. Loot items from ground are different from items you can " +
                            "catch in water. Fishing rods now have more durability."
            );
            updateInfo.put(
                    "bats",
                    "Bats now drop enchanted books on their death. Enchantments are completely random."
            );
            updateInfo.put(
                    "emerald tools",
                    "Emerald tools are now craft-able. Crafting recipe shape is the same as any other minecraft tool." +
                            " With emerald tools, when a block is broken surrounding blocks explode. No damage is dealt to " +
                            "player using tool, but damage is dealt to other players/entities not wielding the tool if they " +
                            "are in explosion radius. Emerald sword creates explosion on impact to living creatures as well" +
                            " as on block break. It is important not to rename these items as they will cause the item to " +
                            "not have their effect anymore. Emerald tools are built with the base of diamond tools so they " +
                            "will appear as one. They are distinguishable only by their name. You can apply any enchantment " +
                            " on these tools as long as they're non-conflicting."
            );
            updateInfo.put(
                    "emerald armor",
                    "Emerald armor is now craft-able. Crafting recipe shape is the same as any other piece of " +
                            "minecraft armor. " +
                            "For every piece of emerald armor you are wearing you will gain 3 jump boost. It is important not" +
                            " to rename these pieces of armor as they will cause the items to lose their effect. You may " +
                            "apply any enchantments to these items as long as they are non-conflicting. These armor items " +
                            "are built with the base of leather armor so you may redye them if you desire."
            );
            updateInfo.put(
                    "amethyst armor",
                    "Amethyst armor is now craft-able. Crafting recipe shape is the same as any other piece of armor " +
                            "in minecraft. For every piece of amethyst armor you are wearing, you will gain 1 speed boost. " +
                            "Use \"Amethyst Shards\" to craft these pieces of armor. It is important to not rename these " +
                            "items as they will lose their effect. You may apply any enchantment to these as long as they " +
                            "are non-conflicting. These pieces of armor are built with the base of leather armor so you can " +
                            "dye them if you desire."
            );
            updateInfo.put(
                    "furnaces",
                    "All types of furnaces now cook twice as fast as their normal speed."
            );
            updateInfo.put(
                    "glow stone boots",
                    "Glow stone boots allow you to walk in lava and on fire without being harmed. Crafting recipe " +
                            "shape is the same as regular boots. Use glow stone blocks. Do not rename these as they " +
                            "will lose their effect. You can redye them if you would like."
            );
            updateInfo.put(
                    "slime boots",
                    "Slime boots place slime under your feet when you are going to take fall damage. Crafting recipe " +
                            "shape is the same as regular boots. Use slime balls. Do not rename these, they will lose" +
                            " their effect. Careful as these boots will not place slime under your feet if you have " +
                            "blocks over your head. Meaning they will not work in places like caves. After the slime " +
                            "is placed, the blocks will return to normal in a second."
            );
            updateInfo.put(
                    "bone sword",
                    "A bone sword has a 50% chance of decapitating and dropping the head of the creature. Only " +
                            "applies to creatures that have heads in the game (ex: creeper, zombie, wither skeletons," +
                            " skeletons, and even players). Do not rename the sword, it will lose its effect. " +
                            "Crafting recipe shape is the same as a regular sword. Use bone blocks."
            );
            if (args.length == 0) {
                StringBuilder message = new StringBuilder();
                message.append(ChatColor.YELLOW + "----------Plugin Updates----------\n");
                message.append(ChatColor.GRAY + "Use /updates <update> to see info about a specific update.\n");
                message.append(ChatColor.GRAY + "EX: `/updates fishing` OR `/updates slime boots`\n");
                for (String updateName : updateInfo.keySet()) {
                    message.append("\n").append(ChatColor.GOLD).append(updateName);
                }
                sender.sendMessage(message.toString());
            }
            else {
                StringBuilder update = new StringBuilder();
                for (String arg : args) {
                    update.append(arg + " ");
                }

                if (!updateInfo.containsKey(update.toString().toLowerCase().trim())) {
                    sender.sendMessage(ChatColor.RED + "Invalid update name. Try again...");
                    return false;
                }
                String info = ChatColor.AQUA + "Plugin Update: " +
                        ChatColor.GOLD + update.toString().toLowerCase().trim() + "\n" +
                        ChatColor.WHITE + updateInfo.get(update.toString().toLowerCase().trim());

                sender.sendMessage(info);
            }
        }
        return true;
    }
}
