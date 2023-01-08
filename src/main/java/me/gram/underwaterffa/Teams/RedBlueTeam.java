package me.gram.underwaterffa.Teams;

import me.gram.underwaterffa.UnderwaterFFA;
import me.gram.underwaterffa.Utils.ChatUtils;
import me.gram.underwaterffa.Utils.ItemBuilder;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

public class RedBlueTeam implements Listener {

    private UnderwaterFFA main;

    public RedBlueTeam(UnderwaterFFA main) {
        this.main = main;
    }

    public static List<String> redTeam = new ArrayList<String>();


    public static List<String> blueTeam = new ArrayList<String>();

    public void addToTeams() {
        Bukkit.getOnlinePlayers().stream().filter(player -> player.getGameMode() == GameMode.SURVIVAL).forEach(this::addToTeam);
    }

    public void addToTeam(Player player) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (blueTeam.size() <= redTeam.size()) {

                blueTeam.add(player.getName());
                player.sendMessage(new ChatUtils(main).prefix
                        + "You've  been added to the " + new ChatUtils(main).format("&9BLUE ") + new ChatUtils(main).format("&eteam!"));
                player.getInventory().setHelmet(new ItemBuilder(Material.BLUE_WOOL).toItemStack());
                player.getInventory().setBoots(new ItemBuilder(Material.LEATHER_BOOTS).setLeatherArmorColor(Color.BLUE).toItemStack());
                player.setDisplayName(new ChatUtils(main).format("&9[BLUE] " + player.getName()));
                player.setPlayerListName(new ChatUtils(main).format("&9[BLUE] " + player.getName()));
                break;
            } else {
                redTeam.add(player.getName());
                player.sendMessage(new ChatUtils(main).prefix
                        + "You've  been added to the " + new ChatUtils(main).format("&cRED ") + new ChatUtils(main).format("&eteam!"));
                player.getInventory().setHelmet(new ItemBuilder(Material.RED_WOOL).toItemStack());
                player.getInventory().setBoots(new ItemBuilder(Material.LEATHER_BOOTS).setLeatherArmorColor(Color.RED).toItemStack());
                player.setDisplayName(new ChatUtils(main).format("&c[RED] " + player.getName()));
                player.setPlayerListName(new ChatUtils(main).format("&c[RED] " + player.getName()));
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

    public boolean isInRed(Player player){
        return redTeam.contains(player.getName());
    }


    public boolean isInBlue(Player player){
        return blueTeam.contains(player.getName());
    }
    public List<String> getRedTeam(){
        return redTeam;
    }

    public List<String> getBlueTeam(){
        return blueTeam;
    }

}
