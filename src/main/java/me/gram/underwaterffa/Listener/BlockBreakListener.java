package me.gram.underwaterffa.Listener;

import me.gram.underwaterffa.states.GameManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    private GameManager gameManager;

    public BlockBreakListener(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @EventHandler
    private void onBlockBreak(BlockBreakEvent event){
        if(!gameManager.getBlockManager().canBreak(event.getBlock())){
            event.setCancelled(true);
        }
    }
}
