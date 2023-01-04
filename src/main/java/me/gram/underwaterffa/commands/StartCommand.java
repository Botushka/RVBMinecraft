package me.gram.underwaterffa.commands;

import me.gram.underwaterffa.UnderwaterFFA;
import me.gram.underwaterffa.Utils.ChatUtils;
import me.gram.underwaterffa.countdowns.PreGameTimer;
import me.gram.underwaterffa.states.GameManager;
import me.gram.underwaterffa.states.GameState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartCommand implements CommandExecutor {

    private UnderwaterFFA main;
    public StartCommand(UnderwaterFFA main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        Player p = (Player) sender;

        if (!p.hasPermission("game.start")) {
            p.sendMessage(new ChatUtils(main).permission);
            return true;
        } else if (cmd.getName().equalsIgnoreCase("start")) {
            new PreGameTimer(main).startCountdown();
            p.sendMessage(new ChatUtils(main).prefix + "You have started the game.");
            return true;
        }
        return true;
    }
}
