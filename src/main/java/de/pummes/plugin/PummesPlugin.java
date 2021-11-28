package de.pummes.plugin;

import de.pummes.plugin.commands.CordsCommand;
import de.pummes.plugin.listeners.PlayerDeathListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class PummesPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);

        getCommand("cords").setExecutor(new CordsCommand());
    }

    @Override
    public void onDisable() {

    }

}
