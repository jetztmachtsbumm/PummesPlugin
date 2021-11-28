package de.pummes.plugin.commands;

import de.pummes.plugin.PummesPlugin;
import de.pummes.plugin.countdowns.ArschbohrerCountdown;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class ArschbohrerCommand implements CommandExecutor {

    private final PummesPlugin plugin;

    public ArschbohrerCommand(PummesPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(args.length == 1){
                if(!plugin.hasPlayerCountdown(player)) {
                    if (Bukkit.getPlayer(args[0]) != null) {
                        Player otherPlayer = Bukkit.getPlayer(args[0]);
                        Vector vector = otherPlayer.getLocation().getDirection();
                        vector.setY(0.4);
                        otherPlayer.setVelocity(vector);
                        otherPlayer.damage(1);
                        otherPlayer.sendMessage("§6" + player.getName() + "§c hat dir einen §dArschbohrer §cgegeben!");
                        player.sendMessage("§aDu hast §6" + otherPlayer.getName() + "§a einen §dArschbohrer §agegeben!");
                        new ArschbohrerCountdown(plugin, player);
                    } else {
                        player.sendMessage("§cDer Spieler §6" + args[0] + "§c existiert nicht oder ist nicht online!");
                    }
                }else{
                    String message;
                    if(plugin.getCountdownOfPlayer(player).getSeconds() < 10){
                        message = "§cDu kannst den §dArschbohrer §cerst in §6" + plugin.getCountdownOfPlayer(player).getMinutes() + ":0" + plugin.getCountdownOfPlayer(player).getSeconds() + "§c wieder benutzen!";
                    }else {
                        message = "§cDu kannst den §dArschbohrer §cerst in §6" + plugin.getCountdownOfPlayer(player).getMinutes() + ":" + plugin.getCountdownOfPlayer(player).getSeconds() + "§c wieder benutzen!";
                    }
                    player.sendMessage(message);
                }
            }else{
                player.sendMessage("§cBenutze §6/arschbohrer <PLAYER>");
            }
        }else{
            sender.sendMessage("§cNur Spieler können diesen Command ausführen!");
        }
        return true;
    }
}
