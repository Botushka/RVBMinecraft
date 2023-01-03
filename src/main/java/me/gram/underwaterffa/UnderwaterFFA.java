package me.gram.underwaterffa;

import me.gram.underwaterffa.Listener.players.PlayerJoin;
import me.gram.underwaterffa.states.GameState;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class UnderwaterFFA extends JavaPlugin {
    /**UNFINISHED
     * TODO: FFA UNDER WATER
     * minigame one hit dead, bow(or raygun),sword,
     * fast af swimming, unlimited breathing, random spawn location after death
     * cool underwater map
     */
    @Override
    public void onEnable() {
        GameState.setState(GameState.IN_LOBBY);

    }

    public static void start(){

    }

    public static void stop(){

    }
    public void registerListener(){
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerJoin(this), this);
    }


}
