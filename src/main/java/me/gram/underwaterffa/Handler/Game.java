package me.gram.underwaterffa.Handler;

public class Game {

    private static boolean canStart = false;

    public static boolean canStart(){
        return canStart;
    }

    public static void setCanStart(boolean b){
        canStart = b;
    }
}
