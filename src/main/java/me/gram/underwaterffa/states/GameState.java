package me.gram.underwaterffa.states;

import org.bukkit.Bukkit;

public enum GameState {
    IN_LOBBY(true), IN_GAME(false), POST_GAME(false);

    private boolean canJoin;
    private static GameState currentstate;
    GameState(Boolean canJoin){
        this.canJoin = canJoin;
    }

    public boolean canJoin(){
        return canJoin;
    }

    public static void setState(GameState state){
        if(currentstate == GameState.IN_GAME && state == currentstate.IN_LOBBY) return;

        GameState.currentstate = state;

        switch(state){
            case IN_LOBBY:
                Bukkit.broadcastMessage("Waiting players to start the game.");
                break;
            case IN_GAME:
                // Game Start timer
                // Teleport players
                // clear iventories and give gamemode items
            case POST_GAME:
                // players unable to kill each other
                // declare winner
                //clear inventories
                //TP back to hub
        }
    }

    public static boolean isState(GameState state){
        return GameState.currentstate == state;
    }

    public static GameState getState(){
        return currentstate;
    }
}
