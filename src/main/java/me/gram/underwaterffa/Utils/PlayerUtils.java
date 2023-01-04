package me.gram.underwaterffa.Utils;

import me.gram.underwaterffa.UnderwaterFFA;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.checkerframework.checker.units.qual.C;

import java.util.UUID;


public class PlayerUtils{

    private UnderwaterFFA main;
    public PlayerUtils(UnderwaterFFA main) {
        this.main = main;
    }
    /** PLAYER UTILS**/

    public void giveMinigameItems(){
        Bukkit.getOnlinePlayers().stream().filter(player -> player.getGameMode() == GameMode.SURVIVAL).forEach(this::giveMinigameItem);
        Bukkit.getOnlinePlayers().stream().filter(player -> player.getGameMode() == GameMode.CREATIVE).forEach(this::giveMinigameItem);
}

    public void giveMinigameItem(Player player){
        player.getInventory().addItem(new ItemBuilder(main).Builditem(Material.IRON_SWORD, 1));
        player.getInventory().addItem(new ItemBuilder(main).Builditem(Material.BOW, 1));
        player.getInventory().addItem(new ItemBuilder(main).Builditem(Material.ARROW, 16));

    }


    public  void removeItems(){
        Bukkit.getOnlinePlayers().stream().filter(player -> player.getGameMode() == GameMode.SURVIVAL).forEach(this::removeItem);
        Bukkit.getOnlinePlayers().stream().filter(player -> player.getGameMode() == GameMode.CREATIVE).forEach(this::removeItem);
    }

    public void removeItem(Player player){
        player.getInventory().clear();
    }



    public boolean playerCanAttack() {
        return true;
    }


}
    /** PLAYER UTILS**/




