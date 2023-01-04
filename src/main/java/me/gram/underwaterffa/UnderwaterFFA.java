package me.gram.underwaterffa;

import me.gram.underwaterffa.Listener.MGListener;
import me.gram.underwaterffa.Listener.players.PlayerJoin;
import me.gram.underwaterffa.commands.StartCommand;
import me.gram.underwaterffa.commands.StopCommand;
import me.gram.underwaterffa.commands.Vanish;
import me.gram.underwaterffa.states.GameManager;
import me.gram.underwaterffa.states.GameState;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class UnderwaterFFA extends JavaPlugin{
    /**UNFINISHED
     *
     * TODO: FFA UNDER WATER
     * minigame one hit dead, bow(or raygun),sword,
     * fast af swimming, unlimited breathing, random spawn location after death
     * cool underwater map
     * Killstreaks
     * Teams
     * Ability to set spawns (waiting lobby) Blue and Red team spawns
     * Database
     */

    private GameManager gameManager;

    private GameState gamestates;
    public GameState getGamestate() {
        return gamestates;
    }
    public void setGamestate(GameState gamestate) {
        this.gamestates = gamestate;
    }

    public ArrayList<Player> alive = new ArrayList<>();
    public ArrayList<Player> spectating = new ArrayList<>();
    public ArrayList<Player> vanished = new ArrayList<>();


    @Override
    public void onEnable() {
        setGamestate(GameState.LOBBY);
        this.gameManager = new GameManager(this);
        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable(){

    }

    private void registerCommands(){
        getCommand("Start").setExecutor(new StartCommand(gameManager));
        getCommand("stop").setExecutor(new StopCommand(gameManager));
        getCommand("vanish").setExecutor(new Vanish(this));
    }

    private void registerEvents(){
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerJoin(this), this);
        pm.registerEvents(new MGListener(this), this);
    }

}
