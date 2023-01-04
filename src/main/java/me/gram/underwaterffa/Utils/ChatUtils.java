package me.gram.underwaterffa.Utils;

import me.gram.underwaterffa.UnderwaterFFA;
import net.md_5.bungee.api.ChatColor;

public class ChatUtils {
    private UnderwaterFFA main;
    public ChatUtils(UnderwaterFFA main) {
        this.main = main;
    }

    public String format(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public String permission = format("&cYou do not have permission to access this command.");
    public String prefix = format("&8[&bFFA&8] &e");
}

