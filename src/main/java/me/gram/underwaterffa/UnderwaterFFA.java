package me.gram.underwaterffa;

import me.gram.underwaterffa.Listener.MGListener;
import me.gram.underwaterffa.Listener.players.DamageEvent;
import me.gram.underwaterffa.Listener.players.InventoryEvent;
import me.gram.underwaterffa.Listener.players.PlayerJoin;
import me.gram.underwaterffa.Listener.players.SwimListener;
import me.gram.underwaterffa.Teams.SpawnPoints;
import me.gram.underwaterffa.Teams.RedBlueTeam;
import me.gram.underwaterffa.commands.*;
import me.gram.underwaterffa.states.GameState;
import org.bukkit.entity.Player;
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
     * Blue vs Red scoreboard 100kills to win
     * Ability to set spawns (waiting lobby) Blue and Red team spawns
     * Database
     */

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
        loadConfig();
        saveDefaultConfig();
        setGamestate(GameState.LOBBY);
        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable(){
        new RedBlueTeam(this).clearTeams();
    }

    private void registerCommands(){
        getCommand("Start").setExecutor(new StartCommand(this));
        getCommand("stop").setExecutor(new StopCommand(this));
        getCommand("v").setExecutor(new Vanish(this));
        getCommand("spawnpoint").setExecutor(new SpawnPoints(this));
        getCommand("gametools").setExecutor(new admintools(this));
        getCommand("test").setExecutor(new test(this));
    }

    private void registerEvents(){
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerJoin(this), this);
        pm.registerEvents(new MGListener(this), this);
        pm.registerEvents(new SwimListener(this), this);
        pm.registerEvents(new DamageEvent(this), this);
        //pm.registerEvents(new InventoryEvent(this),this ); !remember to add this back //
        pm.registerEvents(new SpawnPoints(this), this);
    }

    private void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

}
