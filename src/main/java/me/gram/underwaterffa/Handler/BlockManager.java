package me.gram.underwaterffa.Handler;
import me.gram.underwaterffa.states.GameManager;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import java.util.HashSet;
import java.util.Set;

public class BlockManager implements Listener {

    private GameManager gameManager;

    public BlockManager(GameManager gameManager){
    this.gameManager = gameManager;

    allowedToBreak.add(Material.OAK_LEAVES);
}

    private Set<Material> allowedToBreak = new HashSet<>();

    public boolean canBreak(Block block){
        return allowedToBreak.contains(block.getType());
    }

}
