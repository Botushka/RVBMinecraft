package me.gram.underwaterffa.countdowns;

import me.gram.underwaterffa.UnderwaterFFA;
import me.gram.underwaterffa.Utils.ChatUtils;
import me.gram.underwaterffa.Utils.PlayerUtils;
import me.gram.underwaterffa.states.GameState;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
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
                        new PlayerUtils(main).removeItems();
                        Bukkit.broadcastMessage(new ChatUtils(main).prefix + "(Team) won!");
                    }

                    number--;
                } else {
                    main.setGamestate(GameState.LOBBY);
                    cancel();
                }
            }
        }.runTaskTimer(main,20L, 20L);
    }
}
