package me.gram.underwaterffa.Listener.players;

import me.gram.underwaterffa.UnderwaterFFA;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

public class DamageEvent implements Listener {

    private UnderwaterFFA main;

    public DamageEvent(UnderwaterFFA main) {
        this.main = main;
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        if(e.getEntity().getType().equals(EntityType.PLAYER)){
            if(e.getDamager() instanceof Player){
                Player damager = (Player) e.getDamager();
                Player player = (Player) e.getEntity();
                player.damage(player.getHealth());
            }
        }
    }

    @EventHandler
    public void onBowDamage(ProjectileHitEvent e){
        Player player = (Player) e.getHitEntity();
        player.damage(player.getHealth());
    }
    @EventHandler
    public void foodChange(FoodLevelChangeEvent event){
        event.setCancelled(true);
    }

}
