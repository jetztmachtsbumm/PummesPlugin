package de.pummes.plugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CordsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(args.length == 0){
                Location loc = player.getLocation();
                Bukkit.broadcastMessage("§6" + player.getName() + "'s §aKoordinaten sind: X: §6" + (int) loc.getX() + "§a Y: §6" + (int) loc.getY() + "§a Z: §6" + (int) loc.getZ());
            }else if(args.length == 1){
                if(Bukkit.getPlayer(args[0]) != null){
                    Player otherPlayer = Bukkit.getPlayer(args[0]);
                    Location loc = otherPlayer.getLocation();
                    player.sendMessage("§6" + otherPlayer.getName() + "'s §aKoordinaten sind: X: §6" + (int) loc.getX() + "§a Y: §6" + (int) loc.getY() + "§a Z: §6" + (int) loc.getZ());
                }else{
                    player.sendMessage("§cDer Spieler §6" + args[0] + "§c existiert nicht oder ist nicht online.");
                }
            }else{
                player.sendMessage("§cBenutze §6/cords <PLAYER>");
            }
        }else{
            sender.sendMessage("§cNur Spieler können diesen Command ausführen!");
        }
        return true;
    }
}
