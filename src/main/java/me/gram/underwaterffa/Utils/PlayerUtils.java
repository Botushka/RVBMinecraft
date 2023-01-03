package me.gram.underwaterffa.Utils;

import me.gram.underwaterffa.states.GameManager;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerUtils {

    public ItemStack item;

    private GameManager gameManager;


    /** ITEM BUILDER**/
    public PlayerUtils(Material material){
        item = new ItemStack(material);
    }

    public PlayerUtils setAmount(int amount){
        item.setAmount(amount);
        return this;
    }
    public PlayerUtils setName(String name){
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return this;
    }

    public PlayerUtils buildItem(){
        return this;
    }
    /** ITEM BUILDER**/

    /** PLAYER UTILS**/

    public  PlayerUtils removeItems(){
        return this;
    }

    public boolean playerCanAttack() {
        return true;
    }
    /** PLAYER UTILS**/
}
