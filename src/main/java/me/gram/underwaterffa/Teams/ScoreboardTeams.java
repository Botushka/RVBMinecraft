package me.gram.underwaterffa.Teams;

import me.gram.underwaterffa.UnderwaterFFA;
import me.gram.underwaterffa.Utils.ChatUtils;
import me.gram.underwaterffa.states.GameState;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

public class ScoreboardTeams {

    private UnderwaterFFA main;

    public ScoreboardTeams(UnderwaterFFA main) {
        this.main = main;
    }


    public static int redScore = 10;
    public static int blueScore = 10;
    public static int yourkills = 0;

    public String statuss(){
        if(main.getGamestate() == GameState.LOBBY){
            String status = "Waiting for Players";
            return status;
        }else if(main.getGamestate() == GameState.INGAME){
            String status = "IN-GAME";
            return status;
        }else{
            String status = "Returning to lobby...";
            return status;
        }

    }

    public void createBoard(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("UnderwaterFFAboard", "dummy", new ChatUtils(main).format("&c&lRed &f&lvs &9&lBlue"));
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        Team status = board.registerNewTeam("status");
        Team online = board.registerNewTeam("online");
        Team red = board.registerNewTeam("red");
        Team blue = board.registerNewTeam("blue");
        Team kills = board.registerNewTeam("kills");
        Team Deaths = board.registerNewTeam("deaths");
        obj.getScore("=-=-=-=-=-=-=-=-=-=-=-=-=\"");
        Score score0 = obj.getScore("=-=-=-=-=-=-=-=-=-=-=-=-=");
        score0.setScore(9);
        obj.getScore("");
        Score score10 = obj.getScore("");
        score10.setScore(4);

        status.addEntry(ChatColor.RED + "");
        online.addEntry(ChatColor.BLACK + "" + ChatColor.WHITE);
        red.addEntry(ChatColor.WHITE + "" + ChatColor.WHITE);
        blue.addEntry(ChatColor.RED + "" + ChatColor.WHITE);
        kills.addEntry(ChatColor.BLUE + "" + ChatColor.WHITE);
        Deaths.addEntry(ChatColor.BLACK + "" + ChatColor.BLACK);

        if (Bukkit.getOnlinePlayers().size() == 0) {
            online.setPrefix(new ChatUtils(main).format("&f" + "0" + "/" + new ChatUtils(main).format("&a" + Bukkit.getOnlinePlayers())));
        } else {
            online.setPrefix("" + new ChatUtils(main).format("&b&l┃ &7Playing: " + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers()));
        }
        status.setPrefix("" + new ChatUtils(main).format("&6⚔ Status: " + statuss()));
        red.setPrefix("" + new ChatUtils(main).format("&b&l┃ &cRed &c♥" + redScore));
        blue.setPrefix("" + new ChatUtils(main).format("&b&l┃ &9Blue &c♥" + blueScore));
        kills.setPrefix("" + new ChatUtils(main).format("&b&l┃ &7Kills: " + player.getStatistic(Statistic.PLAYER_KILLS)));
        Deaths.setPrefix("" + new ChatUtils(main).format("&b&l┃ &7Deaths: " + player.getStatistic(Statistic.DEATHS)));
        obj.getScore(ChatColor.RED + "").setScore(8);
        obj.getScore(ChatColor.BLACK + "" + ChatColor.WHITE).setScore(3);
        obj.getScore(ChatColor.WHITE + "" + ChatColor.WHITE).setScore(6);
        obj.getScore(ChatColor.RED + "" + ChatColor.WHITE).setScore(7);
        obj.getScore(ChatColor.BLUE + "" + ChatColor.WHITE).setScore(2);
        obj.getScore(ChatColor.BLACK + "" + ChatColor.BLACK).setScore(1);

        player.setScoreboard(board);
    }

    public void updateScoreBoard(Player p) {

        Scoreboard board = p.getScoreboard();

        new BukkitRunnable() {
            @Override
            public void run() {
                if (Bukkit.getOnlinePlayers().size() == 0) {
                    board.getTeam("online").setPrefix(new ChatUtils(main).format("&f" + "0" + "/" + new ChatUtils(main).format("&a" + Bukkit.getMaxPlayers())));
                } else {
                    board.getTeam("online").setPrefix(new ChatUtils(main).format("&b&l┃ &7Playing: " + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers()));
                }
                board.getTeam("status").setPrefix("" + new ChatUtils(main).format("&6⚔ Status: " + statuss()));
                board.getTeam("red").setPrefix("" + new ChatUtils(main).format("&b&l┃ &cRed &c♥" + redScore));
                board.getTeam("blue").setPrefix("" + new ChatUtils(main).format("&b&l┃ &9Blue &c♥" + blueScore));
                board.getTeam("kills").setPrefix("" + new ChatUtils(main).format("&b&l┃ &7Kills: " + p.getStatistic(Statistic.PLAYER_KILLS)));
                board.getTeam("deaths").setPrefix("" + new ChatUtils(main).format("&b&l┃ &7Deaths: " + p.getStatistic(Statistic.DEATHS)));
            }
        }.runTaskTimer(main,0, 20);

    }

}

