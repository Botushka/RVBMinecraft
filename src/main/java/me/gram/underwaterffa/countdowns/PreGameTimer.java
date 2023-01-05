package me.gram.underwaterffa.countdowns;

import me.gram.underwaterffa.Teams.RedBlueTeam;
import me.gram.underwaterffa.UnderwaterFFA;
import me.gram.underwaterffa.Utils.ChatUtils;
import me.gram.underwaterffa.Utils.PlayerUtils;
import me.gram.underwaterffa.states.GameState;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class PreGameTimer {
    private UnderwaterFFA main;
    public PreGameTimer(UnderwaterFFA main) {
        this.main = main;
    }

    public void startCountdown() {
        new BukkitRunnable() {

            int number = 3;

            @Override
            public void run() {
                if (number > 0) {
                    if (number == 30) {
                        main.setGamestate(GameState.LOBBY);
                        Bukkit.broadcastMessage(new ChatUtils(main).prefix + "Game starting in 30 seconds.");
                    }
                    if (number == 20) {
                        Bukkit.broadcastMessage(new ChatUtils(main).prefix + "Game starting in 20 seconds.");
                    }
                    if (number == 10) {
                        Bukkit.broadcastMessage(new ChatUtils(main).prefix + "Game starting in 10 seconds.");
                    }
                    if (number == 5) {
                        Bukkit.broadcastMessage(new ChatUtils(main).prefix + "Game starting in 5 seconds.");
                    }
                    if (number == 4) {
                        Bukkit.broadcastMessage(new ChatUtils(main).prefix + "Game starting in 4 seconds.");
                    }
                    if (number == 3) {
                        Bukkit.broadcastMessage(new ChatUtils(main).prefix + "Game starting in 3 seconds.");
                    }
                    if (number == 2) {
                        Bukkit.broadcastMessage(new ChatUtils(main).prefix + "Game starting in 2 seconds.");
                    }
                    if (number == 1) {
                        Bukkit.broadcastMessage(new ChatUtils(main).prefix + "Game starting in 1 second.");
                        // DO PREGAME THINGS, SCATTER, KITS, ETC

                    }
                    number--;


                } else {
                    new RedBlueTeam(main).addToTeams();
                    new PlayerUtils(main).giveMinigameItems();
                    Bukkit.broadcastMessage(new ChatUtils(main).prefix + "The game has now started!");
                    cancel();

                }
            }
        }.runTaskTimer(main,20L, 20L);
    }

}

