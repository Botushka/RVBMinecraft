package me.gram.underwaterffa.Teams;

import me.gram.underwaterffa.UnderwaterFFA;
import me.gram.underwaterffa.Utils.ChatUtils;
import me.gram.underwaterffa.Utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;

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
                blueTeam.add(p.toString());
                player.sendMessage(new ChatUtils(main).prefix
                        + "You've  been added to the " + new ChatUtils(main).format("&9BLUE ") + new ChatUtils(main).format("&eteam!"));
                p.getInventory().setHelmet(new ItemBuilder(main).Builditem(Material.BLUE_WOOL, 1));
                break;
            }else{
                redTeam.add(player.toString());
                player.sendMessage(new ChatUtils(main).prefix
                        + "You've  been added to the " + new ChatUtils(main).format("&cRED ") + new ChatUtils(main).format("&eteam!"));
                player.getInventory().setHelmet(new ItemBuilder(main).Builditem(Material.RED_WOOL, 1));
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
