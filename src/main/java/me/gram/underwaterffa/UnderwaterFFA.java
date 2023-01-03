package me.gram.underwaterffa;

import jdk.javadoc.internal.tool.Start;
import me.gram.underwaterffa.Handler.Game;
import me.gram.underwaterffa.Listener.MGListener;
import me.gram.underwaterffa.Listener.players.PlayerJoin;
import me.gram.underwaterffa.commands.StartCommand;
import me.gram.underwaterffa.commands.StopCommand;
import me.gram.underwaterffa.states.GameManager;
import me.gram.underwaterffa.states.GameState;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class UnderwaterFFA extends JavaPlugin implements Listener {
    /**UNFINISHED
     * TODO: FFA UNDER WATER
     * minigame one hit dead, bow(or raygun),sword,
     * fast af swimming, unlimited breathing, random spawn location after death
     * cool underwater map
     */

    private GameManager gameManager;


    @Override
    public void onEnable() {
        this.gameManager = new GameManager(this);
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerJoin(this), this);
        pm.registerEvents(this,  this);
        pm.registerEvents(new MGListener(this), this);
        getCommand("Start").setExecutor(new StartCommand(gameManager));
        getCommand("stop").setExecutor(new StopCommand(gameManager));
    }

}
