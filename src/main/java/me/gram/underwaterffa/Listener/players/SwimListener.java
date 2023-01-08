package me.gram.underwaterffa.Listener.players;

import me.gram.underwaterffa.Teams.ScoreboardTeams;
import me.gram.underwaterffa.UnderwaterFFA;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityAirChangeEvent;
import org.bukkit.event.entity.EntityExhaustionEvent;
import org.bukkit.scoreboard.Score;

public class SwimListener implements Listener {

    private UnderwaterFFA main;
    public SwimListener(UnderwaterFFA main) {
        this.main = main;
    }

    @EventHandler
    public void onSwim(EntityAirChangeEvent e){
        Player player = (Player) e.getEntity();
        new ScoreboardTeams(main).updateScoreBoard(player);
        e.setCancelled(true);
    }

    @EventHandler
    public void onRun(EntityExhaustionEvent e){
        Player player = (Player) e.getEntity();
        new ScoreboardTeams(main).updateScoreBoard(player);
        e.setCancelled(true);
    }

}
