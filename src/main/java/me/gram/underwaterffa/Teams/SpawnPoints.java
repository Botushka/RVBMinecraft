package me.gram.underwaterffa.Teams;

import me.gram.underwaterffa.UnderwaterFFA;
import me.gram.underwaterffa.Utils.ChatUtils;
import me.gram.underwaterffa.Utils.ItemBuilder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class SpawnPoints implements CommandExecutor {
    private UnderwaterFFA main;

    public SpawnPoints(UnderwaterFFA main) {
        this.main = main;
    }

    private final String SET_BLUE_SPAWN = new ChatUtils(main).format("&aSet &9Blue &aspawn point &7(Right CLick)");
    private final String SET_RED_SPAWN = new ChatUtils(main).format("&aSet &cRed &aspawn point &7(Right CLick)");

    String Red = "Red Spawn";
    String Blue = "Blue Spawn";


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            Location loc = p.getLocation();
            Location l = p.getLocation();
            if (main.getConfig().getBoolean("enable")) {
                if (args.length == 1 && args[0].equalsIgnoreCase("red")) {
                    if (!sender.hasPermission("red.spawn")) {
                        p.sendMessage("You don't have permissoin to use this command!");
                    } else {
                        main.getConfig().createSection("savedlocations." + p.getName());
                        main.getConfig().set("savedlocations." + Red + ".x", l.getX());
                        main.getConfig().set("savedlocations." + Red + ".y", l.getY());
                        main.getConfig().set("savedlocations." + Red + ".z", l.getZ());
                        main.getConfig().set("savedlocations." + Red + ".pitch", l.getPitch());
                        main.getConfig().set("savedlocations." + Red + ".yaw", l.getYaw());
                        main.saveConfig();
                        p.sendMessage(new ChatUtils(main).format("&aYou have set up spawn point for &cRED &ateam"));
                    }
                }
            }
            if (args.length == 1 && args[0].equalsIgnoreCase("blue")) {
                if (!sender.hasPermission("blue.spawn")) {
                    p.sendMessage("You don't have permissoin to use this command!");
                } else {
                    main.getConfig().createSection("savedlocations." + p.getName());
                    main.getConfig().set("savedlocations." + Blue + ".x", loc.getX());
                    main.getConfig().set("savedlocations." + Blue + ".y", loc.getY());
                    main.getConfig().set("savedlocations." + Blue + ".z", loc.getZ());
                    main.getConfig().set("savedlocations." + Blue + ".pitch", l.getPitch());
                    main.getConfig().set("savedlocations." + Blue + ".yaw", l.getYaw());
                    main.saveConfig();
                    p.sendMessage(new ChatUtils(main).format("&aYou have set up spawn point for &9BLUE &ateam"));
                }

                    }
            if (args.length == 1 && args[0].equalsIgnoreCase("AdminTools")) {
                if (!sender.hasPermission("admin.tools")) {
                    p.sendMessage("You don't have permission to use admin tools!");
                } else {
                    p.getInventory().addItem(
                            new ItemBuilder(Material.BLUE_WOOL)
                                    .setName(SET_BLUE_SPAWN)
                                    .setLore("Make sure to look at the direction you want players to look when they spawn")
                                    .toItemStack());
                    p.getInventory().addItem(
                            new ItemBuilder(Material.RED_WOOL)
                                    .setName(SET_RED_SPAWN)
                                    .setLore("Make sure to look at the direction you want players to look when they spawn")
                                    .toItemStack());

                }

            }

        }
        return true;
    }
}
