package me.gram.underwaterffa.Listener.players;

import me.gram.underwaterffa.Handler.Game;
import me.gram.underwaterffa.Listener.MGListener;
import me.gram.underwaterffa.UnderwaterFFA;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin extends MGListener {

    public PlayerJoin(UnderwaterFFA pl) {
        super(pl);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Game.setCanStart(Bukkit.getOnlinePlayers().size() >= 2);
    }
}
