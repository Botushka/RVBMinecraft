package me.gram.underwaterffa.commands;

import me.gram.underwaterffa.UnderwaterFFA;
import me.gram.underwaterffa.Utils.ChatUtils;
import me.gram.underwaterffa.countdowns.EndGameTimer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StopCommand implements CommandExecutor {
    private UnderwaterFFA main;
    public StopCommand(UnderwaterFFA main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player p = (Player) sender;

        if (!p.hasPermission("game.stop")) {
            p.sendMessage(new ChatUtils(main).permission);
            return true;
        } else if (cmd.getName().equalsIgnoreCase("stop")) {
            new EndGameTimer(main).EndCountdown();
            p.sendMessage(new ChatUtils(main).prefix + "You have stopped the current game!");
            return true;
        }
        return true;
    }
}

