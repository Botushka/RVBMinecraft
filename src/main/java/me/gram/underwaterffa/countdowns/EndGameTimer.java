package me.gram.underwaterffa.countdowns;

import me.gram.underwaterffa.Teams.RedBlueTeam;
import me.gram.underwaterffa.UnderwaterFFA;
import me.gram.underwaterffa.Utils.ChatUtils;
import me.gram.underwaterffa.Utils.PlayerUtils;
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

            int number = 10;

            @Override
            public void run() {
                if (number > 0) {
                    if (number == 10) {
                        main.setGamestate(GameState.ENDGAME);
                        new PlayerUtils(main).removeItems();
                        Bukkit.broadcastMessage(new ChatUtils(main).prefix + "(Team) won!"); //TODO: add winner team
                        new RedBlueTeam(main).clearTeams();
                    }

                    number--;
                } else {
                    main.setGamestate(GameState.LOBBY);
                    Bukkit.broadcastMessage(new ChatUtils(main).format("&aYou were added into minigame lobby"));
                    cancel();
                }
            }
        }.runTaskTimer(main,20L, 20L);
    }
}
