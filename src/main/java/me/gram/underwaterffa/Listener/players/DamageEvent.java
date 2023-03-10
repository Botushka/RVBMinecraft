package me.gram.underwaterffa.Listener.players;

import me.gram.underwaterffa.Teams.RedBlueTeam;
import me.gram.underwaterffa.Teams.ScoreboardTeams;
import me.gram.underwaterffa.UnderwaterFFA;
import me.gram.underwaterffa.Utils.ChatUtils;
import me.gram.underwaterffa.Utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.Arrays;

import static me.gram.underwaterffa.Teams.ScoreboardTeams.*;

public class DamageEvent implements Listener {

    private UnderwaterFFA main;

    public DamageEvent(UnderwaterFFA main) {
        this.main = main;
    }

    public final String KILLSTREAKS = new ChatUtils(main).format("&6KILLSTREAKS");
    public void addKill(Player p, int amount){
        yourkills = yourkills + amount;
    }

    @EventHandler
    public void teamDamage(EntityDamageByEntityEvent e){
        if(e.getEntity().getType().equals(EntityType.PLAYER)){
            if(e.getDamager() instanceof Player){
                Player damager = (Player) e.getDamager();
                Player player =  (Player) e.getEntity();
                if(new RedBlueTeam(main).isInRed(damager) && new RedBlueTeam(main).isInRed(player)){
                    e.setCancelled(true);
                    player.sendMessage("You can't attack your own teammates!");
                } else if (new RedBlueTeam(main).isInBlue(damager) && new RedBlueTeam(main).isInBlue(player)) {
                    {e.setCancelled(true); player.sendMessage("You can't attack your own teammates!");}
                }

            }
        }
    }

    @EventHandler
    public void onKill(PlayerDeathEvent e) {
        Player player = e.getEntity();
        String killed = e.getEntity().getName();
        String killer = "";
        if (player.getKiller() instanceof Player) {
            killer = player.getKiller().getName();
        } else {
            killer = "unknown";
        }
        if (player.getHealth() == 0) {  // check if the player is actually dead
            if (new RedBlueTeam(main).isInRed(player)) {
                e.setDeathMessage(new ChatUtils(main).format("&c[RED] " + killed + "&7 was killed by " + "&9[BLUE] " + killer));
                redScore--;
                player.getKiller().getInventory().addItem(new ItemBuilder(Material.GOLD_NUGGET, 1).setName(KILLSTREAKS).toItemStack());
            } else if (new RedBlueTeam(main).isInBlue(player)) {
                blueScore--;
                player.getKiller().getInventory().addItem(new ItemBuilder(Material.GOLD_NUGGET, 1).setName(KILLSTREAKS).toItemStack());
                e.setDeathMessage(new ChatUtils(main).format("&9[BLUE] " + killed +  "&7 was killed by " + "&c[RED] " + killer));
            } else {
                e.setDeathMessage(new ChatUtils(main).format("&7" + killed + " was killed by " + killer));
            }
            new ScoreboardTeams(main).updateScoreBoard(player);
        }
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        Entity shooter = (Entity) e.getEntity().getShooter();
        if (shooter instanceof Player) {
            Player damager = (Player) shooter;
            String shooterName = damager.getName();
            Entity hitEntity = e.getHitEntity();
            if (hitEntity instanceof Player) {
                Player player = (Player) hitEntity;
                if (new RedBlueTeam(main).isInRed(damager) && new RedBlueTeam(main).isInRed(player)) {
                    e.setCancelled(true);
                    damager.sendMessage("You can't attack your own teammates!");
                } else if (new RedBlueTeam(main).isInBlue(damager) && new RedBlueTeam(main).isInBlue(player)) {
                    e.setCancelled(true);
                    damager.sendMessage("You can't attack your own teammates!");
                } else {
                    player.setHealth(0);
                    PlayerDeathEvent deathEvent = new PlayerDeathEvent(player, Arrays.asList(player.getInventory().getContents()), 0, shooterName + " killed " + player.getName());
                    Bukkit.getServer().getPluginManager().callEvent(deathEvent);
                }
            }
        }
    }
    @EventHandler
    public void foodChange(FoodLevelChangeEvent event){
        event.setCancelled(true);
    }

}
