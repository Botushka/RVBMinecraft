package me.gram.underwaterffa.commands;

import me.gram.underwaterffa.Teams.RedBlueTeam;
import me.gram.underwaterffa.UnderwaterFFA;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class teamcheck implements CommandExecutor {
    private UnderwaterFFA main;


    /**
     * Used it for testing red and blue teams however left it in if needed in the future. Can easily be removed.
     * */
    public teamcheck(UnderwaterFFA main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (command.getName().equalsIgnoreCase("teamcheck"))
            if (new RedBlueTeam(main).blueTeam.contains(p.getName())) {
                p.sendMessage("You are in Blue team!");
            } else if(new RedBlueTeam(main).redTeam.contains(p.getName())){
                p.sendMessage("You are in Red team!");

            }else{
                p.sendMessage("You are not in a team!");
            }
        return true;
    }
}
