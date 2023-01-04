package me.gram.underwaterffa.Utils;

import me.gram.underwaterffa.states.GameManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {

    public ItemStack item;

    private GameManager gameManager;
    public ItemBuilder(GameManager gameManager){
        this.gameManager = gameManager;
    }


    /** ITEM BUILDER**/
    public ItemBuilder Builditem(Material material){
        item = new ItemStack(material);
        return this;
    }

    public ItemBuilder setAmount(int amount){
        item.setAmount(amount);
        return this;
    }
    public ItemBuilder setName(String name){
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder buildItem(){
        return this;
    }

    public ItemBuilder addEnchant(Enchantment ench, int level){
        ItemMeta im = item.getItemMeta();
        im.addEnchant(ench, level, true);
        item.setItemMeta(im);
        return this;


    }
    /** ITEM BUILDER**/
}
