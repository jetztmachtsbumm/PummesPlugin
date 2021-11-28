package de.pummes.plugin;

import de.pummes.plugin.commands.ArschbohrerCommand;
import de.pummes.plugin.commands.CordsCommand;
import de.pummes.plugin.countdowns.ArschbohrerCountdown;
import de.pummes.plugin.listeners.PlayerDeathListener;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class PummesPlugin extends JavaPlugin {

    private final List<ArschbohrerCountdown> countdowns = new ArrayList<>();

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);

        getCommand("cords").setExecutor(new CordsCommand());
        getCommand("arschbohrer").setExecutor(new ArschbohrerCommand(this));
    }

    @Override
    public void onDisable() {

    }

    public ArschbohrerCountdown getCountdownOfPlayer(Player player){
        for(ArschbohrerCountdown countdown : countdowns){
            if(countdown.getPlayer() == player){
                return countdown;
            }
        }
        return null;
    }

    public boolean hasPlayerCountdown(Player player){
        for(ArschbohrerCountdown countdown : countdowns){
            if (countdown.getPlayer() == player) {
                return true;
            }
        }
        return false;
    }

    public List<ArschbohrerCountdown> getCountdowns() {
        return countdowns;
    }
}
