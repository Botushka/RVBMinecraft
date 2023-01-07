package me.gram.underwaterffa.Listener.players;

import me.gram.underwaterffa.Teams.RedBlueTeam;
import me.gram.underwaterffa.Teams.ScoreboardTeams;
import me.gram.underwaterffa.UnderwaterFFA;
import me.gram.underwaterffa.Utils.ChatUtils;
import me.gram.underwaterffa.Utils.PlayerUtils;
import me.gram.underwaterffa.states.GameState;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import static me.gram.underwaterffa.Teams.ScoreboardTeams.*;

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
    public void onKill(PlayerDeathEvent e)
    {
        Player player = e.getEntity();
        String killed = e.getEntity().getName();
        String killer = e.getEntity().getKiller().getName();

        new BukkitRunnable() {


            int testScore = 10;
            @Override
            public void run() {
                if(new RedBlueTeam(main).isInRed(player)){
                    e.setDeathMessage(new ChatUtils(main).format("&9[BLUE] " + killed +  "&7 was killed by " + "&c[RED] " + killer));
                    redScore--;
                    testScore--;
                    new ScoreboardTeams(main).updateScoreBoard(player);
                    player.sendMessage(String.valueOf(testScore));
                }else if(new RedBlueTeam(main).isInBlue(player)){
                    e.setDeathMessage(new ChatUtils(main).format("&c[RED] " + killed + "&7 was killed by " + "&9[BLUE] " + killer));
                    blueScore--;
                    testScore--;
                    new ScoreboardTeams(main).updateScoreBoard(player);
                    player.sendMessage(String.valueOf(testScore));
                }
            }
        }.runTaskTimer(main,20L, 20L);
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
