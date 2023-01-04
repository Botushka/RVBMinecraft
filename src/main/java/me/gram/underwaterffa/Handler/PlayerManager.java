package me.gram.underwaterffa.Handler;

import me.gram.underwaterffa.UnderwaterFFA;
import me.gram.underwaterffa.Utils.ChatUtils;
import me.gram.underwaterffa.commands.Vanish;
import me.gram.underwaterffa.states.GameState;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.GameMode;

public class PlayerManager {
    private UnderwaterFFA main;
    public PlayerManager(UnderwaterFFA main) {
        this.main = main;
    }

    public void handle(Player player) {
        if (main.getGamestate() == GameState.LOBBY) {
            main.alive.remove(player);
            main.spectating.remove(player);
            main.alive.add(player);
            player.setExp(0);
            player.setTotalExperience(0);
            player.setHealth(20);
            player.setFoodLevel(20);
            player.setGameMode(GameMode.SURVIVAL);
            player.setAllowFlight(false);
            player.sendMessage(new ChatUtils(main).prefix + "Welcome to the MiniGame!");
            Bukkit.broadcastMessage(new ChatUtils(main).prefix + player.getDisplayName() + " has joined the minigame.");
        } else if (main.getGamestate() == GameState.INGAME || main.getGamestate() == GameState.ENDGAME) {
            main.alive.remove(player);
            main.spectating.remove(player);
            main.spectating.add(player);
            new Vanish(main).toggleVanish(player);
            Bukkit.broadcastMessage(new ChatUtils(main).prefix + player.getDisplayName() + " has joined as a spectator.");
        }
    }
}
