package me.gram.underwaterffa.Listener.players;

import me.gram.underwaterffa.UnderwaterFFA;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class InventoryEvent implements Listener {
    private UnderwaterFFA main;
    public InventoryEvent(UnderwaterFFA main) {
        this.main = main;
    }

    @EventHandler
    private void onClick(InventoryClickEvent event){event.setCancelled(true);}

    @EventHandler
    private void onSwap(PlayerSwapHandItemsEvent event){event.setCancelled(true);}

}
