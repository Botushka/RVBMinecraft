package me.gram.underwaterffa.Utils;

import me.gram.underwaterffa.UnderwaterFFA;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static org.bukkit.enchantments.Enchantment.DEPTH_STRIDER;


public class PlayerUtils{
    private ItemBuilder items;
    private UnderwaterFFA main;
    public PlayerUtils(UnderwaterFFA main) {
        this.main = main;
    }

    /** PLAYER UTILS**/
    PotionEffect Dolphin = new PotionEffect(PotionEffectType.DOLPHINS_GRACE, Integer.MAX_VALUE, 10);
    PotionEffect NV = new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 10);
    public void giveMinigameItems(){
        Bukkit.getOnlinePlayers().stream().filter(player -> player.getGameMode() == GameMode.SURVIVAL).forEach(this::giveMinigameItem);
        Bukkit.getOnlinePlayers().stream().filter(player -> player.getGameMode() == GameMode.CREATIVE).forEach(this::giveMinigameItem);


}

    public void giveMinigameItem(Player player){
        player.getInventory().addItem(new ItemBuilder(Material.IRON_SWORD).toItemStack());
        player.getInventory().addItem(new ItemBuilder(Material.BOW).toItemStack());
        player.getInventory().addItem(new ItemBuilder(Material.ARROW, 3).toItemStack());
        player.getInventory().setBoots(new ItemBuilder(Material.LEATHER_BOOTS).addEnchant(DEPTH_STRIDER, 1).toItemStack());
        player.addPotionEffect(NV);
        player.addPotionEffect(Dolphin);
    }

    public  void removeItems(){
        Bukkit.getOnlinePlayers().stream().filter(player -> player.getGameMode() == GameMode.SURVIVAL).forEach(this::removeItem);
        Bukkit.getOnlinePlayers().stream().filter(player -> player.getGameMode() == GameMode.CREATIVE).forEach(this::removeItem);

    }

    public void removeItem(Player player){
        player.getInventory().clear();
        for(PotionEffect effect:player.getActivePotionEffects()){
            player.removePotionEffect(effect.getType());
        }
    }



    public boolean playerCanAttack() {
        return true;
    }


}
    /** PLAYER UTILS**/




