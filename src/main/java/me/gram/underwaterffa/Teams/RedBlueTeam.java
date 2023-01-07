package me.gram.underwaterffa.Teams;

import me.gram.underwaterffa.UnderwaterFFA;
import me.gram.underwaterffa.Utils.ChatUtils;
import me.gram.underwaterffa.Utils.ItemBuilder;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;

public class RedBlueTeam {

    private UnderwaterFFA main;

    public RedBlueTeam(UnderwaterFFA main) {
        this.main = main;
    }

    public List<String> redTeam = new ArrayList<>();


    public List<String> blueTeam = new ArrayList<>();

    public void addToTeams() {
        Bukkit.getOnlinePlayers().stream().filter(player -> player.getGameMode() == GameMode.SURVIVAL).forEach(this::addToTeam);
    }

    public void addToTeam(Player player) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (blueTeam.size() <= redTeam.size()) {
                blueTeam.add(p.getName());
                player.sendMessage(new ChatUtils(main).prefix
                        + "You've  been added to the " + new ChatUtils(main).format("&9BLUE ") + new ChatUtils(main).format("&eteam!"));
                p.getInventory().setHelmet(new ItemBuilder(Material.BLUE_WOOL).toItemStack());
                p.getInventory().setBoots(new ItemBuilder(Material.LEATHER_BOOTS).toItemStack());
                p.setDisplayName(ChatColor.BLUE + p.getName());
                p.setPlayerListName(ChatColor.BLUE + p.getName());
                break;
            }else{
                redTeam.add(player.getName());
                player.sendMessage(new ChatUtils(main).prefix
                        + "You've  been added to the " + new ChatUtils(main).format("&cRED ") + new ChatUtils(main).format("&eteam!"));
                p.getInventory().setHelmet(new ItemBuilder(Material.RED_WOOL).toItemStack());
                p.getInventory().setBoots(new ItemBuilder(Material.LEATHER_BOOTS).toItemStack());
                player.setDisplayName(ChatColor.RED + player.getName());
                player.setPlayerListName(ChatColor.RED + player.getName());
                break;
            }

        }
    }

    public void clearTeams(){
        redTeam.clear();
        blueTeam.clear();
    }

    public boolean isInTeam(Player player){
        return redTeam.contains(player.getName()) ||
                blueTeam.contains(player.getName());
    }
    public List<String> getRedTeam(){
        return redTeam;
    }

    public List<String> getBlueTeam(){
        return blueTeam;
    }

}
