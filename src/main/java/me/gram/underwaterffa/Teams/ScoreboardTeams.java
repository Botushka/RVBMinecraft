package me.gram.underwaterffa.Teams;

import me.gram.underwaterffa.UnderwaterFFA;
import me.gram.underwaterffa.Utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class ScoreboardTeams {

    private UnderwaterFFA main;

    public ScoreboardTeams(UnderwaterFFA main) {
        this.main = main;
    }


        public static int redScore = 10;
        public static int blueScore = 10;
        public static int testScore = 10;

        public void createBoard(Player player) {
            ScoreboardManager manager = Bukkit.getScoreboardManager();
            Scoreboard board = manager.getNewScoreboard();
            Objective obj = board.registerNewObjective("UnderwaterFFAboard", "dummy", new ChatUtils(main).format("&aUnderwaterFFA"));
            obj.setDisplaySlot(DisplaySlot.SIDEBAR);

            Team Red = board.registerNewTeam("Red");
            Team Blue = board.registerNewTeam("Blue");

            obj.getScore("=-=-=-=-=-=-=-=-=");
            Score score0 = obj.getScore("=-=-=-=-=-=-=-=-=");
            score0.setScore(1);
            Score score2 = obj.getScore(new ChatUtils(main).format("&cRed &alives: &c"));
            score2.setScore(redScore);
            Score score1 = obj.getScore(new ChatUtils(main).format("&9Blue &alives: &9"));
            score1.setScore(blueScore);
            Score score5= obj.getScore(new ChatUtils(main).format("&5TEST &alives: &9" + testScore));
            score5.setScore(2);



            player.setScoreboard(board);
        }

        public void updateScoreBoard(Player p) {

            Objective obj = p.getScoreboard().getObjective("UnderwaterFFAboard");
            obj.getScore("&5TEST &alives: &9" + testScore);
            obj.getScore("&9Blue &alives: &9").setScore(redScore);
            obj.getScore("&9Blue &alives: &9").setScore(blueScore);
        }
    }

