package me.gram.underwaterffa.states;

public enum GameState {
    IN_LOBBY(true), IN_GAME(false), POST_GAME(false), RESETTING(false);

    private boolean canJoin;
    private static GameState currentstate;
    GameState(Boolean canJoin){
        this.canJoin = canJoin;
    }

    public boolean canJoin(){
        return canJoin;
    }

    public static void setState(GameState state){
        GameState.currentstate = state;
    }

    public static boolean isState(GameState state){
        return GameState.currentstate == state;
    }

    public static GameState getState(){
        return currentstate;
    }
}
