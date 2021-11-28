package de.pummes.plugin.countdowns;

import de.pummes.plugin.PummesPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ArschbohrerCountdown {

    private final PummesPlugin plugin;
    private final Player player;

    private int seconds = 0;
    private int minutes = 60;
    private int taskID;

    public ArschbohrerCountdown(PummesPlugin plugin, Player player) {
        this.plugin = plugin;
        this.player = player;
        start();
    }

    public void start(){
        plugin.getCountdowns().add(this);
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            if(seconds == 0){
                if(minutes != 0){
                    minutes--;
                    seconds = 60;
                }else{
                    plugin.getCountdowns().remove(this);
                    stop();
                }
            }
            seconds--;
        }, 0, 20);
    }

    private void stop(){
        Bukkit.getScheduler().cancelTask(taskID);
    }

    public Player getPlayer() {
        return player;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMinutes() {
        return minutes;
    }
}
