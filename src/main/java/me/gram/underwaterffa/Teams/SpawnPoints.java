package me.gram.underwaterffa.Teams;

import me.gram.underwaterffa.UnderwaterFFA;
import me.gram.underwaterffa.Utils.ChatUtils;
import me.gram.underwaterffa.Utils.ItemBuilder;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;


public class SpawnPoints implements CommandExecutor, Listener {
    private UnderwaterFFA main;

    public SpawnPoints(UnderwaterFFA main) {
        this.main = main;
    }


    private final String SET_BLUE_SPAWN = new ChatUtils(main).format("&aSet &9Blue &aspawn point &7(Right Click)");
    private final String SET_RED_SPAWN = new ChatUtils(main).format("&aSet &cRed &aspawn point &7(Right Click)");


    String Red = "RedSpawn";
    String Blue = "BlueSpawn";


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            Location loc = p.getLocation();
            if (main.getConfig().getBoolean("enable")) {
                if (args.length == 1 && args[0].equalsIgnoreCase("red")) {
                    if (!sender.hasPermission("red.spawn")) {
                        p.sendMessage("You don't have permission to use this command!");
                    } else {
                        redSaveLocation(p);
                        p.sendMessage(new ChatUtils(main).format("&aYou have set up spawn point for &cRED &ateam"));
                    }
                }
            }
            if (args.length == 1 && args[0].equalsIgnoreCase("blue")) {
                if (!sender.hasPermission("blue.spawn")) {
                    p.sendMessage("You don't have permission to use this command!");
                } else {
                    blueSaveLocation(p);
                    p.sendMessage(new ChatUtils(main).format("&aYou have set up spawn point for &9BLUE &ateam"));
                }

            }

        }
        return true;
    }

    @EventHandler
    private void onInteract(PlayerInteractEvent event){
        if(!event.hasItem()) return;
        if(!event.getItem().hasItemMeta()) return;
        Player player = event.getPlayer();
        String itemname = event.getItem().getItemMeta().getDisplayName();
        if(itemname.equalsIgnoreCase(SET_BLUE_SPAWN)){
            blueSaveLocation(player);

        }else if(itemname.equalsIgnoreCase(SET_RED_SPAWN)){
            redSaveLocation(player);

        }else{
            return;
        }
        event.setCancelled(true);
    }

    public void redSaveLocation(Player player){
        Location loc = player.getLocation();
        main.getConfig().createSection("savedlocations." + Red);
        main.getConfig().set("savedlocations." + Red + ".world", loc.getWorld());
        main.getConfig().set("savedlocations." + Red + ".x", loc.getX());
        main.getConfig().set("savedlocations." + Red + ".y", loc.getY());
        main.getConfig().set("savedlocations." + Red + ".z", loc.getZ());
        main.getConfig().set("savedlocations." + Red + ".pitch", loc.getPitch());
        main.getConfig().set("savedlocations." + Red + ".yaw", loc.getYaw());
        main.saveConfig();
        player.sendMessage(new ChatUtils(main).format("&aYou have set up spawn point for &cRED &ateam"));
    }

    public void blueSaveLocation(Player player){
        Location loc = player.getLocation();
        main.getConfig().createSection("savedlocations." + Blue);
        main.getConfig().set("savedlocations." + Blue + ".world", loc.getWorld());
        main.getConfig().set("savedlocations." + Blue + ".x", loc.getX());
        main.getConfig().set("savedlocations." + Blue + ".y", loc.getY());
        main.getConfig().set("savedlocations." + Blue + ".z", loc.getZ());
        main.getConfig().set("savedlocations." + Blue + ".pitch", loc.getPitch());
        main.getConfig().set("savedlocations." + Blue + ".yaw", loc.getYaw());
        main.saveConfig();
        player.sendMessage(new ChatUtils(main).format("&aYou have set up spawn point for &9BLUE &ateam"));
    }

    public void teleportBlueSpawn(Player player){

        if(main.getConfig().isConfigurationSection("savedlocations." + Blue)){
            Location blue_spawn = new Location(player.getWorld(), main.getConfig().getDouble("savedlocations." + Blue + ".x"),
                    main.getConfig().getDouble("savedlocations." + Blue +  ".y"),
                    main.getConfig().getDouble("savedlocations." + Blue + ".z"),
                    (float) main.getConfig().getDouble("savedlocations." + Blue + ".yaw"),
                    (float) main.getConfig().getDouble("savedlocations." + Blue + ".pitch")
            );
                    player.teleport(blue_spawn);

        }
    }

    public void teleportRedSpawn(Player player) {

        if (main.getConfig().isConfigurationSection("savedlocations." + Red)) {
            Location red_spawn = new Location(player.getWorld(), main.getConfig().getDouble("savedlocations." + Red + ".x"),
                    main.getConfig().getDouble("savedlocations." + Red + ".y"),
                    main.getConfig().getDouble("savedlocations." + Red + ".z"),
                    (float) main.getConfig().getDouble("savedlocations." + Red + ".yaw"),
                    (float) main.getConfig().getDouble("savedlocations." + Red + ".pitch")
            );
            player.teleport(red_spawn);

        }
    }
}
