package me.gram.underwaterffa.Listener.players;


import me.gram.underwaterffa.Handler.PlayerManager;
import me.gram.underwaterffa.Teams.ScoreboardTeams;
import me.gram.underwaterffa.UnderwaterFFA;
import me.gram.underwaterffa.countdowns.PreGameTimer;
import me.gram.underwaterffa.states.GameState;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Score;

public class PlayerJoin implements Listener {

    private UnderwaterFFA main;
    public PlayerJoin(UnderwaterFFA main) {
        this.main = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        event.setJoinMessage("");
        new PlayerManager(main).handle(p);
        new ScoreboardTeams(main).createBoard(p);
        if (Bukkit.getOnlinePlayers().size() >= 16) {
            new PreGameTimer(main).startCountdown();
        } else if (main.getGamestate() == GameState.LOBBY) {
            return;
        }

    }
}
