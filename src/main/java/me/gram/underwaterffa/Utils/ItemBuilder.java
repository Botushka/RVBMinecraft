package me.gram.underwaterffa.Utils;

import me.gram.underwaterffa.UnderwaterFFA;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder extends ItemStack {

    public ItemStack item;
    public ItemStack gear;

    private UnderwaterFFA main;
    public ItemBuilder(UnderwaterFFA main) {
        this.main = main;
    }



    /**
     * ITEM BUILDER
     **/
    public ItemStack Builditem(Material material, int amount){
        item = new ItemStack(material, amount);
        return item;
    }


    public ItemStack BuildArmor(Material armor, Enchantment ench, int level){
        item = new ItemStack(armor);
        ItemMeta im = item.getItemMeta();
        im.addEnchant(ench, level, true);
        item.setItemMeta(im);
        return item;
    }

    public ItemBuilder setName(String name){
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(name);
        item.setItemMeta(im);
        return this;
    }

    public ItemStack addEnchant(Enchantment ench, int level){
        ItemMeta im = item.getItemMeta();
        im.addEnchant(ench, level, true);
        item.setItemMeta(im);
        return item;


    }
    /** ITEM BUILDER**/
}
