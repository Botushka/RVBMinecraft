package me.gram.underwaterffa.commands;

import me.gram.underwaterffa.UnderwaterFFA;
import me.gram.underwaterffa.Utils.ChatUtils;
import me.gram.underwaterffa.Utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class admintools implements CommandExecutor {
    private UnderwaterFFA main;

    public admintools(UnderwaterFFA main) {
        this.main = main;
    }
    private final String SET_BLUE_SPAWN = new ChatUtils(main).format("&aSet &9Blue &aspawn point &7(Right Click)");
    private final String SET_RED_SPAWN = new ChatUtils(main).format("&aSet &cRed &aspawn point &7(Right Click)");
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    Player p = (Player) sender;
        if (command.getName().equalsIgnoreCase("GameTools")) {
            if (!sender.hasPermission("admin.tools")) {
                p.sendMessage("You don't have permission to use admin tools!");
            } else {
                p.getInventory().addItem(
                        new ItemBuilder(Material.BLUE_WOOL)
                                .setName(SET_BLUE_SPAWN)
                                .setLore("Make sure to look at the direction you want players to look when they spawn")
                                .toItemStack());
                p.getInventory().addItem(
                        new ItemBuilder(Material.RED_WOOL)
                                .setName(SET_RED_SPAWN)
                                .setLore("Make sure to look at the direction you want players to look when they spawn")
                                .toItemStack());

            }

        }
        return true;
    }
}
