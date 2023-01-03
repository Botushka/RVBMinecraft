package me.gram.underwaterffa.Listener.players;

import me.gram.underwaterffa.Handler.Game;
import me.gram.underwaterffa.Listener.MGListener;
import me.gram.underwaterffa.UnderwaterFFA;
import me.gram.underwaterffa.states.GameManager;
import me.gram.underwaterffa.states.GameState;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit extends MGListener {

    public PlayerQuit(UnderwaterFFA pl) {
        super(pl);
    }

    @EventHandler
    public void onPlayerquit(PlayerQuitEvent event){
            Game.setCanStart(Bukkit.getOnlinePlayers().size() -1 >= 2);
    }
}
