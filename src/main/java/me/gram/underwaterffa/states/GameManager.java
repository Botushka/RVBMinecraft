package me.gram.underwaterffa.states;

import me.gram.underwaterffa.Handler.BlockManager;
import me.gram.underwaterffa.UnderwaterFFA;
import me.gram.underwaterffa.Utils.ItemBuilder;
import me.gram.underwaterffa.Utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getPlayer;
import static org.bukkit.Bukkit.getServer;

public class GameManager {

    private final UnderwaterFFA plugin;
    private BlockManager blockManager;
    private PlayerUtils playerutil;
    private ItemBuilder im;
    private  GameState gameState;

    public  GameManager(UnderwaterFFA plugin){

        this.plugin = plugin;
        this.blockManager = new BlockManager(this);
}
    public void setGameState(GameState gameState){
        this.gameState = gameState;
        switch(gameState){
            case LOBBY:
                getServer().broadcastMessage("Waiting for players...");
                break;
            case INGAME:
                Bukkit.broadcastMessage("STARTING GAME....");
                // Game Start timer
                // Teleport players
                // clear iventories and give gamemode items
                break;
            case ENDGAME:
                Bukkit.broadcastMessage("(Team) TEAM WON");
                // players unable to kill each other
                // declare winner
                //clear inventories
                //TP back to hub
                break;
        }

    }

    public BlockManager getBlockManager(){
        return blockManager;
    }
    public ItemBuilder getItemBuilder() {return im;}

    public PlayerUtils getPlayerUtil(){return playerutil;}
}

