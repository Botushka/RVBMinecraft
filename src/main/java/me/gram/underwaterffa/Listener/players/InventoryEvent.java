package me.gram.underwaterffa.Listener.players;

import me.gram.underwaterffa.UnderwaterFFA;
import me.gram.underwaterffa.Utils.PlayerUtils;
import org.bukkit.Location;
import org.bukkit.block.data.type.Fire;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.util.Vector;

public class InventoryEvent implements Listener {
    private UnderwaterFFA main;
    public InventoryEvent(UnderwaterFFA main) {
        this.main = main;
    }

    @EventHandler
    private void onClick(InventoryClickEvent event){event.setCancelled(true);}

    @EventHandler
    private void onSwap(PlayerSwapHandItemsEvent event){event.setCancelled(true);}

    @EventHandler
    public void onRocketLauncherClick(PlayerInteractEvent e){
        if(e.getHand() == EquipmentSlot.OFF_HAND)
            return;
        if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK)
            return;
        if(e.getItem() == null || e.getItem().getItemMeta().getDisplayName() == null)
            return;
        if(!e.getItem().getItemMeta().getDisplayName().equals(new PlayerUtils(main).ROCKET_LAUNCHER))
            return;

        Player p = e.getPlayer();
        Location loc = p.getLocation();
        Entity f = loc.getWorld().spawnEntity(loc.add(0,2,0), EntityType.FIREBALL);
        f.setVelocity(loc.getDirection().multiply(5));

    }
}
