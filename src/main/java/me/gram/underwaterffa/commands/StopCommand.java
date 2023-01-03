package me.gram.underwaterffa.commands;

import me.gram.underwaterffa.states.GameManager;
import me.gram.underwaterffa.states.GameState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StopCommand implements CommandExecutor {
    private GameManager gameManager;

    public StopCommand(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        gameManager.setGameState(GameState.ENDGAME);
        return false;
    }
}
