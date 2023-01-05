package me.gram.underwaterffa.Listener.players;

import me.gram.underwaterffa.UnderwaterFFA;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityAirChangeEvent;

public class SwimListener implements Listener {

    private UnderwaterFFA main;
    public SwimListener(UnderwaterFFA main) {
        this.main = main;
    }

    @EventHandler
    public void onSwim(EntityAirChangeEvent e){
        e.setCancelled(true);
    }

}
