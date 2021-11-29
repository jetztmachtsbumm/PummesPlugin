package de.pummes.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ColorHelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("§6Color codes:");
        sender.sendMessage("§4&4 - dunkelrot");
        sender.sendMessage("§c&c - rot");
        sender.sendMessage("§6&6 - gold");
        sender.sendMessage("§e&e - gelb");
        sender.sendMessage("§2&2 - dunkelgrün");
        sender.sendMessage("§a&a - grün");
        sender.sendMessage("§b&b - türkis");
        sender.sendMessage("§3&3 - dunkeltürkis");
        sender.sendMessage("§1&1 - dunkelblau");
        sender.sendMessage("§9&9 - blau");
        sender.sendMessage("§d&d - pink");
        sender.sendMessage("§5&5 - lila");
        sender.sendMessage("§f&f - weiß");
        sender.sendMessage("§7&7 - grau");
        sender.sendMessage("§8&8 - dunkelgrau");
        sender.sendMessage("§l&l - fett");
        sender.sendMessage("§m&m - durchgestrichen");
        sender.sendMessage("§n&n - unterstrichen");
        sender.sendMessage("§o&o - italic");
        return true;
    }
}
