package me.gram.underwaterffa;

import me.gram.underwaterffa.Listener.MGListener;
import me.gram.underwaterffa.Listener.players.*;
import me.gram.underwaterffa.Teams.SpawnPoints;
import me.gram.underwaterffa.Teams.RedBlueTeam;
import me.gram.underwaterffa.commands.*;
import me.gram.underwaterffa.states.GameState;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class UnderwaterFFA extends JavaPlugin {
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
    public void onDisable() {
        new RedBlueTeam(this).clearTeams();
    }
    private void registerCommands() {
        getCommand("Start").setExecutor(new StartCommand(this));
        getCommand("stop").setExecutor(new StopCommand(this));
        getCommand("v").setExecutor(new Vanish(this));
        getCommand("spawnpoint").setExecutor(new SpawnPoints(this));
        getCommand("gametools").setExecutor(new admintools(this));
        getCommand("teamcheck").setExecutor(new teamcheck(this));
    }
    private void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerJoin(this), this);
        pm.registerEvents(new MGListener(this), this);
        pm.registerEvents(new SwimListener(this), this);
        pm.registerEvents(new DamageEvent(this), this);
        pm.registerEvents(new InventoryEvent(this),this);
        pm.registerEvents(new SpawnPoints(this), this);
        pm.registerEvents(new RedBlueTeam(this), this);
        pm.registerEvents(new ReSpawnEvent(this), this);
    }
    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
