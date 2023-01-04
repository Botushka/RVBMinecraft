package me.gram.underwaterffa.states;

import me.gram.underwaterffa.Handler.BlockManager;
import me.gram.underwaterffa.UnderwaterFFA;
import me.gram.underwaterffa.Utils.ChatUtils;
import me.gram.underwaterffa.Utils.ItemBuilder;
import me.gram.underwaterffa.Utils.PlayerUtils;
import org.bukkit.Bukkit;
import static org.bukkit.Bukkit.getServer;

public class GameManager {

    private BlockManager blockManager;
    private PlayerUtils playerutil;
    private ItemBuilder im;
    private  GameState gameState;

    private UnderwaterFFA main;
    public GameManager(UnderwaterFFA main) {
        this.main = main;
        this.blockManager = new BlockManager(this);
    }


    public void setGameState(GameState gameState){
        this.gameState = gameState;
        switch(gameState){
            case LOBBY:
                getServer().broadcastMessage(new ChatUtils(main).prefix + "Waiting for players...");
                break;
            case INGAME:
                Bukkit.broadcastMessage(new ChatUtils(main).prefix + "STARTING GAME....");
                // Game Start timer
                // Teleport players
                // clear iventories and give gamemode items
                break;
            case ENDGAME:
                Bukkit.broadcastMessage(new ChatUtils(main).prefix + "(Team) TEAM WON");
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

