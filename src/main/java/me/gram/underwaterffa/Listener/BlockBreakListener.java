package me.gram.underwaterffa.Listener;

import me.gram.underwaterffa.UnderwaterFFA;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    private GameManager gameManager;

    private UnderwaterFFA main;

    public BlockBreakListener(UnderwaterFFA main) {
        this.main = main;
    }

    @EventHandler
    private void onBlockBreak(BlockBreakEvent event){
        if(!gameManager.getBlockManager().canBreak(event.getBlock())){
            event.setCancelled(true);
        }
    }
}
