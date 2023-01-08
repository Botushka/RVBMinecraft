package me.gram.underwaterffa.Listener.players;

import me.gram.underwaterffa.Teams.RedBlueTeam;
import me.gram.underwaterffa.Teams.ScoreboardTeams;
import me.gram.underwaterffa.UnderwaterFFA;
import me.gram.underwaterffa.Utils.ChatUtils;
import me.gram.underwaterffa.Utils.PlayerUtils;
import me.gram.underwaterffa.states.GameState;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
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
import org.bukkit.scoreboard.Score;

import static me.gram.underwaterffa.Teams.ScoreboardTeams.*;

public class DamageEvent implements Listener {

    private UnderwaterFFA main;

    public DamageEvent(UnderwaterFFA main) {
        this.main = main;
    }


    public void addKill(Player p, int amount){
        yourkills = yourkills + amount;
    }
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        if(e.getEntity().getType().equals(EntityType.PLAYER)){
            if(e.getDamager() instanceof Player){
                Player damager = (Player) e.getDamager();
                Player player =  (Player) e.getEntity();
                player.damage(player.getHealth());
                if(new RedBlueTeam(main).isInRed(player)){
                    redScore = redScore -1;

                }else if(new RedBlueTeam(main).isInBlue(player)){
                    blueScore = blueScore - 1;
                }
                else{
                    new ScoreboardTeams(main).updateScoreBoard(player);
                }

                if(damager instanceof Player){
                    new ScoreboardTeams(main).updateScoreBoard(damager);
                    addKill(damager, 1);
                }
                new ScoreboardTeams(main).updateScoreBoard(player);
            }
        }
    }


    @EventHandler
    public void onKill(PlayerDeathEvent e)
    {
        Player player = e.getEntity();
        String killed = e.getEntity().getName();
        String killer = e.getEntity().getKiller().getName();
        if(new RedBlueTeam(main).isInRed(player)){
            e.setDeathMessage(new ChatUtils(main).format("&9[BLUE] " + killed +  "&7 was killed by " + "&c[RED] " + killer));
        }else if(new RedBlueTeam(main).isInBlue(player)){
            e.setDeathMessage(new ChatUtils(main).format("&c[RED] " + killed + "&7 was killed by " + "&9[BLUE] " + killer));
        }else{
            e.setDeathMessage(new ChatUtils(main).format("&7" + killed + " was killed by " + killer));
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
