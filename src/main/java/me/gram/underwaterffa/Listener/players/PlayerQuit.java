package me.gram.underwaterffa.Listener.players;

import me.gram.underwaterffa.Handler.Game;
import me.gram.underwaterffa.Listener.MGListener;
import me.gram.underwaterffa.Teams.RedBlueTeam;
import me.gram.underwaterffa.UnderwaterFFA;
import me.gram.underwaterffa.states.GameManager;
import me.gram.underwaterffa.states.GameState;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit{

    private UnderwaterFFA main;

    public PlayerQuit(UnderwaterFFA main) {
        this.main = main;
    }

    @EventHandler
    public void onPlayerquit(PlayerQuitEvent event){
            Game.setCanStart(Bukkit.getOnlinePlayers().size() -1 >= 2);
        Player p = event.getPlayer();
        if(new RedBlueTeam(main).redTeam.contains(p.getName())){
            new RedBlueTeam(main).redTeam.remove(p.getName());
        }
        if(new RedBlueTeam(main).blueTeam.contains(p.getName())){
            new RedBlueTeam(main).blueTeam.remove(p.getName());
        }
    }
}
