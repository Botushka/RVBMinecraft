package me.gram.underwaterffa.countdowns;

import me.gram.underwaterffa.UnderwaterFFA;
import me.gram.underwaterffa.Utils.ChatUtils;
import me.gram.underwaterffa.states.GameState;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class EndGameTimer {

    private UnderwaterFFA main;

    public EndGameTimer(UnderwaterFFA main) {
        this.main = main;
    }

    public void EndCountdown() {
        new BukkitRunnable() {

            int number = 15;

            @Override
            public void run() {
                if (number > 0) {
                    if (number == 15) {
                        main.setGamestate(GameState.ENDGAME);
                        Bukkit.broadcastMessage(new ChatUtils(main).prefix + "(Team) won!");

                        number--;
                    } else {
                        Bukkit.broadcastMessage(new ChatUtils(main).prefix + "Returning to lobby!");
                        main.setGamestate(GameState.LOBBY);
                        cancel();
                    }
                }
            }
        }.runTaskTimer(main, 20L, 20L);
    }
}

