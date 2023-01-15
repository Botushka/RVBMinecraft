package me.gram.underwaterffa.Listener.players;


import me.gram.underwaterffa.Teams.SpawnPoints;
import me.gram.underwaterffa.UnderwaterFFA;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import static me.gram.underwaterffa.Teams.RedBlueTeam.blueTeam;
import static me.gram.underwaterffa.Teams.RedBlueTeam.redTeam;

public class ReSpawnEvent implements Listener {

    private UnderwaterFFA main;
    public ReSpawnEvent(UnderwaterFFA main) {
        this.main = main;
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event){
        Player player = event.getPlayer();
        if(blueTeam.contains(player.getName())){
            event.setRespawnLocation(new SpawnPoints(main).teleportBlueSpawn(player));
        }else if(redTeam.contains(player.getName())){
            event.setRespawnLocation(new SpawnPoints(main).teleportRedSpawn(player));
        }else if(main.spectating.contains(player.getName())){
            event.setRespawnLocation(new SpawnPoints(main).teleportSpectatorSpawn(player));
        }else{
            event.setRespawnLocation(new SpawnPoints(main).teleportSpectatorSpawn(player));
        }
        }
    }


