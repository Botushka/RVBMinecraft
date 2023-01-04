package me.gram.underwaterffa.Utils;

import me.gram.underwaterffa.states.GameManager;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

public class PlayerUtils{

    private GameManager gameManager;
    public PlayerUtils(GameManager gameManager){
        this.gameManager = gameManager;
    }

    /** PLAYER UTILS**/
    private ItemBuilder im;
    public void minigameItems(Player player){
        im.Builditem(Material.IRON_SWORD).setAmount(1).addEnchant(Enchantment.DURABILITY, 10).setName("&4Blade");
        im.Builditem(Material.BOW).setAmount(1).addEnchant(Enchantment.DURABILITY, 10).setName("&4Quiver");
        im.Builditem(Material.ARROW).setAmount(3).addEnchant(Enchantment.DURABILITY, 10).setName("&4Arrow");
        player.getInventory().addItem(this.im.item);

    }
    public  PlayerUtils removeItems(){
        return this;
    }

    public boolean playerCanAttack() {
        return true;
    }

    public ItemBuilder getItemBuilder() {return im;}
}
    /** PLAYER UTILS**/




